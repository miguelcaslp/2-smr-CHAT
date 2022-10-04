package Dao;

import java.io.File;


public class ChatDao {

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
