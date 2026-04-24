package bgms.product;

public class BoardGame extends Product {
	
	private int maxPlayers;
	private gameType type;
	
	public BoardGame(String productId, String name, double price, double purchaseCost, int stock, String type, int maxPlayers) {
		super(productId, name, price, purchaseCost, stock);
		this.maxPlayers = maxPlayers;
		setGameType(type);
		
	}
	
	//Setters
	public void setGameType(String type) {
		if(type.equalsIgnoreCase("Strategy")) {
			this.type = gameType.STRATEGY;
		}else if (type.equalsIgnoreCase("Party")) {
			this.type = gameType.PARTY;
		} else {
			throw new IllegalArgumentException("Invalid game type: " + type);
		}
	}
	
	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}
	
	//Getters
	public gameType getGameType() {
		return type;
	}
	
	public int getMaxPlayers() {
		return maxPlayers;
	}
	
	
	
	//toString method which overrides the method in Product class
	//boolean parameter to determine if admin view or customer view. If admin view, include purchase cost, otherwise exclude it.
	@Override
	public String toString(boolean isAdmin) {
		if (isAdmin) {
			return String.format("ID: %6s | Name: %30s | Price: £%6.2f | Stock: %6d | Type: %20s | %-15s: %20d | Purchase Cost: %6.2f", getProductId(), getName(), getPrice(), getStock(), getGameType().toString(), "Max Players", getMaxPlayers(), getPurchaseCost());
		} else {
			return String.format("ID: %6s | Name: %30s | Price: £%6.2f | Stock: %6d | Type: %20s | %-15s: %20d", getProductId(), getName(), getPrice(), getStock(), getGameType().toString(), "Max Players", getMaxPlayers());
		}
	}
	
	public String[] getAttributesAsArray()
	{
		return new String[] {getProductId(), "board game", getGameType().toString(), getName(), String.format("%.2f", getPrice()), String.valueOf(getStock()), String.format("%.2f", getPurchaseCost()), String.valueOf(getMaxPlayers())};
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
