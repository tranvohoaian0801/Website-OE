<%@ page 
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <link href="/ASMJAVA4/views/admin/css/admin.css" rel="stylesheet" />
    <link href="/ASMJAVA4/views/admin/css/videomanager.css" rel="stylesheet" />
    <link href="/ASMJAVA4/views/admin/css/table.css" rel="stylesheet" />
</head>
<body>
	<c:url var="url" value="/admin/usersmanager"></c:url>
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
    <div class="row">
        <form action="">
            <form action="${url}/index" method="POST">
                <div class="form-group">
                    <label>User Name :</label> <br>
                    <input name="id" value="${nguoi.id}" type="text" class="form-control" required placeholder="Nhập họ tên"/> <br>
                </div>
                <div class="form-group">
                    <label>Password:</label> <br>
                    <input name="password" value="${nguoi.password}" type="password" class="form-control" required placeholder="Nhập mật khẩu"/> <br>
                </div>
                <div class="form-group">
                    <label>Full Name:</label> <br>
                    <input name="fullname" value="${nguoi.fullname}" type="text" class="form-control" required placeholder="Nhập họ tên đầy đủ"/> <br>
                </div>
                <div class="form-group">
                    <label>Email Address:</label> <br>
                    <input name="email" value="${nguoi.email}" type="email" class="form-control" required placeholder="Nhập địa chỉ mail"/> <br>
                </div>
                <div>
                    
                   	<button type="submit" formaction="${url}/insert" class="ss">Insert</button>
                    <button type="submit" formaction="${url}/update" class="ss">Update</button>
                     <button type="submit" formaction="${url}/reset" class="ss">Reset</button>
               
               
                   
                </div>
        </form>
        
    </div>
    <table>
        <tr>
          <th>UserName </th>
          <th>Password</th>
          <th>FullName</th>
          <th>Email</th>
          <th>Role</th>
         
          <th></th>
        </tr>
       	<c:forEach var="item" items="${items}">
            <tr>
              <td>${item.id}</td>
              <td>${item.password}</td>
              <td>${item.fullname}</td> 
              <td>${item.email}</td>
              <td>${item.admin? 'Admin':'User'}</td>
             
              <td><a href="${url}/edit?id=${item.id}">Edit</a>
              	<a href="${url}/delete?id=${item.id}">Delete</a>
              </td>
            </tr>
            </c:forEach>
      </table>
</body>
</html>