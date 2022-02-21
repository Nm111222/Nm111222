package com.nilesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname="ab";
		String upass="ab";
		String name="ab";
		String username=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		

		String url="jdbc:mysql://localhost:3306/registration";
		String user="root";
		String pass="abcd";
		String query="select * from flightbook";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			Statement stmt=con.createStatement();
		    ResultSet rs=stmt.executeQuery(query);
			
		    while(rs.next()) {
		    	
		    	 uname=rs.getString("username");
		    	 upass=rs.getString("password");
		    	
		    }
			
		    if(uname==username && password==upass) {
		    	HttpSession session=request.getSession();
		    	request.setAttribute("name", name);
		    	response.sendRedirect("welcome.jsp");
		    	
		    	System.out.println("login");
		    	
		    }else {
		    	
		    	response.sendRedirect("login.jsp");
		    }
		
	     }catch(Exception e) {
		e.printStackTrace();
	        }
	}

}
