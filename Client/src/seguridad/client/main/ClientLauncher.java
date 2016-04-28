package seguridad.client.main;

import seguridad.client.controller.ClientController;
import seguridad.client.gui.GUI;
import seguridad.client.remote.RMIServiceLocator;

public class ClientLauncher{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RMIServiceLocator rsl = new RMIServiceLocator(args[0],args[1],args[2]);
		System.out.println("Llamar a "+ args[0]);
		try {
			ClientController tc = new ClientController(rsl);
			rsl.getServerService();
		//	tc.SignIn("astrain25", "astrain25");
		//	String admin = "user";
		//	tc.getAllMembers(admin);
		//	tc.getAllMembers("admin");
			GUI g = new GUI(tc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
