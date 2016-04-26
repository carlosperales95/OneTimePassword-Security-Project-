package seguridad.server.main;

import java.rmi.RemoteException;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import seguridad.server.data.Member;
import seguridad.server.remote.facade.ServerFacade;
import seguridad.server.service.ServerService;

public class ServerLauncher {
	public static void main(String[] args){
		//try{
			ServerService ts1;
			try {
				ts1 = new ServerService();
				ServerFacade tf = new ServerFacade(args[0], args[1], args[3], ts1);
				//ts1.SignIn("astrain25", "astrain25");
			//	ts1.getallMembers("admin");
			//	tf.SignIn("astrain25", "astrain25");
			//	tf.getallMembers("user");

			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
	}
}
