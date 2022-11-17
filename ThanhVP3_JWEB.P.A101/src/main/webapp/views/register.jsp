<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" href="../recources/css/register.css">
</head>
<body>
    <div class="register-table">
        <p class="register">
            Register
        </p>
        <div class="register-box">
            <div class="w-75">
                <label id="error_msg_username" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input id="username"type="text" placeholder="User name" minlength="3" maxlength="30">
                <label id="error_msg_email" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input id="email" type="text" placeholder="E-mail" minlength="5">
                <label id="error_msg_password" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input id="password" type="password" placeholder="Password" minlength="8" maxlength="30">
                <label id="error_msg_re-password" style="color:red;display: block;margin: 10px 0px 0px 10px;"></label>
                <input id="re-password" type="password" placeholder="Re Password" minlength="8" maxlength="30">
            </div>
            <div id="register" class="btn-register" >
                <span>Register</span>
            </div>
            <div class="login" >
                <a  href="views/login.jsp">Click here to login</a>
            </div>
        </div>
    </div>
    <script src="../recources/js/register.js"></script>
</body>
</html>