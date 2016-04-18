package seguridad.server.remote.facade;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import seguridad.server.remote.interfaces.IServerManager;
import seguridad.server.service.ServerService;



public class ServerFacade extends UnicastRemoteObject implements IServerManager  {
	private ServerService myAssociatedService;
	
	public ServerFacade(String ip, String port, String name, ServerService associated) throws RemoteException{
		this.myAssociatedService = associated;
                if (System.getSecurityManager() == null) {
                        System.setSecurityManager(new SecurityManager());
                }

                String fullname = "/"+"/" + ip + ":" + port + "/" + name;

                try {
                        Naming.rebind(fullname, this);
                        System.out.println("* Server '" + fullname + "' active and waiting...");
                } catch (Exception e) {
                        System.err.println("- Exception running the server: " + e.getMessage());
                        e.printStackTrace();
                }
	}

}
