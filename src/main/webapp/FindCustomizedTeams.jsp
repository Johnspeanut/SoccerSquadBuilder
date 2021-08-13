<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="squad.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Find Customized Teams</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <br></br>
	<form action="findcustomizedteams" method="post">
		<h2 style="font-size:25px;" class="alert alert-success">Search for Customized Teams</h2>
		<br></br>
		<p>
		<% Users user = (Users)request.getSession().getAttribute("CURRENT_USER");%>
		<% String default_username = (String)user.getUserName();%>
			<label for="username">UserName</label>
<%-- 			<td><c:out value="${param.partnerName}" default="Unknown name" /></td> --%>
			<input id="username" name="username" value="${default_username}">
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-success">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
		
		<br></br>
        <a style="font-size:20px;" href="createcustomizedteam">Create a customized team</a> 
        </form>
        <br></br>
	
	<h2 style="font-size:25px;" class="alert alert-success">Matching Customized Teams</h2>
    <div>
        <table border="1" class="table table-striped">
            <tr>
                <th>UserName</th>
                <th>TeamId</th>
                <th>View Team</th>
                <th>Edit Team</th>
                <th>Delete Team</th>
            </tr>
               <c:forEach items="${customizedTeams}" var="customizedTeam" >
                <tr>
                    <td><c:out value="${customizedTeam.getUser().getUserName()}" /></td>
                    <td><c:out value="${customizedTeam.getTeam_id()}" /></td>
                    <td><a href="readcustomizedteam?customizedTeamId=<c:out value="${customizedTeam.getTeam_id()}"/>">View</a></td>
                    <td><a href="editcustomizedteam?customizedTeamId=<c:out value="${customizedTeam.getTeam_id()}"/>">Edit</a></td>
                    <td><a href="deletecustomizedteams?customizedTeamId=<c:out value="${customizedTeam.getTeam_id()}"/>">Delete</a></td>
                </tr>
            </c:forEach>
       </table>
    </div>
<!--      <span class="alert alert-success">
    <a class="nav nav-tabs" href="createcustomizedteam">Create My Own Team Now</a>
    </span>
     <br></br>
    <a href="queryplayers">Query Players</a> -->
     </div>
    <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
 <jsp:include page="footer.jsp"/>
</body>
</html>