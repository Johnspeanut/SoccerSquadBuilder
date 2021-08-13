<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>All Players</title>
    <style>
.flex-parent {
  display: flex;
}

.jc-center {
  justify-content: center;
}

button.margin-right {
  margin-right: 20px;
}
    </style>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container theme-showcase" role="main">

<h2 style="font-size:25px;" class="alert alert-success">Query Players</h2>
     <br></br>
     
     <div class="flex-parent jc-center">
     	<form action="queryplayers" method="post">
		<p>
			<label for="playername" class="alert alert-success">PlayerName</label>
			<span class="alert alert-success">
			<input id="playername" name="playername" value="${fn:escapeXml(param.playername)}">
			</span>
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-success">
			<br/><br/><br/>
			<span id="successMessage"><b>${messages.success}</b></span>
		</p>
	</form>
	
		<form action="queryplayers" method="post">
		<p>
		
		<label for="sortby" class="alert alert-success">Sort by:</label>
            <span class="alert alert-success">
			<select name="sortby" id="sortby">
			    <option value="">--Please choose a filter--</option>
			    <option value="name">Name(A-Z)</option>
			    <option value="age">Age(Old-Young)</option>
			    <option value="wage">Wage(High-Low)</option>
			    <option value="rating">Rating(High-Low)</option>
			</select>
			</span>
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-success">
			<br/><br/><br/>
		</p>
	</form>
	
		<form action="queryplayers" method="post">
		<p>
		<label for="popularsearch" class="alert alert-success">Popular Searches:</label>
            <span class="alert alert-success">
			<select name="popularsearch" id="popularsearch">
			    <option value="">--Please choose a category--</option>
			    <option value="top20forwards">Top 20 forwards</option>
			    <option value="top20midfields">Top 20 middle field players</option>
			    <option value="top20defenders">Top 20 defenders</option>
			    <option value="top20goalkeepers">Top 20 goalkeepers</option>
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
	<h2 style="font-size:25px;">Player Query Results</h2>
	</div>
        <table border="1" class="table table-striped">
            <tr>
                <th>PlayerName</th>
                <th>DOB</th>
                <th>Position</th>
                <th>Value($)</th>
                <th>Wage($)</th>
                <th>Overall Rating</th>
                <th>Team</th>
                <th>Nationality</th>
            </tr>
            <c:forEach items="${players}" var="player" >
                <tr>
                    <td><a href="<c:out value="${player.getProfile()}"/>">${player.getPlayer_name()}</a></td>
                    <td><fmt:formatDate value="${player.getDate_of_birth()}" pattern="yyyy-MM-dd"/></td>
                    <td><c:out value="${player.getBest_position()}" /></td>
                    <td><c:out value="${player.getValue()}" /></td>
                    <td><c:out value="${player.getWage()}" /></td>
                    <td><c:out value="${player.getOverall_rating()}" /></td>
                    <td><a href="<c:out value="${player.getTeamUrl()}"/>">${player.getTeamName()}</a></td>
                    <td><c:out value="${player.getNationality()}" /></td>
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