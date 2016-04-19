package seguridad.server.main;

import seguridad.server.remote.facade.ServerFacade;
import seguridad.server.service.ServerService;

public class ServerLauncher {
	public static void main(String[] args){
		try{
			ServerService ts1 = new ServerService();
			ServerFacade tf = new ServerFacade(args[0], args[1], args[3], ts1);
			
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

}
