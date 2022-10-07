package prueba;


import java.io.File;
import java.net.MalformedURLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import Dao.ChatDao;
import Dao.TextToSendDao;
import Dao.UsersDao;
import jcifs.smb.NtlmPasswordAuthentication;
import jcifs.smb.SmbException;
import jcifs.smb.SmbFile;
import model.TextToSend;
import model.User;

public class exe {
	public static void main(String[] args) throws SmbException {
		/*
		TextToSendDao td = new TextToSendDao();
		//td.addTexttoSend(new TextToSend(new User("abel"),"hola mundo"), "1ºSMR");
		HashSet<TextToSend> chats = new HashSet<TextToSend>();
		chats = td.loadFile("C:\\\\Users\\\\Miguel\\\\Documents\\\\add\\\\chat\\\\Chats\\\\1ºSMR.xml");
		
		System.out.println(chats);
		*/
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		String time=dtf4.format(LocalDateTime.now());
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String time2=dtf4.format(LocalDateTime.now());
		
		String prueba1= time.replace("/", "").replace(" ", "").replace(":","");
		String prueba2= time.replace("/", "").replace(" ", "").replace(":","");
		
		int t1 = Integer.parseInt(prueba1);
		int t2 = Integer.parseInt(prueba2);
		System.out.println(prueba1 +"  " + prueba2);
		
		/*
		if(t1>t2) {
			System.out.println("t1 mayor");
		}else {
			System.out.println("t2 mayor");
		}
		*/
		
		
	}

}
