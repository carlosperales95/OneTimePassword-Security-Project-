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
			} catch (RemoteException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		//	ts1.SignIn("astrain25", "astrain25");
		//	ts1.getallMembers().get(0).toString();
			// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
			PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
			// Persistence Manager
			PersistenceManager pm = null;
			//Transaction to group DB operations
			Transaction tx = null;	
			
			Member[] remember = new Member[100];
			String name="astrain25";
			String email="";
			
			int i = 0;
			try{
				System.out.println("INFO: Getting all the users from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				
				
				Extent<Member> extent = pm.getExtent(Member.class, true);
				
				
			for(Member m: extent){
				
				if(name.equals(m.getName()) || email.equals(m.getEmail())){
					remember[i] = m;
				}
				
					System.err.println(m);
					i++;
				}
					
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("WARN: Exception when retrieving from database");
			}finally{
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}
				
				if (pm != null && !pm.isClosed()) {
					pm.close();
				}
			
			}
	}
}
