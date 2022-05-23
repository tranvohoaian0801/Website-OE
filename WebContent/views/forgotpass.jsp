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
        <a href="index" class="home">ONLINE ENTERTAINMENT</a>
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
    <div class="row" >
        <form method ="POST" action="forgotPass">
            <h1 style="color: white;text-align: center; font-size: 40px;">Forgot Password Form</h1>
            <div class="user">
                <label>Email :</label> <br>
                <input type="email" class="form-control" placeholder="Enter Email" name="email"> <br>
            </div>
            <div class="form-group">
            </div>
            <hr/>
            <div class="form-group">
                <input type="submit" class="ss" value="Lấy Mật Khẩu"/>
            </div>
        </form>
    </div>
    <footer>
        <img src="img/footer.png" />
      </footer>
</body>
</html>
