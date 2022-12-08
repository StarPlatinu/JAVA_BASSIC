<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Account"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>TRansfer</title>
      <style>
        body{
            border: 1px solid black;
            height: 700px;
            width:99%;
              border-top:none;
            margin:auto;
        }
        
    </style>
  </head>
  <body>
  <%@include file="navbar.jsp" %>
  <div class="container mt-5">
    <div class="row">
      <div class="col-md-3" id="left">
       <div class="container">
        <div class="col-md-10 mt-2">
         <h1>${accname}</h1>
        </div>
        <div class="col-md-10" >
          <a href="transfer">Transfer</a><br>
          <a href="logout">Logout</a>
        </div>

       </div>
      </div>
      <div class="col-md-9 mt-3" id="right">
        <form action = "transfer" method="post">
      
            <div class="form-group">
              <label"><b>Your Balance</b></label>
              <input type="number" class="form-control" name="balance" id="balance" value="${balance}"  required>
            </div>
            <div class="form-group">
              <label><b>Enter amount</b> <span style="color: red;" id="amount_err">${err}</span></label>
              <input type="number" class="form-control" name="amount" id="amount" placeholder="Enter Amount" required>
            </div>
            <div class="form-group">
              <label ><b>Select account to transfer</b></label>
              <select id="acctransfer" class="form-control" name="acctransfer">
               
                	<%
									List<Account> list = new ArrayList<>();
									list = (List<Account>) request.getAttribute("list");
									for (Account el : list) {
									%>
									 <option value="<%=el.getAccount() %>"><%=el.getAccount() %></option>
									<%
									}
									%>
              </select>
            </div>   
    
            <div class="form-group">
              <label><b>Transaction note</b></label>
              <textarea class="form-control" name="note" id="" rows="3"></textarea>
            </div>
          
          <button type="submit" class="btn btn-light">transfer</button>
        </form>
      </div>
    </div>
  </div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
  </body>
</html>