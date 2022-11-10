package com.ashish.registration;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;



@WebServlet(urlPatterns ={"/LogoutServlet"})
public class logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
   
    public logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		//PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(false);
		session.invalidate();
		response.sendRedirect("login.jsp");

	}

}
