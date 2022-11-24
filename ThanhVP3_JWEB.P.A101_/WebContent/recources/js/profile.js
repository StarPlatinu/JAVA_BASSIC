function checkInput(){
    var cfirstname =  document.getElementById("firstname").value;
    var clastname = document.getElementById("lastname").value;
    var cphone = document.getElementById("phone").value;
    // var cdescription = document.getElementById("decription").value;
   
    if(cfirstname == "" && clastname == "" && cphone == "" ){
    document.getElementById("firstname").classList.add('bcolor-red');
    document.getElementById("lastname").classList.add('bcolor-red');
    document.getElementById("phone").classList.add('bcolor-red');
    // document.getElementById("decription").style.borderColor = "red";

    document.getElementById("error_msg_firstname").innerHTML = 'First name is invalid';
    document.getElementById("error_msg_firstname").style.color ="red";

    document.getElementById("error_msg_lastname").innerHTML = 'Last name is invalid';
    document.getElementById("error_msg_lastname").style.color ="red";

    document.getElementById("error_msg_phone").innerHTML = 'Phone is invalid';
    document.getElementById("error_msg_phone").style.color ="red";
    }

}
