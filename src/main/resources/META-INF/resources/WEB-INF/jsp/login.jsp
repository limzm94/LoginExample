<%@ include file="common/header.jspf" %>

    <title>Login Page</title>
</head>
<body>

<div class="container">
    <h1>Login</h1>
    <pre>${errorMessage}</pre>
    <form method="post">
        Name: <input type="text" name="username">
        Password: <input type="password" name="password">
        <input type="submit">
    </form>
</div>

<%@ include file="common/footer.jspf" %>