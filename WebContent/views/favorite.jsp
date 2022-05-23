<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Movies Pro</title>
    <link href="views/css/Home.css" rel="stylesheet" />
    <link href="views/css/index.css" rel="stylesheet" />
    

</head>

    <div class="menu">
        <ul>
            <a class="home" href="<c:url value='/index' />" >ONLINE ENTERTAINMENT</a>
            <li>
                <a href="favorite">MY FAVORITE</a>
            </li>
            <li>
                <a href="#">MY ACCOUNT</a>
                <ul>
                    <a href="login">Login</a>
                    <a href="forgotPass">Forgot Password</a>
                    <a href="registration">Registration</a>
                    <a href="logout">Logoff</a>
                    <a href="changePass">Change Password</a>
                </ul>
            </li>
            
        </ul>
    </div>
    
    <c:forEach items="${videos}" var="video">
     <div class="videodemo">
        <div class="showdetails">
            <h5 class="namevideo">${video.titile} </h5>
                <img src="<c:url value='/views/img/${video.poster}' />" width="240" height="180"></br></br>
             	<a href="<c:url value='/video?action=watch&id=${video.link}'/>">View more</a>
            <p class="views"> ${video.views} views </p><br>
            <div class="fb-like" data-href="http://127.0.0.1:5500/index.html" 
            data-width="" data-layout="button" data-action="like" data-size="small" data-share="true"></div>
        </div>
    </div>
    </c:forEach>
    
    
    <div class="btnclick">
        <button class="button">Firts</button>
        <button class="button">Prev</button>
        <button class="button">Next</button>
        <button class="button">Last</button>
    
    </div>
   <%@ include file="/common/footer.jsp" %>
    <div id="fb-root"></div>
<script async defer crossorigin="anonymous" 
src="https://connect.facebook.net/vi_VN/sdk.js#xfbml=1&version=v12.0&appId=1117863175398213&autoLogAppEvents=1" 
nonce="YiilOihb"></script>
</body>
</html>
