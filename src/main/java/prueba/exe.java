package prueba;


import java.net.MalformedURLException;
import java.util.HashSet;

import Dao.TextToSendDao;
import Dao.UsersDao;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import model.TextToSend;
import model.User;

public class exe {
	public static void main(String[] args) throws SmbException {
		TextToSend d = new TextToSend(new User ("manolo"),"hola que tal", "11/11/2020");
		TextToSendDao td = new TextToSendDao();
		HashSet<TextToSend> list= new HashSet<TextToSend>();
		list.add(d);
		td.saveFile("C:\\Users\\Miguel\\Documents\\add\\chat\\Chats\\prueba.xml", list);
	
		
	}
}
