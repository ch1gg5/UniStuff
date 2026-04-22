package bgms.product;

public enum gameType {
	
	STRATEGY("Strategy"),
	PARTY("Party");
	
	private String type;
	
	private gameType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}

}
