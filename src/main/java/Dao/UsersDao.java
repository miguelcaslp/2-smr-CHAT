package Dao;

import java.io.File;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import controller.Controller;
import model.Chat;
import model.User;

@XmlRootElement(name = "Usuarios")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashSet<User> users;
	private final String URL="C:\\Users\\jmcgo\\Desktop\\Eclipse\\2-smr-CHAT\\Users\\usuarios.xml";
	
	/**
	 * Introduce usuarios 
	 * @param a Usuario a introducir
	 * @return true si se introducido el usuario y false si no se ha podido
	 */
	public boolean addUser(User a) {
		boolean valid=true;
		this.users = new HashSet<User>();
		File file = new File(URL);
		if(file.exists()) {
			this.users = loadFile();	
		}else {
			users.add(a);
			saveFile(URL,users);
		}
			
		if(this.users!=null) {
			if(!users.isEmpty()) {
				for(User s: users) {
					if(s.equals(a)) {
						//ya hay un usuario con ese nombre y no se guarda
						valid=false;
					}
				}
			}
		}else {
			this.users = new HashSet<User>();
			users.add(a);
			saveFile(URL,users);
		}
		
		if(valid==true ) {
			users.add(a);
			saveFile(URL,users);
		}
		
		return valid;
	}
	
	public void TimeUpdate() {
		User user = Controller.getUser();
		if(user!=null) {
			
			this.users = loadFile();
			if(users==null){
				this.users = new HashSet<User>();
			}
			
			for(User s: users) {
				if(s.equals(user)) {
					System.out.println("Hola");
					removeUser(s);
					addUser(new User(s.getId(),s.getIdChat()));
					
				}else {
					
				}
			}
			
			
			
		}
		
	}
	
	public void rmUsersForTime() {
		this.users = new HashSet<User>();
		if(users.isEmpty()) {
			try {
				this.users = loadFile();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		for(User s: users) {
			
			if(LocalDateTime.parse(s.getTime()).isBefore(LocalDateTime.now().minusMinutes(1))) {
				removeUser(s);
			}else {
				
			}
		}
		
		
	}
	
	
	
	/**
	 * Eliminar usuarios 
	 * @param a Usuario a eliminar
	 * @return true si se borrado el usuario y false si no se ha podido
	 */
	public boolean removeUser(User a) {
		boolean valid=false;
		this.users = new HashSet<User>();
		if(users.isEmpty()) {
			try {
				this.users = loadFile();
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		for(User s: users) {
			if(s.equals(a)) {
				a=s;
				valid=true;
			}else {
				
			}
		}
		
		if(valid==true) {
			users.remove(a);
			saveFile(URL,users);
		}
		
		return valid;
	}
	
	public void saveFile(String url, HashSet<User> users) {
		this.users=users;
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(UsersDao.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public HashSet<User> loadFile() {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(UsersDao.class);
			Unmarshaller um = context.createUnmarshaller();
			UsersDao newUsers = (UsersDao) um.unmarshal(new File(URL));
			users = newUsers.users;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public String toString() {
		return "Usuarios= " + users ;
	}
	
	
	
	

}
