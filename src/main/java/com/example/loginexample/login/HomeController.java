package com.example.loginexample.login;

import com.example.loginexample.user.User;
import com.example.loginexample.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    // get request to get the login form page
    @GetMapping(value = "/login")
    public String gotoLoginPage() {
        return "login";
    }

    // post request when user click on submit
    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password, ModelMap model) {
        User user = userRepository.findByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        // check if username and password are valid
        if (userRepository.existsByUsername(username) && encoder.matches(password, user.getPassword())) {

            model.put("name", user.getName());
            model.put("username", user.getUsername());
            model.put("role", user.getRole());

            // show manager link, if account is an manager
            if (user.getRole().equals("Manager")) {
                model.put("link", "Manager Link");
            } else {
                model.put("link", "");
            }
            return "welcome";
        } else {
            model.put("errorMessage", "Invalid userID or password");
            return "login";
        }
    }

    // get request for manager page
    @GetMapping(value = "/manager")
    public String goToListTodos() {
        return "manager";
    }

}