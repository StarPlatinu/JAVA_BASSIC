<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="recources/css/login.css">
</head>
<body>
    <div class="login-table">
        <p class="sign-in">
            Please Sign In
        </p>
     <form action="login" method = "post">
          <div class="login-box">
            <div id="input-email">
                <label id="error_msg_email" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input value="${email}" name = "email" id="email" type="text" placeholder="E-mail" required minlength="5" maxlength="50">
            </div>
            <div id="input-password_password">
                <label id="error_msg_password" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input value="${password}" name = "password" id="password" type="password" placeholder="Password" required minlength="8" maxlength="30">
            </div>
            <div class="check-box">
                <input type="checkbox"><label for="">Remember me</label>
            </div>
            <div id="login" class="btn-login">
                <button type = "submit">Login</button>
            </div>
            <div id="register" class="register" >
                <a  href="register.jsp">Click here to Register</a>
            </div>
        </div>
     </form>
    </div>
<script src="recources/js/login.js"></script>
</body>
</html>