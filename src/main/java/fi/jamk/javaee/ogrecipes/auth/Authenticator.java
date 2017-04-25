package fi.jamk.javaee.ogrecipes.auth;

import javax.servlet.http.HttpServletRequest;

public class Authenticator {
	
	public static boolean  Authenticate(HttpServletRequest request, AuthenticationLevel level)
	{
        return true;
	}
}
