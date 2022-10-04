package model;

public class User {
	private String id;

	public User(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		User aux=(User)obj;
		if(this.id.equals(aux.id)) {
			
		}
		return super.equals(obj);
	}
	
}
