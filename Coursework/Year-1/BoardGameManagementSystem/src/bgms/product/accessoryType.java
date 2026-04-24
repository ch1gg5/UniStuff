package bgms.product;

public enum accessoryType {
	
	DICE("dice"),
	MINIATURE("miniature"),
	KIT("accessory kit");
	
	private String type;
	
	private accessoryType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}

}
