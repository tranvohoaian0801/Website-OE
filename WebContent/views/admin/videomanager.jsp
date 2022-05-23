<%@ page 
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="/ASMJAVA4/views/admin/css/admin.css" rel="stylesheet" />
    <link href="/ASMJAVA4/views/admin/css/videomanager.css" rel="stylesheet" />
    <link href="/ASMJAVA4/views/admin/css/table.css" rel="stylesheet" />
</head>
<body>
	<c:url var="url" value="VideoManagerServlet"></c:url>
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
                <a href="report.jsp">Reports</a>
                
            </li>
            
        </ul>
    </div>
    <div class="col">
			<c:if test="${not empty message}">
			<div class= "alert alert-success">${message}</div>
			</c:if>
			<c:if test="${not empty error}">
			<div class= "alert alert-danger">${error}</div>
			</c:if>
		</div>
    <div class="row">
        <form action="${url}" method="POST" enctype="multipart/form-data">
            <div class="form-group">
                <label>Youtube ID :</label> <br>
                <input name="id" value="${currentVideo.id}" type="text" class="form-control" required placeholder="Nhập ID"/> <br>
            </div>
            <div class="form-group">
                <label>Video Title:</label> <br>
                <input name="title" value="${currentVideo.title}" type="text" class="form-control" required placeholder="Nhập Tiêu Đề "/> <br>
            </div>
            <div class="form-group">
             	
									
							<img src="<c:url value='/views/img/${currentVideo.poster}' />" width="150px"height="230px"><br>
							<input type="file" value="${currentVideo.poster}" name="poster">
							<input type="text" hidden value="${currentVideo.poster}" name="poster" >
							<small>${currentVideo.poster}</small>
								<br>
										
				
            </div>
            <div class="form-group">
                <label>View Count:</label> <br>
                <input name="views" value="${currentVideo.views}" type="number" class="form-control" required placeholder="Nhập lượt xem"/> <br>
            </div>
            <div class="form_group">
            		  <label>Link:</label> <br>
            		<input type="text" class="form-control" name="link" value="${currentVideo.link}" required placeholder="Nhập link">
            </div>
            <div  class="form-group">
                
                <label for="sport"><input name="active" type="checkbox" value="true" id="sport" tabindex="1"/>Active</label>
                <label for="travel"><input name="active" type="checkbox" value="false" id="travel" tabindex="2" checked/>Inactive</label>
               
            </div>
            <br>
            <div>
                <label for="description"  >Description:</label> <br>
                <textarea name="description" rows="10"style="width:100%" >${currentVideo.description}</textarea>
            </div>
            <br>
            <div>
                	
                	<button type="submit" class="ss" formaction="<%=request.getContextPath()%>/VideoManagerServlet/insert" class="ss">Insert</button>
                    <button type="submit" class="ss" formaction="<%=request.getContextPath()%>/VideoManagerServlet/update" class="ss">Update</button>
                   
                    <button type="submit" class="ss" formaction="<%=request.getContextPath()%>/VideoManagerServlet/reset" class="ss">Reset</button>
               
            </div>
        </form>
    </div>
    <table>
        <tr>
          <th>Youtube ID</th>
          <th>Video Title </th>
          <th>Poster </th>
          <th>Views Count</th>
          <th>Link</th>   
          <th>Active </th> 
          <th>Description</th> 
          
          <th></th>    
        </tr>
        <c:forEach var="item" items="${items}">
        <tr>
          <td>${item.id }</td>
          <td>${item.title}</td>
          <td>${item.poster}</td>
          <td>${item.views}</td>
 		  <td>${item.link}</td>
          <td>${item.active? 'Active':'Inactive' }</td>
          <td>${item.description }</td>
          
          <td>
          	<a href="<%=request.getContextPath()%>/VideoManagerServlet/edit?id=${item.id}">Edit</a>
          	<span>__</span>    
          	<a href="<%=request.getContextPath()%>/VideoManagerServlet/delete?id=${item.id}">Delete</a>   	
          </td>
        </tr>
        
        </c:forEach>
        
      </table>
</body>
</html>