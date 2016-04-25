package seguridad.server.DAO;


public class DAOFactory {

	/**
	 * 
	 * @param ITD
	 */
	public static IServerDAO getInstance(String type) {
		if(type.equals("db"))return ((IServerDAO)(new ServerDAO()));
		else return null;
	}

}
