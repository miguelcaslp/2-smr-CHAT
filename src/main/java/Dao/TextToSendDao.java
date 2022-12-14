package Dao;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import model.TextToSend;

@XmlRootElement(name = "Mensajes")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextToSendDao implements Serializable {

	private static final long serialVersionUID = 1L;
	private ArrayList<TextToSend> chats;
	private final String URL="C:\\Users\\jmcgo\\Desktop\\Eclipse\\2-smr-CHAT\\Chats\\";
	
	
	
	public ArrayList<TextToSend> orderMensagesbydate(String url) {
		return chats;
	}
	
	
	public void addTexttoSend (TextToSend c,String chat) {
		chat= URL+chat+".xml";
		this.chats= new ArrayList<TextToSend>();
		File file = new File(chat);
		if(file.exists()) {
			this.chats=loadFile(chat);
			this.chats.add(c);
			saveFile(chat, chats);
		}else {
			this.chats.add(c);
			saveFile(chat, chats);
		}
		
	}
	
	
	public void saveFile(String url, ArrayList<TextToSend> chats) {
		this.chats=chats;
		JAXBContext contexto;
		try {
			contexto = JAXBContext.newInstance(TextToSendDao.class);
			Marshaller m = contexto.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			m.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");
			m.marshal(this, new File(url));
		} catch (JAXBException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<TextToSend> loadFile(String url) {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(TextToSendDao.class);
			Unmarshaller um = context.createUnmarshaller();
			TextToSendDao newChats = (TextToSendDao) um.unmarshal(new File(url));
			chats = newChats.chats;
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return chats;
	}
	
	public ArrayList<TextToSend> loadMessages(String url) {
		url = URL+url+".xml";
		return loadFile(url);
	}

	@Override
	public String toString() {
		return "chats= " + chats ;
	}
	
	

}
