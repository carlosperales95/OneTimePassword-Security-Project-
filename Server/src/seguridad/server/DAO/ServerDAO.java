package seguridad.server.DAO;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Date;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import seguridad.server.data.Member;

import javax.jdo.Query;

public class ServerDAO implements IServerDAO {
		//Add here whatever you need	
		//This piece of code will be executed once when the object instance is created.
		//If you need to do any initialization, do it here.
		
		
		// Load Persistence Manager Factory - referencing the Persistence Unit defined in persistence.xml
		PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
		// Persistence Manager
		PersistenceManager pm = null;
		//Transaction to group DB operations
		Transaction tx = null;		
				
		
		/**
		 * 
		 * @param username
		 */
		@SuppressWarnings("finally")
		public Member getUser(String username) {
			Member remember = null;
			try{
				System.out.println("INFO: Getting the user from the db: ");
				pm = pmf.getPersistenceManager();
				//Obtain the current transaction
				tx = pm.currentTransaction();		
				//Start the transaction
				tx.begin();
				
				Query q = pm.newQuery(Member.class);
				q.setFilter("username == user_name");
				q.declareParameters("String user_name");
				List<Member> result = (List<Member>)q.execute(username);			
				
				if(!result.isEmpty())remember = result.get(0);
					
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
				System.out.println("getMember() Returning " + remember);
				return remember;
			}
		}

		/**
		 * 
		 * @param username
		 * @param name
		 * @param email
		 */
		@SuppressWarnings("finally")
		public Member[] searchUser(String name, String email) {
			Member[] remember = new Member[100];
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
				return remember;
			}
			
		}

	
}
