<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

    <!---<title>Login </title>--->
    <link rel="stylesheet" href="style.css">
     <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>
         <div class="container">
    <div class="title">Please Login</div>
    <div class="content">
      <form action="LoginServlet" method="post">
        <div class="user-details">
       
          <div class="input-box">
            <span class="details">Username</span>
            <input type="text" name="user_name" placeholder="Enter your username" required>
          </div>
        
          <div class="input-box">
            <span class="details">Password</span>
            <input type="text" name="user_password" placeholder="Enter your password" required>
          </div>
        
        </div>
      
        <div class="button">
          <input type="submit" value="Login">
        </div>
        <a href="index.html" style="text-decoration:none">Click here for new Registration</a>
      </form>
    </div>
  </div>


</body>
</html>