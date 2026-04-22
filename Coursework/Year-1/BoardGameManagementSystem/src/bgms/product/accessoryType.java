package bgms.product;

public enum accessoryType {
	
	DICE("Dice"),
	MINIATURE("Miniature"),
	KIT("Accessory Kit");
	
	private String type;
	
	private accessoryType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}

}
