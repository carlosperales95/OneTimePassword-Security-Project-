package seguridad.client.controller;
import seguridad.client.remote.RMIServiceLocator;

import java.util.*;

public class ClientController {
	private RMIServiceLocator myLocator;
	
	/**
	 * 
	 * @param rsl
	 */
	public ClientController(RMIServiceLocator rsl) throws Exception{
		this.myLocator = rsl;
	}

	/**
	 * 
	 * @param username
	 */
	public void SignOut(String username) throws Exception{
		myLocator.getServerService().SignOut(username);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public void SignIn(String username, String password)  throws Exception{
		myLocator.getServerService().SignIn(username,password);
	}
	
	public void getAllMembers()  throws Exception{
		myLocator.getServerService().getallMembers();
	}
	

	
	
}
