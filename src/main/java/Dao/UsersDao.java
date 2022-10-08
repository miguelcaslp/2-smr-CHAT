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

import model.User;

@XmlRootElement(name = "Usuarios")
@XmlAccessorType(XmlAccessType.FIELD)
public class UsersDao implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private HashSet<User> users;
	private final String URL="C:\\Users\\Miguel\\Documents\\add\\chat\\Users\\usuarios.xml";
	
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
			this.users = loadFile(URL);	
		}else {
			users.add(a);
			saveFile(URL,users);
		}
			
		
		
		if(!users.isEmpty()) {
			for(User s: users) {
				if(s.equals(a)) {
					//ya hay un usuario con ese nombre y no se guarda
					valid=false;
				}
			}
		}
		
		
		if(valid==true) {
			users.add(a);
			saveFile(URL,users);
		}
		
		return valid;
	}
	
	
	public void rmUsersForTime() {
		this.users = new HashSet<User>();
		if(users.isEmpty()) {
			try {
				this.users = loadFile(URL);
			} catch (Exception e) {
				e.getMessage();
			}
		}
		
		for(User s: users) {
			if(LocalDateTime.parse(s.getTime()).isBefore(LocalDateTime.now())) {
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
				this.users = loadFile(URL);
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
	
	public HashSet<User> loadFile(String url) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(UsersDao.class);
			Unmarshaller um = context.createUnmarshaller();
			UsersDao newUsers = (UsersDao) um.unmarshal(new File(url));
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
