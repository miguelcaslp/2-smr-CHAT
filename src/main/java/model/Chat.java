package model;

public class Chat {
	private String id;
	private int online;

	public Chat(String id) {
		super();
		this.id = id;
		this.online = 0;
	}
	
	public Chat(String id, int online) {
		super();
		this.id = id;
		this.online = online;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	@Override
	public String toString() {
		return "Chat [id=" + id + "]";
	}

	@Override
	public boolean equals(Object obj) {
		Chat aux = (Chat) obj;
		if (this.id.equals(aux.id)) {

		}
		return super.equals(obj);
	}

}
