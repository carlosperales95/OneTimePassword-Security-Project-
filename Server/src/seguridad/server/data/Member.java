package seguridad.server.data;

import java.util.*;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Member {
	
	@PrimaryKey
	private String username;
	private boolean admin;
	private String password;
	private String name;
	private String email;
	private Date birthdate;
	private String address;
	private String country;

 

	public Member(boolean admin, String username,String password, String name, String email, Date birthdate, String address, String country,String billingInfo, String paymentMethod) {
		this.admin = admin;
		this.username = username;
		this.password = password;
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;
		this.address = address;
		this.country = country;

	}

	public String toString(){
		return this.username+" "+this.password+" "+this.name+" "+this.email+" "+this.birthdate+" "+this.address+" "+this.country+" ";
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setAdmin(boolean admin){
		this.admin = admin;
	}
	
	public void setPassword(String password){
		this.password = password;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public void setBirthdate(Date birthdate){
		this.birthdate = birthdate;
	}

	public void setAddress(String address){
		this.address = address;
	}

	public void setCountry(String country){
		this.country = country;
	}

	public String getUsername(){
		return this.username;
	}
	
	public boolean getAdmin(){
		return this.admin;
	}
	
	public String getPassword(){
		return this.password;
	}

	public String getName(){
		return this.name;
	}

	public String getEmail(){
		return this.email;
	}

	public String getAddress(){
		return this.address;
	}

	public String getCountry(){
		return this.country;
	}

}
