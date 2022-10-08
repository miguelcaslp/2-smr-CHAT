package model;



public class Chat {
	private String id;

		
	public Chat(String id) {
		super();
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
		return "Chat [id=" + id + "]";
	}
	
	@Override
	public boolean equals(Object obj) {
		Chat aux=(Chat)obj;
		if(this.id.equals(aux.id)) {
			
		}
		return super.equals(obj);
	}
	
	
	
}
