package Dao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class ChatDao {
	
	public ArrayList<String> listaChats(){
		ArrayList<String> chats = new ArrayList<String>();
		File carpeta = new File("C:\\Users\\Miguel\\Documents\\add\\chat\\Chats");
		for (final File ficheroEntrada : carpeta.listFiles()) {
		   chats.add(ficheroEntrada.getName());    
		}
		return chats;
		
	}

	public boolean createChat(String name) {
		boolean valid=false;
		try {
		    String ruta = "C:\\folders\\" + name + ".xml";
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
