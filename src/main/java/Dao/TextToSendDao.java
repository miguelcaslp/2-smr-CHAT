package Dao;

import java.io.File;
import java.io.Serializable;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import model.TextToSend;
import model.User;

@XmlRootElement(name = "Chats")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextToSendDao implements Serializable {

	private static final long serialVersionUID = 1L;
	private HashSet<TextToSend> chats;
	private final String URL="C:\\Users\\Miguel\\Documents\\add\\chat\\Chats\\";
	
	
	public void saveFile(String url, HashSet<TextToSend> chats) {
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
	
	public HashSet<TextToSend> loadFile(String url) {
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

	@Override
	public String toString() {
		return "chats= " + chats ;
	}
	
	

}
