package seguridad.client.main;

import seguridad.client.controller.TralalaController;
import seguridad.client.remote.RMIServiceLocator;

public class ClientLauncher{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		RMIServiceLocator rsl = new RMIServiceLocator(args[0],args[1],args[2],args[3],args[4]);
		System.out.println("Llamar a "+ args[0]);
		TralalaController tc = new TralalaController(rsl);
	//	ExternalLoginController lc = new ExternalLoginController(rsl);
	//	ExternalPaymentController pc = new ExternalPaymentController(rsl);
	//	GUI g = new GUI(tc,lc,pc);
		
	}

}
