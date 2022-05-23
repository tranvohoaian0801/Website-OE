<%@ page 
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="views/css/Home.css" rel="stylesheet" />
    <link href="views/css/login.css" rel="stylesheet" />
</head>
<body>
    <div class="menu">
	
        <ul>
        
        <a  href='<c:url value="/index"></c:url>' class="home">ONLINE ENTERTAINMENT</a>
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
    <div class="row"  >
        <form method ="POST" action="login">
            <h1 style="color: white;text-align: center; font-size: 40px;">Login Form</h1>
            <div class="user">
                <label>Tên đăng nhập:</label> <br>
                <input type="text" class="form-control" name ="id" placeholder="Id"/> <br>
            </div>
            <div class="user">
                <label>Mật khẩu:</label> <br>
                <input type="password" class="form-control" name ="password" placeholder="Password"/> <br>
            </div>
            <div class="form-group">
                <label>
                <input type="checkbox"/> Ghi nhớ mật khẩu?  
                </label>
                <h4 style="color: red;">${error}</h4>
            </div>
            <hr/>
            <div class="form-group">
                <input type="submit" class="ss" value="Đăng nhập"/>
                <input type="reset"  class="ss" value="Hủy" />
            </div>
        </form>
    </div>
    <footer>
        <img src="img/footer.png" />
      </footer>
</body>
</html>