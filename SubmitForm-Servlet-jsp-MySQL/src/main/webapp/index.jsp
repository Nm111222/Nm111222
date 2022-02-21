<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>

             <style>
             .sub{
                     background-color:brown;
                     margin:15px;
                     margin-left:80px;
                     }
             </style>
</head>
<body style="background-color:lightblue">
           <div align="center">
                   <h1 Style="color:red">Fill details and submit form</h1>
                   
                   <form action="RegistrationServlet" method="post" enctype="multipart/form-data">
                   <table >
                   
                   <tr>  <td>Enter First Name :</td>
                   <td> <input type="text" name="first_name" placeholder="enter here" required="required" ></td>
                   </tr>
                   <tr>  <td>Enter Last Name :</td>
                   <td> <input type="text" name="last_name" placeholder="enter here" required="required" ></td>
                   </tr>
                   <tr><td>Enter your mobile number :</td><td><input type="number" name="user_mobile" placeholder="enter here" required="required" ></td>
                   <tr>
                   <tr><td>Enter your Email id :</td><td><input type="email" name="user_email"  placeholder="enter here" required="required"></td>
                   </tr>
                   <tr><td> Select your Gender :</td><td> <input type="radio" name="gender" value="male">Male
                       <input type="radio" name="gender" value="female">Female
                       </td>
                    </tr>
                    <tr><td>Date of Birth :</td><td><input type="date" name="user_dob"></td></tr>
                   <tr><td>Enter your Qualification :</td><td><input type="text" name="user_qualification" placeholder="enter here" required="required" ></td>
                   </tr>   
                   <tr><td>Upload passport size photo :</td><td><input type="file" name="user_image"></td></tr>
                   <br>
                  <tr><td><input type="submit" value="Submit Form" class="sub"></td></tr>
                      
                      
                   
                   
                   </table>
           </form>
           
           </div>
           <br><br><br>
         


</body>
</html>