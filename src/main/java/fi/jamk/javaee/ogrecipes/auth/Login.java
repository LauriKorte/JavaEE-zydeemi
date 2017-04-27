package fi.jamk.javaee.ogrecipes.auth;


import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import javax.servlet.annotation.WebServlet;


@WebServlet(value="/login", loadOnStartup=1)
public class Login extends HttpServlet {
	    
	    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response )
            throws ServletException, IOException {
	    	String user = request.getParameter("user");
	    	String password = request.getParameter("password");
	    	if (!Authenticator.Login(request,user,password))
	    	{
	    		response.setContentType("text/html");  
	            PrintWriter out=response.getWriter();  
	           
	              
	            out.print("Failed to login: <a href='/'> GO BACK</a>");	   
	           
	       }
	    	else
	    		response.sendRedirect("/");
    }
}