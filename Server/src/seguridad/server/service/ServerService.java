package seguridad.server.service;
import java.util.*;

import seguridad.server.DAO.DAOFactory;
import seguridad.server.DAO.IServerDAO;
import seguridad.server.DAO.ServerDAO;
import seguridad.server.data.Member;
import seguridad.server.remote.interfaces.IServerManager;

import java.io.*;
//import org.apache.commons.io.IOUtils;
import java.rmi.RemoteException;

public class ServerService implements IServerManager {
	
	static HashMap<String, String> registered;
	static{
		registered = new HashMap<String, String>();
	}

	private IServerDAO myPersistenceProvider;
	
	public ServerService() throws RemoteException{

		this.myPersistenceProvider = DAOFactory.getInstance("db");	
		}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean SignIn(String username, String password)throws RemoteException{
		System.out.println("vamos a logear");
		if(this.checkCombination(username, password)==true){
			System.out.println("Member "+ username + " logged in successfully");
			return true;
		}
		else return false;
	}
	
	public boolean checkCombination(String username, String password){
		String value = 	myPersistenceProvider.getMember(username).getPassword();

//registered.get(username);
		if(value!=null){
			if(value.equals(password)){
				System.out.println("Member/pw " + username+"/"+password+" found. Returning true");
				return true;
			}
			else{
				 System.out.println("Bad credentials");	

				 return false;
			}
		}else{
				 System.out.println("Bad credentials");		

				 return false;
		}
	}

	/**
	 * 
	 * @param username
	 */
	public void SignOut(String username)throws RemoteException {
		System.out.println("Member " + username + " logged out successfully");
	}


	public ArrayList<String> getallMembers(String admin)throws RemoteException {

		List<Member> hits = this.myPersistenceProvider.getallMembers(admin);
		System.out.println("los hits");
		System.out.println(hits);
		ArrayList<String> retUserNames = new ArrayList<String>();
		for(int i = 0; i<hits.size(); i++){
			retUserNames.add(hits.get(i).getUsername());
		}
		System.out.println("strings finales");
		System.out.println(retUserNames);
		return retUserNames;
	}
	
	public void register (boolean admin, String username,String password, String name, String email, Date birthdate, String address, String country)throws RemoteException {
		Member memb = new Member(admin, username,password, name, email, birthdate, address, country);
		myPersistenceProvider.registerMember(memb);
	}


}
