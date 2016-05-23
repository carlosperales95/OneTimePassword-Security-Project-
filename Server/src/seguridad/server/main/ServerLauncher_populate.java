package seguridad.server.main;
import java.util.Date;


import seguridad.server.service.ServerService;

//POPULATE ONLY
public class ServerLauncher_populate{
	
	public static void main(String[] args){
		ServerService ts1 = null;
		
		try{
			ts1 = new ServerService();
			ts1.register(true, "astrain25", "astrain25", "Jon Bilbao", "jon.bilbao@opendeusto.com", new Date(), "calle de jonbi", "Basque Country");
			ts1.register(true, "amin456", "1234", "Yoshiyahu Kenneth", "jyoshiayuk@yahoo.com", new Date(), "calle de japon 1", "Japan");
			ts1.register(true, "mackicorm8", "password", "Mac Cormaic", "macCormaic@gmail.com", new Date(), "calle de america numero 4", "New York");
			ts1.register(true, "shevi_mon", "1234", "Shevon Monday", "shev_london@gmail.com", new Date(), "Picadilly 345", "London");
			
			ts1.register(false, "carlos95", "1234", "Carlos Perales", "carlos.perales@opendeusto.com", new Date(), "calle de carlos", "Rep. independiente de mi casa");		
			ts1.register(false, "vlad.empaik", "password", "Vladimir Aiken", "vlad_empaler@outlook.com", new Date(), "calle en la que vive este señor", "lejos");
			ts1.register(false, "ninstur", "1234", "Ninoslav Arthur", "ruskininosl@vk.com", new Date(), "calle rusa 3", "Russia");
			ts1.register(false, "choe222", "1212", "Nico Choe", "choemail@gmail.com", new Date(), "calle aleatoria", "Aqui no");
			
		}catch(Exception e){
			e.printStackTrace();
		}		
	}
	//POPULATE ONLY
}
