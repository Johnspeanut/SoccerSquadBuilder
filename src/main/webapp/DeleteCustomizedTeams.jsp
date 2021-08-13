<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete a Customized Team</title>
</head>
<body>
<jsp:include page="header.jsp"/>
    <h2 style="font-size:25px;" class="alert alert-success">${messages.title}</h2>
	<form action="deletecustomizedteams" method="post">
		<p>
			<div <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
				<label for="teamId">TeamId</label>
				<input id="teamId" name="teamId" value="${fn:escapeXml(param.customizedTeamId)}">
			</div>
		</p>
		<p>
			<span id="submitButton" <c:if test="${messages.disableSubmit}">style="display:none"</c:if>>
			<input type="submit">
			</span>
		</p>
	</form>
	<br/><br/>
	
</body>
 <jsp:include page="footer.jsp"/>
</html>