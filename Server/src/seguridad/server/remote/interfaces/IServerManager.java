package seguridad.server.remote.interfaces;

	import java.util.*;
	import java.rmi.Remote;
	import java.rmi.RemoteException;


	public interface IServerManager extends Remote{

	  public void SignIn(String username, String password) throws RemoteException;

	  public void SignOut(String username) throws RemoteException;
	  
	  public boolean getallMembers()throws RemoteException;;

}
