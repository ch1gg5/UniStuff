package bgms.user;

public class Address {
	
	private String houseNumber;
	private String postCode;
	private String city;
	
	
	//Constructor
	public Address(String houseNumber, String postCode, String city) {
		this.houseNumber = houseNumber;
		this.postCode = postCode;
		this.city = city;
	}
	
	//Setter
	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}
	
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	//Getter
	public String getHouseNumber() {
		return houseNumber;
	}
	
	public String getPostCode() {
		return postCode;
	}
	
	public String getCity() {
		return city;
	}
	
	//returns the address in the format "houseNumber, postCode, city"
	public String toString() {
		return String.format("%s, %s, %s", houseNumber, postCode, city);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
