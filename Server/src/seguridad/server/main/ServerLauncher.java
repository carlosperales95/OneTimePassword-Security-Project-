package seguridad.server.main;

import java.rmi.RemoteException;
import seguridad.server.remote.facade.ServerFacade;
import seguridad.server.service.ServerService;

public class ServerLauncher {
	
	@SuppressWarnings("unused")
	public static void main(String[] args){
		
			ServerService ts1;
			try {
				ts1 = new ServerService();
				ServerFacade tf = new ServerFacade(args[0], args[1], args[3], ts1);
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
	}
}
