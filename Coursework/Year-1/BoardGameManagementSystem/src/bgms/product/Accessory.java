package bgms.product;

public class Accessory extends Product {
	
	private String compatibility;
	private accessoryType type;
	
	public Accessory(int productId, String name, double price, double purchaseCost, int stock, String type, String compatibility) {
		super(productId, name, price, purchaseCost, stock);
		this.compatibility = compatibility;
		setAccessoryType(type);
	}
	
	//Setters
	public void setCompatibility(String compatibility) {
		this.compatibility = compatibility;
	}
	
	public void setAccessoryType(String type) {
		if(type.equalsIgnoreCase("Dice")) {
			this.type = accessoryType.DICE;
		}else if (type.equalsIgnoreCase("Miniature")) {
			this.type = accessoryType.MINIATURE;
		} else if (type.equalsIgnoreCase("Accessory Kit")) {
			this.type = accessoryType.KIT;
		} else {
			throw new IllegalArgumentException("Invalid accessory type: " + type);
		}
	}
	
	//Getters
	public String getCompatibility() {
		return compatibility;
	}
	
	public accessoryType getAccessoryType() {
		return type;
	}
	
	
	//toString method which overrides the method in Product class
	//boolean parameter to determine if admin view or customer view. If admin view, include purchase
	//cost, otherwise exclude it.
	@Override
	public String toString(boolean isAdmin) {
		if (isAdmin) {
			return String.format("ID: %6d | Name: %30s | Price: £%6.2f | Stock: %6d | Type: %20s | %-15s: %20s | Purchase Cost: %6.2f", getProductId(), getName(), getPrice(), getStock(), getAccessoryType().toString(), "Compatibility", getCompatibility(), getPurchaseCost());
		} else {
			return String.format("ID: %6d | Name: %30s | Price: £%6.2f | Stock: %6d | Type: %20s | %-15s: %20s", getProductId(), getName(), getPrice(), getStock(), getAccessoryType().toString(), "Compatibility", getCompatibility());
		}
	}
	
	public String[] getAttributesAsArray()
	{
		return new String[] {String.valueOf(getProductId()), "accessory", getAccessoryType().toString(), getName(), String.format("%.2f", getPrice()), String.valueOf(getStock()), String.format("%.2f", getPurchaseCost()), getCompatibility()};
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}