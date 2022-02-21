package com.nilesh;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String String = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    String fname=request.getParameter("full_name");
		String email=request.getParameter("user_email");
		String mob= request.getParameter("user_phone");
		String uname=request.getParameter("user_name");
		String password=request.getParameter("user_password");
		String cnfPassword=request.getParameter("conf_password");
		if(password==cnfPassword) {
			
		}
		
		String url="jdbc:mysql://localhost:3306/registration";
		String user="root";
		String pass="abcd";
		String query="insert into flightbook(fullname, email, phone, username, password) values(?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, email);
			pstmt.setString(3, mob);
			pstmt.setString(4, uname);
			pstmt.setString(5, password);
			
			int chk=pstmt.executeUpdate();
			if(chk>0) {
				System.out.println("Database saved");
				
			}
			
		} catch ( Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
				
		
       
			
	}

}
