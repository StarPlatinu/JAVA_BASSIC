
var check = document.getElementById("login");
check.addEventListener("click",function () {
    var checkEmail = document.getElementById("email").value;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
    var checkPassword = document.getElementById("password").value;

    if(checkEmail == ""&&checkPassword == ""){
        document.getElementById("email").style.borderColor = "red";
        document.getElementById("password").style.borderColor = "red";
        
        document.getElementById("error_msg_email").innerHTML = 'Email is invalid';
        document.getElementById("error_msg_password").innerHTML = 'Password is incorrect';
    }

     if (checkEmail.match(mailformat) && checkPassword !="") {
        document.getElementById("email").style.borderColor = "green";
        document.getElementById("error_msg_email").style.display = 'none';
        document.getElementById("error_msg_password").style.display = 'none';
        setTimeout(function(){ 
            location.replace("http://127.0.0.1:5501/views/loading.jsp");
          }, 2000);
       
    } 
    if (checkEmail.match(mailformat) && checkPassword !== ""&&checkPassword == "") {
        document.getElementById("email").style.borderColor = "green";
        document.getElementById("password").style.borderColor = "red";

    } 
     if (checkEmail == "" || checkEmail.match(mailformat)==false) {
        document.getElementById("email").style.borderColor = "red";
    } 
    if(checkPassword != ""){
        document.getElementById("password").style.borderColor = "green";
    }
     if (checkPassword == "") {   
        document.getElementById("password").style.borderColor = "red";
    }

   

})

