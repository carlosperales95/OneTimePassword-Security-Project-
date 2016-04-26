package seguridad.server.main;
import java.util.Date;


import seguridad.server.service.ServerService;
//POPULATE ONLY
import java.io.File;
import java.io.FileInputStream;

public class ServerLauncher_populate{
	
	public static void main(String[] args){
		ServerService ts1 = null;
		
		try{
			ts1 = new ServerService();
			ts1.register(true, "astrain25", "astrain25", "Jon Bilbao", "jon.bilbao@opendeusto.com", new Date(), "calle de jonbi", "Basque Country");
			ts1.register(false, "carlos95", "1234", "CARLOS PERALES", "jon.bilbao@opendeusto.com", new Date(), "calle de jonbi", "Basque Country");

			
		}catch(Exception e){
			e.printStackTrace();
		}
			
	}
	
	
	//POPULATE ONLY


}
