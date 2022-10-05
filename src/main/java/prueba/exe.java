package prueba;


import Dao.UsersDao;

import model.User;

public class exe {
	public static void main(String[] args) {
	User a = new User ("mario");
	User b = new User ("marilo");
	
	UsersDao us= new UsersDao();
	System.out.println(us.addUser(a));
	System.out.println(us.addUser(b));
	System.out.println(us.dirUser(b));
	
		
	}
}
