package com.nilesh;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class RegistrationServlet
 */
@MultipartConfig
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
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
		
		String fname=request.getParameter("first_name");
		String lname=request.getParameter("last_name");
		String mob=request.getParameter("user_mobile");
		String email=request.getParameter("user_email");
		String gender=request.getParameter("gender");
		String dob=request.getParameter("user_dob");
		String qualification=request.getParameter("user_qualification");
		Part part=request.getPart("user_image");
		
		String imgname=part.getSubmittedFileName();
		String imgpath="C:/Users/Nilesh Mishra/eclipse-workspace/SubmitForm-Servlet-jsp-MySQL/src/main/webapp/images/"+imgname;
		
		try {
		FileOutputStream fout=new FileOutputStream(imgpath);
		
		InputStream is=part.getInputStream();
		byte b[]=new byte[is.available()];
		is.read(b);
		fout.write(b);
		fout.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		    
		
		String url="jdbc:mysql://localhost:3306/logindb";
		String user="root";
		String pass="abcd";
		String query="insert into formdata(fstname,lstname,mobno,email,gndr,dob,qul,imgname) values(?,?,?,?,?,?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection(url, user, pass);
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setString(1, fname);
			pstmt.setString(2, lname);
			pstmt.setString(3, mob);
			pstmt.setString(4, email);
			pstmt.setString(5, gender);
			pstmt.setString(6, dob);
			pstmt.setString(7, qualification);
			pstmt.setString(8, imgname);
	int chk=pstmt.executeUpdate();
	
	if(chk>0) {
		System.out.println("data entered successfully");
	}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("first_name", fname);
		request.setAttribute("last_name", lname);
		request.setAttribute("umob", mob);
		request.setAttribute("uemail", email);
		request.setAttribute("ugender", gender);
		request.setAttribute("udob", dob);
		request.setAttribute("uqul", qualification);
		request.setAttribute("imgname", imgname);
		//request.setAttribute("imgpath", imgpath);
		
		RequestDispatcher rd=request.getRequestDispatcher("showdata.jsp");
		rd.forward(request, response);
		
		
		
	
		
		
		
	}

}
