function checkInput(){
    var ctitle =  document.getElementById("title").value;
    var cbrief = document.getElementById("brief").value;
    var ccontent = document.getElementById("content").value;
    // var cdescription = document.getElementById("decription").value;
   
    if(ctitle == "" && cbrief == "" && ccontent == "" ){
    document.getElementById("title").classList.add('bcolor-red');
    document.getElementById("brief").classList.add('bcolor-red');
    document.getElementById("content").classList.add('bcolor-red');
    // document.getElementById("decription").style.borderColor = "red";

    document.getElementById("error_msg_title").innerHTML = 'Title is invalid';
    document.getElementById("error_msg_title").style.color ="red";

    document.getElementById("error_msg_brief").innerHTML = 'Brief is required';
    document.getElementById("error_msg_brief").style.color ="red";

    document.getElementById("error_msg_content").innerHTML = 'Content is required';
    document.getElementById("error_msg_content").style.color ="red";
    }

}