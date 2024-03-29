<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <title>Profile</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../recources/css/profile.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
  </head>
  <body>  
         <%@include file="includes/navbar.jsp" %>
      <main>
        <div class="row w-100">

          <!-- Left menu  -->
          <div class="col-sm-3 bg-light p-0 border">
            <div class="bg-light border">
              <div class="row mt-3 mb-3 justify-content-center">
                <div class="col-sm-7 p-0"><input class="border rounded p-1 pr-5 w-100" type="text" name="search" placeholder="Search..."></div>
                <div id="search-button" class="col-sm-1 bg-white border-top-0 rounded p-0"><i class="fa fa-search p-2"></i></div>
              </div>
            </div>

            <div id="view-content-btn" class="border p-2 pl-4 text-info">
              <i class="far fa-list-alt"></i><span><a href="viewcontent" id="view-content"> View contents</a></span>
            </div>

            <div id="form-content-btn" class="border p-2 pl-4 text-info">
              <i class="far fa-edit"></i><span> <a href="formcontent" id="form-content"> Form-content</a></span>
            </div>
          </div> 

          <!-- Right content  -->

            <!-- Edit profile  -->
          <div class="col-sm-9">
            <div id="edit-profile">
              <h2 class="pt-4">Edit Profile</h2>
              <hr class="border">
              <div class="profile-form border rounded">
                <div id="profile-header" class="bg-light border p-2">
                  <span class="">Profile Form Elements</span>
                </div>
                <form action="profile" method="post" id="profile-input" class="bg-white border p-3">
                  <div class="input-firstname pb-2">
                    <label id="error_msg_firstname" for=""><b> First Name</b></label><br>
                    <input name="firstname" class="p-1 border rounded" type="text" id="firstname" placeholder="Enter the first name" required minlength="3" maxlength="30">
                  </div>
                  <div class="input-lasttname pb-2">
                    <label id="error_msg_lastname" for=""><b> Last Name</b></label><br>
                    <input name="lastname" class="p-1 border rounded" type="text" id="lastname" placeholder="Enter the last name" required minlength="3" maxlength="30">
                  </div>
                  <div class="input-email pb-2">
                    <label for="" id="error_msg_email"><b> Email</b></label><br>
                    <input name="email" class="p-1 border-0 text-dark" type="text" id="email" placeholder="your_email@example.com">
                  </div>
                  <div class="input-Phonenumber pb-2">
                    <label for="F" id="error_msg_phone"><b> Phone</b></label><br>
                    <input name="phone" class="p-1 border rounded" type="text" id="phone" placeholder="Enter your phone number" required minlength="9" maxlength="13">
                  </div>
                  <div class="input-decription pb-2">
                    <label id="error_msg_description" for=""><b> Decription</b></label><br>
                    <textarea class="w-75" name="decription" id="decription"  maxlength="200"></textarea>
                  </div>
                  <!-- Button  -->
                  <br>
                    <button id="sumit1" class="btn  btn-light" onclick="checkInput()">Submit Button</button>
                    <button id="reset1" class="btn  btn-light p-2" type="reset">Reset Button</button>
                </form>
              </div>
            </div>   
          </div>
          

            <!-- Add content -->
                <!-- Button  -->         
            <!-- View content -->
        <!-- End Right Content -->
        </div>

      </main>
    <!-- Optional JavaScript -->
    <!-- <script src="../resources/js/add-content.js"></script> -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
 <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script src="../recources/js/profile.js"></script>
  </body>
</html>