<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/style.css" rel="stylesheet">

<title>Log in</title>
</head>
<body>
<div class="bgr">
   <form action="<%=request.getContextPath()%>/register" method="POST">
     <div class="container">
        <div class="row">
            <div class="col" style="width:100px;">
            <b>User Name</b>
            </div>
            <div class="col">
               <input type="text" placeholder="Enter your username" name="username" required>
            </div>
        </div>
        
        <div class="row">
           <div class="col">
            <b>Password</b>
           </div>
           <div class="col">
              <input type="password" placeholder="Enter your password" name="password" required>
           </div>
           </div>
           
            <div class="row">
            <div class="col" style="width:100px;">
            <b>First Name</b>
            </div>
            <div class="col">
               <input type="text" placeholder="Enter your first name" name="firstname">
            </div>
        </div>
        
        
                    <div class="row">
            <div class="col" style="width:100px;">
            <b>Last Name</b>
            </div>
            <div class="col">
               <input type="text" placeholder="Enter your last name" name="lastname">
            </div>
        </div>
        
             <div class="row">
            <div class="col" style="width:100px;">
            <b>Email</b>
            </div>
            <div class="col">
               <input type="text" placeholder="Enter your email" name="email">
            </div>
        </div>
        
        
           
        <div class="row">
           <div class="col"></div>
           <div class="col">
               <button type="submit">Register</button>  
           </div>
        </div>
        
        
                <div class="row">
           <div class="col"></div>
           <div class="col">
               <span id="successMessage"><b>${messages.success}</b></span>
           </div>
        </div>
     
     </div>
   </form>


</div>

        <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>

</body>
<a href="<%=request.getContextPath()%>/home">Home page</a>
</html>
