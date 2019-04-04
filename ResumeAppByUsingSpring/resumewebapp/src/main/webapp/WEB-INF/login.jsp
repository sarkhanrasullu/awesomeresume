<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Admin Login</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>
<body class="login_background">

    <form action="login" method="POST">
        <div class="col-4 container login_fix_">
            <center>
                <h1>Login:</h1>
            </center>
            <div class="form-group">
                <label>Email address</label>
                <input type="text" class="fadeIn second" name="username" placeholder="Username"/>
            </div>
            <div class="form-group">
                <label>Password</label>
                <input type="password"  class="fadeIn third" name="password" placeholder="Password"/>
            </div>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}" />

            <button type="submit" class="btn btn-primary" name="login">Login</button>
        </div>
    </form>

</body>
</html>