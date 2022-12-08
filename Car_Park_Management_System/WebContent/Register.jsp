<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <!-- Required meta tags -->
	  <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <link rel="stylesheet" href="static/css/register.css">
      <!-- Font Awseome -->
      <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	  <!-- Bootstrap CSS -->
	  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Login</title>
</head>
<body>
<section class="h-100 bg-dark">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col">
        <div class="card card-registration my-4">
          <div class="row g-0">
            <div class="col-xl-6 d-none d-xl-block">
              <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-registration/img4.webp"
                alt="Sample photo" class="img-fluid"
                style="border-top-left-radius: .25rem; border-bottom-left-radius: .25rem;" />
            </div>
            <div class="col-xl-6">
              <div class="card-body p-md-5 text-black">
                <h3 class="mb-5 text-uppercase">Employee registration form</h3>

                 <form action="register" method="post">
                <div class="form-outline mb-1">
                  <input name="account" type="text" class="form-control form-control-lg" maxlength="50"/>
                  <label class="form-label" >Account</label>
                </div>
                
                 <div class="form-outline mb-1">
                  <input name="department" type="text" class="form-control form-control-lg" maxlength="10"/>
                  <label class="form-label" >Department</label>
                </div>
                
                <div class="form-outline mb-1">
                  <input name="address" type="text" class="form-control form-control-lg" maxlength="50"/>
                  <label class="form-label" >Employee Address</label>
                </div>
                
                <div class="d-md-flex justify-content-start align-items-center mb-1 py-2">

                  <h6 class="mb-0 me-4 mr-2">Sex: </h6>

                  <div class="form-check form-check-inline mb-1 me-1">
                    <input class="form-check-input" type="radio" name="gender" id="femaleGender"
                      value="F" />
                    <label class="form-check-label" for="femaleGender">Female</label>
                  </div>

                  <div class="form-check form-check-inline mb-1 me-1">
                    <input class="form-check-input" type="radio" name="gender" id="maleGender"
                      value="M" />
                    <label class="form-check-label" >Male</label>
                  </div>

                </div>

                <div class="form-outline mb-1 mt-1">
                  <input name="birthdate" type="date"  class="form-control form-control-lg" />
                  <label class="form-label" >Employee Birthdate</label>
                </div>

                <div class="form-outline mb-1">
                  <input name="email" type="text"  class="form-control form-control-lg" maxlength="50" required />
                  <label class="form-label" >Employee Email</label>
                </div>
                
                <div class="form-outline mb-1">
                  <input name="name" type="text"  class="form-control form-control-lg" maxlength="50" required />
                  <label class="form-label" >Employee Name</label>
                </div>

                 <div class="form-outline mb-1">
                  <input name="phone" type="text"  class="form-control form-control-lg" maxlength="10" required />
                  <label class="form-label" >Employee Phone</label>
                </div>
                
                 <div class="form-outline mb-1">
                  <input name="password" type="text"  class="form-control form-control-lg" maxlength="20" required />
                  <label class="form-label" >Password</label>
                </div>
                
                   <div class="form-outline mb-1">
                  <input name="repasssword" type="text"  class="form-control form-control-lg" maxlength="20" required />
                  <label class="form-label" >RePassword</label>
                </div>
                
                 <div class="form-outline mb-1">
                  <input type="number" class="form-control form-control-lg" min="1" max="2"/>
                  <label class="form-label" >Role</label>
                </div>

                <div class="d-flex justify-content-end pt-3">
                  <button type="button" class="btn btn-light btn-lg">Reset all</button>
                  <button type="button" class="btn btn-warning btn-lg ms-2">Submit form</button>
                </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
 <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>
</html>