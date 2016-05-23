package seguridad.client.controller;
import seguridad.client.remote.RMIServiceLocator;
import seguridad.server.data.Member;

import java.rmi.RemoteException;
import java.util.*;

public class ClientController {
	
	/**
	 * 
	 * Esta clase llama a la clase RMI para 
	 * enviar llamadas al servidor y asi poder ejecutar sus servicios.
	 * 
	 */
	
	private RMIServiceLocator myLocator;
	
	/**
	 * 
	 * Este m�todo es el constructor del controlador de cliente
	 * 
	 * @param rsl es el Servicio RMI
	 * 
	 */
	public ClientController(RMIServiceLocator rsl) throws Exception{
		this.myLocator = rsl;
	}

	/**
	 * 
	 * Este m�todo sirve para que el usuario se desconecta del Servidor
	 * 
	 * @param username Nombre del usuario que se quiere desconectar
	 */
	public void SignOut(String username) throws Exception{
		this.myLocator.getServerService().SignOut(username);
	}

	/**
	 * 
	 * Este m�todo sirve para conectarse con el servidor
	 * 
	 * @param username Nombre del usuario que se quiere conectar
	 * @param password Contrase�a del usuario
	 * @param otpc OTP recibida de OTPGenerator
	 * 
	 */
	public boolean SignIn(String username, String password, String otpc)  throws Exception{
		return this.myLocator.getServerService().SignIn(username,password,otpc);
		
	}
	
	/**
	 * 
	 * Este m�todo sirve para recibir una lista de todos los miembros de la BD
	 * 
	 * @param admin Nombre del usuario administrador
	 * 
	 */
	public ArrayList<String> getAllMembers(String admin)  throws Exception{
		return this.myLocator.getServerService().getallMembers(admin);
	}
	
	/**
	 * 
	 * Este m�todo sirve para recibir una lista de los usuarios con el nombre especificado
	 * 
	 * @param user Nombre del usuario que se quiere obtener
	 * 
	 */
	public List<String> getmem(String user) throws Exception{
		return this.myLocator.getServerService().getmem(user);
	}
		
}
