package seguridad.server.remote.interfaces;

	import java.util.*;

import seguridad.server.data.Member;

import java.rmi.Remote;
	import java.rmi.RemoteException;


	public interface IServerManager extends Remote{

	  public boolean SignIn(String username, String password,String otpc) throws RemoteException;

	  public void SignOut(String username) throws RemoteException;
	  
	  public ArrayList<String> getallMembers(String admin)throws RemoteException;
	  
	  public void register (boolean admin, String username,String password, String name, String email, Date birthdate, String address, String country)throws RemoteException;
	  
		public List<String> getmem(String user)throws RemoteException ;

}
