<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

    <title>Welcome Page</title>
</head>
<body>
<div class="container">
    <h1>Welcome</h1>
    <h1>Name: ${name}</h1>
    <h1>Username: ${username}</h1>
    <h1>Role: ${role}</h1>
    <a href="/manager">${link}</a>
</div>

<%@ include file="common/footer.jspf" %>