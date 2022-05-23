<%@ page 
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/admin.css" rel="stylesheet" />

</head>
<body>
    <div class="menu">
        <ul>
            <a href="admin.jsp" class="home">ADMINISTRATION TOOL</a>
            <li>
                <a href="admin.jsp">Home</a>
            </li>
            <li>
                <a href="videomanager.jsp">Videos</a>
                
            </li>
            <li>
                <a href="usersmanager.jsp">Users</a>
                
            </li>
            <li>
                <a href="report.jsp">Reports</a>
                
            </li>
            
        </ul>
    </div>
	<img src="<c:url value='/views/img/1.jpg'/>" alt="Image" width="100%" height="650px">
</body>
</html>