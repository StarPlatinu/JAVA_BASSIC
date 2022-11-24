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
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="../recources/css/profile.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.1/jquery.validate.min.js"></script>
  </head>
  <body>
    
    
      <header class="w-100 bg-light border border-5 border-bottom-secondary">
          <div class="d-flex justify-content-between p-2">
              <span id="backto-edit" class="text-secondary text-uppercase">cms</span>
              <div class="user-option">
                    <a id="option-button" class="option-button p-2" href="#"><i class="fas fa-user"></i><i class="fas fa-caret-down"></i></a>
                    <ul id="option" class="option shadow-sm bg-white rounded d-none">
                        <li class="option-item border border-top-1"><a href="" class="option-link"><i class="fas fa-user"></i><span> User profile</span></a></li>
                        <li class="option-item border border-top-1"><a href="" class="option-link"><i class="fas fa-sign-out-alt"></i> Logout</a></li>
                    </ul>
              </div>
          </div>
      </header>

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
              <i class="far fa-list-alt"></i><span><a href="view-content.html"> View contents</a></span>
            </div>

            <div id="form-content-btn" class="border p-2 pl-4 text-info">
              <i class="far fa-edit"></i><span> <a href="form-content.html"> Form-content</a></span>
            </div>
          </div> 

          <!-- Right content  -->

            <!-- Edit profile  -->
          <div class="col-sm-9" style="height: 700px;">
            <div id="edit-profile">
                <script>
                    setTimeout(function(){
                       window.location.href = 'http://127.0.0.1:5501/views/profile.html';
                    }, 5000);
                 </script>
              <h2 class="pt-4">Loading....</h2>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js">
    // <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    <script src="../recources/js/profile.js"></script>
  </body>
</html>