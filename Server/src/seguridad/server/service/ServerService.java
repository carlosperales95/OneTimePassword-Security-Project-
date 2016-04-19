package seguridad.server.service;
import java.util.*;

import seguridad.server.DAO.IServerDAO;
import seguridad.server.DAO.ServerDAO;
import seguridad.server.data.Member;

import java.io.*;
//import org.apache.commons.io.IOUtils;
import java.rmi.RemoteException;

public class ServerService {
	
	static HashMap<String, String> registered;
	static{
		registered = new HashMap<String, String>();
	}

	private IServerDAO myPersistenceProvider;
	
	public ServerService() throws RemoteException{
		this.myPersistenceProvider = ((IServerDAO)(new ServerDAO()));	
		}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	public boolean SignIn(String username, String password)throws RemoteException{
		if(this.checkCombination(username, password)==true){
			System.out.println("Member "+ username + " logged in successfully");
			return true;
		}
		else return false;
	}
	
	public boolean checkCombination(String username, String password){
		String value = registered.get(username);
		if(value!=null){
			if(value.equals(password)){
				System.out.println("Member/pw " + username+"/"+password+" found. Returning true");
				return true;
			}
			else{
				 System.out.println("Returning false");			
				 return false;
			}
		}else{
				 System.out.println("Returning false");			
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


	/**
	 * 
	 * @param username
	 */
	/**public MemberDTO streamSong(String username) {
		Member selected = this.myPersistenceProvider.getMember(username);
		Date now = Calendar.getInstance().getTime();
		if(selected!=null){
			MemberDTO ret = DTOAssembler.assemble(selected);

			return ret;
		}
		else{
			 return null;			
		}	
	}
**/

	public ArrayList<String> getallMembers()throws RemoteException {
		Member[] hits = this.myPersistenceProvider.getallMembers();
		ArrayList<String> retUserNames = new ArrayList<String>();
		for(int i = 0; i<hits.length; i++){
			retUserNames.add(hits[i].getUsername());
		}
		return retUserNames;
	}

}
