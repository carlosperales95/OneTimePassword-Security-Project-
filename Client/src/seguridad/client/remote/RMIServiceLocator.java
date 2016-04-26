package seguridad.client.remote;

import seguridad.server.remote.interfaces.IServerManager;

public class RMIServiceLocator {

	//a little cache

	IServerManager servermanager;


	/**
	 * 
	 * @param ip
	 * @param port
	 * @param tralalaName
	 * @param loginName
	 * @param paymentName
	 */
	public RMIServiceLocator(String ip, String port, String serverName) {
		this.setServerService(ip,port,serverName);

	}

	/**
	 * 
	 * @param ip
	 * @param port
	 * @param serviceName
	 */
	public void setServerService(String ip, String port, String serviceName) {
		System.out.println("Called setservice");	
		System.out.println("Server: //"+ip+":"+port+"/"+ serviceName );
		String qname = "//"+ip+":"+port+"/"+serviceName;
		System.out.println(qname);
		try{
			this.servermanager = (IServerManager)java.rmi.Naming.lookup(qname);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	


	public IServerManager getServerService() {
		if(servermanager==null)System.out.println("Null main");
		//else System.out.println(servermanager.toString());
		return this.servermanager;
	}



}
