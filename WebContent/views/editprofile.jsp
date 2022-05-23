<%@ page 
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="css/Home.css" rel="stylesheet" />
    <link href="css/login.css" rel="stylesheet" />
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
    <div class="row">
        <form>
            <h1 style="color: white;text-align: center; font-size: 40px;">Edit Profile Form</h1>
            <div class="user">
                <label>Tên đăng nhập:</label> <br>
                <input type="text" class="form-control" placeholder="Enter User"/> <br>
            </div>
            <div class="user">
                <label>Mật khẩu hiện tại:</label> <br>
                <input type="password" class="form-control" placeholder="Enter Password"/> <br>
            </div>
            <div class="user">
                <label>Tên đầy đủ :</label> <br>
                <input type="text" class="form-control" placeholder="Enter Full Your Name"/> <br>
            </div>
            <div class="user">
                <label>Email :</label> <br>
                <input type="text" class="form-control" placeholder="Enter Your Email"/> <br>
            </div>
            <div class="form-group">
                <label>
                <input type="checkbox"  />  Xác nhận dữ liệu chính xác ?    
                </label>
            </div>
            <hr/>
            <div class="form-group">
                <input type="submit" class="ss" value="Cập nhật"/>
                <input type="reset"  class="ss" value="Hủy" />
            </div>
        </form>
    </div>
    <footer>
        <img src="img/footer.png" />
      </footer>
</body>
</html>
