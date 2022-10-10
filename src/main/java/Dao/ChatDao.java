package Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;

import model.Chat;
import model.User;


public class ChatDao {
	
	public ArrayList<String> listaNamesChats(){
		ArrayList<String> chats = new ArrayList<String>();
		File carpeta = new File("C:\\Users\\jmcgo\\Desktop\\Eclipse\\2-smr-CHAT\\Chats\\");
		for (final File ficheroEntrada : carpeta.listFiles()) {
			chats.add(ficheroEntrada.getName().replace(".xml", ""));    
		}
		return chats;
		
	}
	
	public ArrayList<Chat> chatsList(){
		ArrayList<String> nameChats = listaNamesChats();
		if(nameChats!=null) {
			ArrayList<Chat>chats = new ArrayList<Chat>();
			for(String s:nameChats) {
				chats.add(new Chat(s));
			}
			UsersDao us = new UsersDao();
			HashSet<User> users = us.loadFile();
			if(users!=null) {
				for(User u:users) {
					Chat aux= new Chat(u.getIdChat());
					for(Chat a: chats) {
						if(aux.equals(a)) {
							a.setOnline(a.getOnline()+1);
						}
					}
				}
				return chats;
				
			}else {
				return chats;
			}
		}else {
			ArrayList<Chat>chats = new ArrayList<Chat>();
			return chats;
		}
	}
	
	

	public boolean createChat(String name) {
		boolean valid=false;
		try {
		    String ruta = "C:\\Users\\jmcgo\\Desktop\\Eclipse\\2-smr-CHAT\\Chats\\" + name + ".xml";
		    File file = new File(ruta);
		    // Si el archivo no existe es creado
		        if (!file.exists()) {
		            file.createNewFile();
		            valid=true;
		        }
		        
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    }	
		return valid;
	}
	
	public boolean deleteChat(String name) {
		boolean valid=false;
		try {
		    String ruta = "C:\\folders\\" + name + ".xml";
		    File file = new File(ruta);
		    
		    // Si el archivo no existe es creado
		        if (file.exists()) {
		        	file.delete();
		        	valid=true;
		        }
		       
		    } catch (Exception e) {
		        e.printStackTrace();
		    }	
		return valid;
	}
	
}