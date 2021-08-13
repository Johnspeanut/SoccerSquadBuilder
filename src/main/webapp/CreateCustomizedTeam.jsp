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

<h2 style="font-size:25px;" class="alert alert-success">Create a Team</h2>
    <img src="field.jpeg">
    <form action="createcustomizedteam" method="post">
        <p>
            <label for="username">UserName</label>
            <input id="username" name="username" value="">
        </p>

        <p>
            <label for="p1Id">P1-Goalkeeper</label>
            <input id="p1Id" name="p1Id" value="">
        </p>
        
         <p>
            <label for="p2Id">P2-Right Fullback</label>
            <input id="p2Id" name="p2Id" value="">
        </p>
        
         <p>
            <label for="p3Id">P3-Left Fullback</label>
            <input id="p3Id" name="p3Id" value="">
        </p>
        
         <p>
            <label for="p4Id">P4-Center Back</label>
            <input id="p4Id" name="p4Id" value="">
        </p>
        
         <p>
            <label for="p5Id">P5-Center Back</label>
            <input id="p5Id" name="p5Id" value="">
        </p>
        
         <p>
            <label for="p6Id">P6-Defending/Holding Midfielder</label>
            <input id="p6Id" name="p6Id" value="">
        </p>
        
         <p>
            <label for="p7Id">P7-Right Midfielder/Winger</label>
            <input id="p7Id" name="p7Id" value="">
        </p>
        
         <p>
            <label for="p8Id">P8-Central/Box-to-Box Midfielder</label>
            <input id="p8Id" name="p8Id" value="">
        </p>
        
         <p>
            <label for="p9Id">P9-Striker</label>
            <input id="p9Id" name="p9Id" value="">
        </p>
        
         <p>
            <label for="p10Id">P10-Attacking Midfielder/Playmaker</label>
            <input id="p10Id" name="p10Id" value="">
        </p>
        
         <p>
            <label for="p11Id">P11-Left Midfielder/Wingers</label>
            <input id="p11Id" name="p11Id" value="">
        </p>

        

        <p>
            <input type="submit" value="Create customized team">
        </p>
    </form>
    

    
    <br></br>
    </div>
        <!-- Bootstrap -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
</body>
</html>