package fi.jamk.javaee.ogrecipes.auth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class Authenticator {
	
	public static boolean  Authenticate(HttpServletRequest request, AuthenticationLevel level)
	{
		HttpSession session = request.getSession();
		Integer it = (Integer)session.getAttribute("auth_level");
		if (it == null)
		{
			return false;
		}
		if (it == 177)
			return true;
		return false;
	}
	public static boolean  Login(HttpServletRequest request, String user, String password)
	{
		HttpSession session = request.getSession();
		session.setAttribute("auth_level", 0);
		if (user == null || password == null)
			return false;
		if (user.compareTo("salis") == 0 && password.compareTo("sekret") == 0)
		{
			session.setAttribute("auth_level", 177);
			return true;
		}
        return false;
	}
}