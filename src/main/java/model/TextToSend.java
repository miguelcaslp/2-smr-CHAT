package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Mensaje")
@XmlAccessorType(XmlAccessType.FIELD)
public class TextToSend implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private String text;
	private String time;
	
	
	
	public TextToSend() {
		this(null,"");
	}

	public TextToSend(User user, String text) {
		this.user = user;
		this.text = text;
		DateTimeFormatter dtf4 = DateTimeFormatter.ofPattern("HH:mm MM/dd");
		this.time=dtf4.format(LocalDateTime.now());
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TextToSend [user=" + user + ", text=" + text + ", time=" + time + "]";
	}
	
	
	
	
	
	
}
