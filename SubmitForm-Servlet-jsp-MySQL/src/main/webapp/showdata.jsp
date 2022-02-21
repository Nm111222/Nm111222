<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>show data</title>
<style>
    body{ background-color:lightgray;
          color:blue;
         }
         h1{color:red;
         margin-left:370px;
             }
             a{
              color:red;
              
              margin-left:400px;}
         
</style>
</head>
<body>
       
       
        <%
        String fname=(String)request.getAttribute("first_name");
        String lname=(String)request.getAttribute("last_name");
        String umob=(String)request.getAttribute("umob");
        String uemail=(String)request.getAttribute("uemail");
        String ugender=(String)request.getAttribute("ugender");
        String udob=(String)request.getAttribute("udob");
        String uqul=(String)request.getAttribute("uqul");
        String imgname=(String)request.getAttribute("imgname");
        
        %>
      
        <form enctype="multipart/form-data">
        <h1>Check your details</h1>
        <div align="center">
        
        <table>
       
         <tr><td>First Name :</td><td><%=fname %></td><td>
         <tr><td>Last Name :</td><td><%=lname %></td></tr>
         <tr><td>Mobile :</td><td><%=umob %></td></tr>
         <tr><td>Email :</td><td><%=uemail %></td></tr>
         <tr><td>Gender :</td><td><%=ugender %></td></tr>
         <tr><td>DOB :</td><td><%=udob %></td></tr>
         <tr><td>Qualification :</td><td><%=uqul %></td></tr>
         <tr><td>Image File Name :</td><td><%=imgname%></td></tr>
       
        
        </table>
        </div>
        <br><br>
        <a href="index.jsp">Click here to submit next data</a>
 </form>
</body>
</html>