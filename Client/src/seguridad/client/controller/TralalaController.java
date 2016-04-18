package seguridad.client.controller;
import deusto.ingenieria.sd.tralala.tralalaserver.dto.SongDTO;
import seguridad.client.remote.RMIServiceLocator;

import java.util.*;

public class TralalaController {
	private RMIServiceLocator myLocator;

	/**
	 * 
	 * @param username
	 */
	public void SignOut(String username) throws Exception{
		myLocator.getTralalaService().SignOut(username);
	}

	/**
	 * 
	 * @param username
	 */
	public void removeMember(String username) throws Exception {
		myLocator.getTralalaService().removeMember(username);
	}

	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param address
	 * @param country
	 */
	public void SignUp(String username, String name, String password, String email, Date birthdate, String address, String country, String billingInfo, String paymentInfo)  throws Exception{
		myLocator.getTralalaService().SignUp(username, name,password,email,birthdate,address,country, billingInfo, paymentInfo);
	}

	/**
	 * 
	 * @param username
	 * @param songname
	 */
	public SongDTO streamSong(String username, String songname) throws Exception{
		return myLocator.getTralalaService().streamSong(username,songname);
	}

	/**
	 * 
	 * @param songName
	 * @param album
	 * @param artist
	 * @param lyrics
	 */
	public SongDTO[] searchSong(String songName, String album, String artist, String lyrics)throws Exception{
		return myLocator.getTralalaService().searchSong(songName, album, artist,lyrics);
	}

	/**
	 * 
	 * @param songname
	 * @param artist
	 * @param album
	 */
	public void removeSong(String songname, String artist, String album) throws Exception{
		myLocator.getTralalaService().removeSong(songname, artist, album);
	}

	/**
	 * 
	 * @param email
	 * @param name
	 */
	public ArrayList<String> searchUser(String email, String name) throws Exception{
		return myLocator.getTralalaService().searchUser(email,name);
	}

	/**
	 * 
	 * @param username
	 * @param name
	 * @param email
	 * @param birthdate
	 * @param address
	 * @param country
	 */
	public void updateProfile(String username, String name, String email, Date birthdate, String address, String country) throws Exception{
		myLocator.getTralalaService().updateProfile(username, name,email,birthdate,address,country);
	}

	/**
	 * 
	 * @param s
	 */
	public void addNewSong(SongDTO s) throws Exception{
		myLocator.getTralalaService().addNewSong(s);
	}

	/**
	 * 
	 * @param rsl
	 */
	public TralalaController(RMIServiceLocator rsl) {
		this.myLocator = rsl;
	}
}
