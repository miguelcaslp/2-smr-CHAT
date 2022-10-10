package prueba;

import java.time.LocalDateTime;

import Dao.UsersDao;
import model.User;

public class exe {
	
	public static void main(String[] args) {
		User u = new User("Manolitoo");
		User u2 = new User("Caaaarlos");
		System.out.println(u.equals(u2));
		//System.out.println(controller.Controller.validNick("Mdddd"));
		
	}
	 
	        
}
