package seguridad.server.service;
import java.util.*;
import java.io.*;
//import org.apache.commons.io.IOUtils;
import java.rmi.RemoteException;

public class ServerService {

	//private ITralalaDAO myPersistenceProvider;
	
	public void ServerService(String authIp, String authPort, String servName, String persistenceType) throws RemoteException{
		//this.setAuthServiceProvider(authIp, authPort, servName);
		//this.setPersistenceProvider(persistenceType);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 */
	/**public boolean SignIn(String username, String password) {
		try{
			if(this.myRemoteAuthServer.checkCombination(username, password)==true){
				System.out.println("User "+ username + " logged in successfully");
				return true;
			}
			else return false;
		}catch(RemoteException e){
			return false;
		}
	}**/

	/**private void setAuthServiceProvider(String ip, String port, String name){
		String fullname = "/"+"/" + ip + ":" + port + "/" + name;
		try{
                	myRemoteAuthServer = (IAuthServer) java.rmi.Naming.lookup(fullname);
		}catch(Exception e){
			e.printStackTrace();
		}
	}**/

	/**private void setPersistenceProvider(String type){
		this.myPersistenceProvider = DAOFactory.getInstance(type);
	}**/

	/**
	 * 
	 * @param username
	 */
	/**public void SignOut(String username) {
		System.out.println("User " + username + " logged out successfully");
	}**/

	/**public void UpdatePaymentInfo(String paymentMethod, String paymentInfo){
		//TODO: Implement me
	}**/

	/**
	 * 
	 * @param username
	 */
	/**public void removeMember(String username) {
		this.myPersistenceProvider.removeMember(username);
	}**/

	/**
	 * 
	 * @param username
	 * @param name
	 * @param password
	 * @param email
	 * @param birthdate
	 * @param address
	 * @param country
	 * @param billingInfo
	 * @param paymentMethod
	 */
	/**public void SignUp(String username, String name, String password, String email, Date birthdate, String address, String country, String billingInfo, String paymentMethod) {
		if(this.myPersistenceProvider.getMember(username)==null){
			System.out.println("Adding new member");		
			Member newMember = new Member(username, name, email, birthdate, address, country, billingInfo, paymentMethod);
			this.myPersistenceProvider.addMember(newMember);
			try{			
				this.myRemoteAuthServer.SignUp(username, password);
			}catch(Exception e){
				e.printStackTrace();
			}		
		}	
	}**/

	/**
	 * 
	 * @param username
	 * @param songname
	 */
	/**public SongDTO streamSong(String username, String songname) {
		Song selected = this.myPersistenceProvider.getSong(songname);
		Member player = this.myPersistenceProvider.getMember(username);
		Date now = Calendar.getInstance().getTime();
		Play play = new Play(player, selected, now, 0 );
		if(selected!=null){
			SongDTO ret = DTOAssembler.assemble(selected);
			this.myPersistenceProvider.addPlay(play);
			return ret;
		}
		else{
			 return null;			
		}	
	}**/


	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 */
	/**public ArrayList<String> searchUser(String name, String email) {
		Member[] hits = this.myPersistenceProvider.searchUser(name, email);
		ArrayList<String> retUserNames = new ArrayList<String>();
		for(int i = 0; i<hits.length; i++){
			retUserNames.add(hits[i].getUsername());
		}
		return retUserNames;
	}
**/
	/**
	 * 
	 * @param songname
	 * @param album
	 * @param artist
	 * @param lyrics
	 */
	/**public SongDTO[] searchSong(String songname, String album, String artist, String lyrics) {
		Song[] hits = this.myPersistenceProvider.searchSong(songname, album, artist, lyrics);
		SongDTO[] ret = new SongDTO[hits.length];
		for(int i = 0; i<hits.length; i++){
			ret[i] = DTOAssembler.assemble(hits[i]);
		}
		return ret;
	}**/

	/**
	 * 
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param address
	 * @param country
	 */
	/**public void updateProfile(String username, String name, String email, Date birthdate, String address, String country) {
		Member toUpdate = this.myPersistenceProvider.getMember(username);
		if(toUpdate!=null){
			if(name!=null)if(!name.equals(""))toUpdate.setName(name);
			if(email!=null)if(email.equals(""))toUpdate.setEmail(email);
			if(birthdate!=null)if (!birthdate.equals(""))toUpdate.setBirthdate(birthdate);
			if(address!=null)if(!address.equals(""))toUpdate.setAddress(address);
			if(country!=null)if(!country.equals(""))toUpdate.setCountry(country);

			this.myPersistenceProvider.removeMember(username);
			this.myPersistenceProvider.addMember(toUpdate);
		}
	}**/

	/**
	 * 
	 * @param songname
	 * @param price
	 * @param lyrics
	 * @param duration
	 * @param relDate
	 * @param album
	 * @param artist
	 */
	/**public void addNewSong(SongDTO toAdd) {
		Song addToPersistence = DTOAssembler.unassemble(toAdd);
		myPersistenceProvider.addSong(addToPersistence);
		return;
	}**/

	/**
	 * 
	 * @param songname
	 * @param artist
	 * @param album
	 */
	/**public void removeSong(String songname, String artist, String album) {
		this.myPersistenceProvider.removeSong(songname, artist, album);
	}**/

	/**
	 * 
	 * @param username
	 * @param newPassword
	 * @param old
	 */
	/**public boolean UpdatePassword(String username, String newPassword, String old) {
		try{
			return this.myRemoteAuthServer.UpdatePassword(username, newPassword, old);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}	
	}**/


}
