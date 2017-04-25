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
	            out.print("<h2>Parametrit</h2>");
	            // Voidaan lukea kaikki HTTP-pyyntä parametrit:
	            java.util.Enumeration nimet = request.getParameterNames();
	            while (nimet.hasMoreElements()) {
	                String nimi = (String)nimet.nextElement();
	                out.print(nimi + " ==> " + (String)request.getParameter(nimi)  + "<br/>");
	            }
	       }
	    	else
	    		response.sendRedirect("/");
    }
}