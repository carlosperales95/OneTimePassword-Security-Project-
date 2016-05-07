package seguridad.client.controller;
import seguridad.client.remote.RMIServiceLocator;
import seguridad.server.data.Member;

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
		this.myLocator.getServerService().SignOut(username);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean SignIn(String username, String password, String otpc)  throws Exception{
		return this.myLocator.getServerService().SignIn(username,password,otpc);
		
	}
	
	public ArrayList<String> getAllMembers(String admin)  throws Exception{
		return this.myLocator.getServerService().getallMembers(admin);
	}
	
	public List<String> getmem(String user) throws Exception{
		return this.myLocator.getServerService().getmem(user);
	}
	
	
}
