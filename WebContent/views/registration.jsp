<%@ page 
    pageEncoding="UTF-8"%>
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
        <a href="favorite" class="home">ONLINE ENTERTAINMENT</a>
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
    <div class="row">
        <form method ="POST" action="registration">  
            <h1 style="color: white;text-align: center; font-size: 40px;">Registration Form</h1>
            <div class="user">
                <label>Tên đăng nhập:</label> <br>
                <input type="text" class="form-control" placeholder="Enter User" name="id"/> <br>
            </div>
            <div class="user">
                <label>Mật khẩu:</label> <br>
                <input type="password" class="form-control" placeholder="Enter Password" name="password"/> <br>
            </div>
            <div class="user">
                <label>Nhập lại Mật khẩu:</label> <br>
                <input type="password" class="form-control" placeholder="Enter Password" name="cfmpass"/> <br>
            </div>
            <div class="user">
                <label>Tên đầy đủ :</label> <br>
                <input type="text" class="form-control" placeholder="Enter Full Your Name" name="fullname"/> <br>
            </div>
            <div class="user">
                <label>Email :</label> <br>
                <input type="text" class="form-control" placeholder="Enter Your Email" name="email"/> <br>
                <h4 style:"color: red">${error}</h4>
            </div>
            <hr/>
            <div class="form-group">
                <input type="submit" class="ss" value="Sign Up"/>
                <input type="reset"  class="ss" value="Hủy" />
            </div>
        </form>
    </div>
    <footer>
        <img src="img/footer.png" />
      </footer>
</body>
</html>