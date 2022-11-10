package com.ashish.registration;

import java.io.IOException;
// import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;




@WebServlet("/indexform")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fname= request.getParameter("name");
		String usemail= request.getParameter("email");
		String usmobile= request.getParameter("contact");
		String usmessage= request.getParameter("message");
		RequestDispatcher dispatcher= null;
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinfo?useSSL=false","root","Lucknow@123");
            PreparedStatement pst = con.prepareStatement("insert into contactus(fname,usemail,usmobile,usmessage) values (?,?,?,?)");
            
            pst.setString(1, fname);
            pst.setString(2, usemail);
            pst.setString(3, usmobile);
            pst.setString(4, usmessage);
            int rowCount = pst.executeUpdate();
            dispatcher = request.getRequestDispatcher("index.jsp");
            if(rowCount > 0) {
            	request.setAttribute("status", "success");
            }else {
            	request.setAttribute("status", "failed");
            }
            dispatcher.forward(request, response);
		}catch(Exception e)
		{
			e.printStackTrace();		
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}