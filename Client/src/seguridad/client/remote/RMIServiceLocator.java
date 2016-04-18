package seguridad.client.remote;


public class RMIServiceLocator {

	//a little cache

	static IServerManager bankM;


	/**
	 * 
	 * @param ip
	 * @param port
	 * @param tralalaName
	 * @param loginName
	 * @param paymentName
	 */
	public RMIServiceLocator(String ip, String port, String serverName) {
		//this.setServerService(ip,port,serverName);

	}

	/**
	 * 
	 * @param ip
	 * @param port
	 * @param serviceName
	 */
	public void setServerService(String ip, String port, String serviceName) {
		String qname = "//"+ip+":"+port+"/"+serviceName;
		try{
			this.bankM = (IServerManager)java.rmi.Naming.lookup(qname);
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public IServerManager getTralalaService() {
		return this.bankM;
	}



}
