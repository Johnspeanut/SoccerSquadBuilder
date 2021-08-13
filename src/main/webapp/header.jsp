<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="squad.model.Users"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<!-- <link href="css/style.css" rel="stylesheet"> -->
<title>All Teams</title>
    <style>
.flex-parent {
  display: flex;
}

.jc-between {
  justify-content: space-between;
}

button.margin-right {
  margin-right: 20px;
}

.active{
color:red;
}
    </style>

<script>
function myFunction(elmnt,clr) {
	  elmnt.style.color = clr;
	}
</script>
</head>
<body>
<div class="container theme-showcase" role="main">
<div style="color:green;font-size:20px;" class="page-header"><h1>Soccer Squad Builder</h1></div>

<div class="tagtable" class="menu">
<ul class="nav nav-pills" role="tablist">
<!-- <li class="presentation">
<a style="font-size:25px;" href="createcustomizedteam">Create Customized Teams</a>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp
</li> -->
<li role="presentation">
<a style="font-size:25px;" href="queryplayers" onclick="myFunction(this, 'red')">Query Players</a>  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp
</li>
<li role="presentation">
<a style="font-size:25px;"  href="findteams" onclick="myFunction(this, 'red')">Query Teams</a> &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp
</li>
<li class="presentation">
<a style="font-size:25px;"  href="findcustomizedteams" onclick="myFunction(this, 'red')">Customized Team</a>  &nbsp  &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp  &nbsp &nbsp &nbsp &nbsp
</li>

<li role="presentation">
<% Users user = (Users)request.getSession().getAttribute("CURRENT_USER");
   if(user ==null) {%>
   <a style="font-size:15px;">Hello  visitor</a> &nbsp &nbsp
 <%
 } else{ 
 %>
<a style="font-size:15px;">Hello <%=user.getUserName()%></a> &nbsp &nbsp 
<%
 }
%>
</li>

<li role="presentation">
<a style="font-size:15px;" href="login.jsp">Login</a></a> &nbsp &nbsp
</li>

<li role="presentation">
<a style="font-size:15px;"><a href="<%=request.getContextPath()%>/logout">Logout</a></a> &nbsp &nbsp
</li>

<li role="presentation">
<a style="font-size:15px;" href="register.jsp">Register</a></a>
</li>

</ul>
</div>

    <br></br>
     
    <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>



<%-- <div id="nav" class="vmenu">
     <a class="menu_link${HOME}" href="<%=request.getContextPath()%>/home">Home Page</a>
     <a class="menu_link${UM}" href="<%=request.getContextPath()%>/usermanagement?action=list">Link 1</a>
     <a class="menu_link" href="#">Link 2</a>
     <a class="menu_link" href="#">Link 3</a>
</div>

<script>
    // Add active class to the current button (highlight it)
    var header = document.getElementById("nav");
    var links = header.getElementsByClassName("menu_link");
    for (var i = 0; i < links.length; i++){
    	links[i].addEventListener("click", function(){
    		var current = document.getElementsByClassName("active");
    		current[0].className=current[0].className.replace(" active", "");
    		this.className += " active";
    	});
    }
</script>
 --%>


