package model;

import java.io.Serializable;


public class TextToSend implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private User user;
	private String text;
	private String time;
	
	
	
	public TextToSend() {
		this(null,"","");
	}

	public TextToSend(User user, String text, String time) {
		this.user = user;
		this.text = text;
		this.time = time;
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
