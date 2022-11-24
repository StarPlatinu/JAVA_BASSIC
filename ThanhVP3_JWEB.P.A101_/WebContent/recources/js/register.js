var check = document.getElementById("register")
check.addEventListener("click",function () {
    var checkUserName = document.getElementById("username").value
    var checkEmail = document.getElementById("email").value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/
    var checkPassword = document.getElementById("password").value
    var checkRePassword = document.getElementById("re-password").value

    if (checkEmail=="" && checkPassword == "" && checkUserName ==""
    && checkRePassword=="" && checkPassword =="") {
        document.getElementById("username").style.borderColor = "red";
        document.getElementById("email").style.borderColor = "red";
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("re-password").style.borderColor = "red";

        document.getElementById("error_msg_username").innerHTML = 'Username is invalid';
        document.getElementById("error_msg_email").innerHTML = 'Email is invalid';
        document.getElementById("error_msg_password").innerHTML = 'Password is invalid';
        document.getElementById("error_msg_re-password").innerHTML = 'Re-password is invalid';

    }
     if(checkUserName == "") {
        document.getElementById("username").style.borderColor = "red";
    } 
     if (checkEmail == "" || checkEmail.match(mailformat)==false) {
        document.getElementById("email").style.borderColor = "red";
    } 
     if (checkPassword == "") {
        document.getElementById("password").style.borderColor = "red";
    } 
    if (checkRePassword == "") {
        document.getElementById("re-password").style.borderColor = "red";
    } 
     if (checkRePassword !== checkPassword) {
         document.getElementById("error_msg_re-password").innerHTML = 'Repassword not match with password';
         document.getElementById("password").style.borderColor = "red";
         document.getElementById("re-password").style.borderColor = "red";
     } 

})