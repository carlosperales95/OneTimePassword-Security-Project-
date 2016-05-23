package seguridad.client.main;

import seguridad.client.controller.ClientController;
import seguridad.client.gui.GUI;
import seguridad.client.remote.RMIServiceLocator;

public class ClientLauncher{
	
	/*
	 * MAIN PROGRAM 
	 * 
	 * Clase inicial que corre en el cliente.
	 * En ella establecemos: 
	 * El Servicio RMI 
	 * El Controlador para el cliente
	 * La interfaz gráfica
	 * 
	 */ 
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		RMIServiceLocator rsl = new RMIServiceLocator(args[0],args[1],args[2]);
		System.out.println("Llamando al sevidor: "+ args[0]);
		try {
			ClientController tc = new ClientController(rsl);
			rsl.getServerService();
			GUI g = new GUI(tc);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
