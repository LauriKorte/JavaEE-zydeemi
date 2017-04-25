package fi.jamk.javaee.ogrecipes.auth;

import java.security.MessageDigest;
import java.util.Base64;

public class Credentials {

	public String HashPasswordWithSalt(String password, String salt) throws Exception
	{
		String pass = null;
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		md.update(salt.getBytes("UTF-8"));
		byte[] bytes = md.digest(password.getBytes("UTF-8"));
		pass = Base64.getEncoder().encodeToString(bytes);
	    return pass;
	}
	
	
	public boolean ValidatePassword(String password, String salt, String hash)
	{
		try 
		{
			String hash2 = HashPasswordWithSalt(password,salt);
			if (hash != hash2)
				return false;
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}
}
