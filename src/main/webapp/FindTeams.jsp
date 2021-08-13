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
<link href="css/bootstrap.min.css" rel="stylesheet">
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
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<h2 style="font-size:25px;" class="alert alert-success">Query Teams</h2>
     <br></br>
     
<div class="flex-parent jc-between">
     	<form action="findteams" method="post">
		<p>
			<label for="teamname" class="alert alert-success">Team Name</label>
			<span class="alert alert-success">
			<input id="teamname" name="teamname" value="${fn:escapeXml(param.teamname)}">
			</span>
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-success">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	
	
		<form action="findteams" method="post">
		<p>
		
		<label for="sortby" class="alert alert-success">Sort by:</label>
            <span class="alert alert-success">
			<select name="sortby" id="sortby">
			    <option value="">--Please choose a filter--</option>
			    <option value="name">Name(A-Z)</option>
			    <option value="defence">Defence Score(High-Low)</option>
			    <option value="attack">Attack(High-Low)</option>
			    <option value="score">Overall Score(High-Low)</option>
			    <option value="transferbudget">Transfer Budget(High-Low)</option>
			</select>
			</span>
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-success">
			<br/><br/><br/>
		</p>
	</form>
    </div>


	
	<div class="alert alert-success" role="alert">
	<h2>Team Query Results</h2>
	</div>
        <table border="1" class="table table-striped">
            <tr>
                <th>TeamName</th>
                <th>Overall Score</th>
                <th>Defence Rating</th>
                <th>Attack Rating</th>
                <th>International Prestige</th>
                <th>Transfer Budget($)</th>
                <th>League</th>
            </tr>
            <c:forEach items="${Teams}" var="Team" >
                <tr>
                <td><a href="<c:out value="${Team.getTeam_url()}"/>">${Team.getTeam_name()}</a></td>
                    <td><c:out value="${Team.getOverall()}" /></td>
                    <td><c:out value="${Team.getDefence()}" /></td>
                    <td><c:out value="${Team.getAttack()}" /></td>
                    <td><c:out value="${Team.getInternational_prestige()}" /></td>
                    <td><c:out value="${Team.getTransfer_budget()}" /></td>
                    <td><c:out value="${Team.getLeague()}" /></td>
                </tr>
            </c:forEach>
       </table>
    <br></br>
    </div>
    
    <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
 <jsp:include page="footer.jsp"/>
</body>
</html>
