package model;


import java.time.LocalDateTime;

public class User {
	private String id;
	private String idChat;
	private String time;
	

	public User() {
		this("default","");
	}
	
	
	public User(String id) {
		this.id = id;
		this.idChat = null;
		this.time = LocalDateTime.now().toString();
	}


	public User(String id, String idChat) {
		this.id = id;
		this.idChat = idChat;
		this.time = LocalDateTime.now().toString();
	}
	


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getIdChat() {
		return idChat;
	}

	public void setIdChat(String idChat) {
		this.idChat = idChat;
	}


	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	


	@Override
	public String toString() {
		return "User [id=" + id + ", idChat=" + idChat + ", time=" + time + "]";
	}


	@Override
	public boolean equals(Object obj) {
		User aux=(User)obj;
		if(this.id.equals(aux.id)) {
			return true;
		}
		return false;
	}
	
}
