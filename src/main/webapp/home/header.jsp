<%@page import="squad.model.Users"%>
<!-- Bootstrap -->
<link href="css/style.css" rel="stylesheet">

<div id="header">
<div style="text-align:center; font-size:35px;color:white;">${CAPTION}</div>
<div style="position:fixed;right:50px;top:10px;color:white;">Hello <%=((Users)session.getAttribute("CURRENT_USER")).getUserName()%></div>
<%-- <%=((Users)session.getAttribute("CURRENT_USER")).getUserName()%> --%>
<div style="position:fixed;right:30px;top:10px;color:white;"><a href="<%=request.getContextPath()%>/logout">Logout</a></div>

</div>