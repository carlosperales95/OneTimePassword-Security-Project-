package seguridad.server.service;
import java.util.*;

import seguridad.server.DAO.DAOFactory;
import seguridad.server.DAO.IServerDAO;
import seguridad.server.data.Member;
import seguridad.server.remote.interfaces.IServerManager;
import java.rmi.RemoteException;

public class ServerService implements IServerManager {
	
	private IServerDAO myPersistenceProvider;
	
	public ServerService() throws RemoteException{

		this.myPersistenceProvider = DAOFactory.getInstance("db");	
		}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean SignIn(String username, String password, String otpc)throws RemoteException{
	
		System.out.println("Checking credentials");
		System.out.println(username);
		System.out.println(password);
		System.out.println(otpc);
		System.out.println();

		if((this.checkCombination(username, password)==true) && (this.compareotp(username, password,otpc)==true)){
			System.out.println("Member "+ username + " logged in successfully");
			return true;
		}
		else return false;
	}
	
	public boolean checkCombination(String username, String password){
		String value = 	myPersistenceProvider.getMember(username).getPassword();

		if(value!=null){
			if(value.equals(password)){
				return true;
			}
			else{
				 return false;
			}
		}else{
				 return false;
		}
	}

	public boolean compareotp(String username,String password,String otpc){
		OTPmaker myOTPmaker=new OTPmaker();
		return myOTPmaker.checkOTP(username, password, otpc);	
		
	}	
	
	public void SignOut(String username)throws RemoteException {
		System.out.println("Member " + username + " logged out successfully");
	}

	public ArrayList<String> getallMembers(String admin)throws RemoteException {

		List<Member> hits = this.myPersistenceProvider.getallMembers(admin);
		ArrayList<String> retUserNames = new ArrayList<String>();
		
		for(int i = 0; i<hits.size(); i++){
			retUserNames.add(hits.get(i).getUsername());
		}
		return retUserNames;
	}
	
	public void register (boolean admin, String username,String password, String name, String email, Date birthdate, String address, String country)throws RemoteException {
		Member memb = new Member(admin, username,password, name, email, birthdate, address, country);
		myPersistenceProvider.registerMember(memb);
	}

	public List<String> getmem(String user)throws RemoteException {
		Member memb = this.myPersistenceProvider.getMember(user);
		List<String> ls = new ArrayList<String>();
		ls.add(memb.getUsername());
		ls.add(memb.getName());
		ls.add(memb.getEmail());
		ls.add(memb.getPassword());
		ls.add(memb.getCountry());
		ls.add(memb.getAddress());
		
		return ls;
	}
	
	
}
