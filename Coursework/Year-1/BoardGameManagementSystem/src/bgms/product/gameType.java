package bgms.product;

public enum gameType {
	
	STRATEGY("strategy"),
	PARTY("party");
	
	private String type;
	
	private gameType(String type) {
		this.type = type;
	}
	
	public String toString() {
		return type;
	}

}
