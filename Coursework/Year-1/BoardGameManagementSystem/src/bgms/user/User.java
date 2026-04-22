package bgms.user;

public abstract class User {
	private int userId;
	private String name;
	private Address address;
	
	public User(int userId, String name, Address address) {
		this.userId = userId;
		this.name = name;
		this.address = address;
	}
	
	//Setter
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	//Getter
	public int getUserId() {
		return userId;
	}
	
	public String getName() {
		return name;
	}
	
	public Address getAddress() {
		return address;
	}
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
