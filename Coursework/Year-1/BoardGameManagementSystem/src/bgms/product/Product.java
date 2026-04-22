package bgms.product;

public abstract class Product {
	private String productId;
	private String name;
	private double price;
	private double purchaseCost;
	private int stock;
	
	public Product(String productId, String name, double price, double purchaseCost, int stock) {
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.purchaseCost = purchaseCost;
		this.stock = stock;
	}
	
	//Setters
	public void setProductId(String productId) {
		this.productId = productId;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public void setPurchaseCost(int purchaseCost) {
		this.purchaseCost = purchaseCost;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void incrementStock(int amount) {
		this.stock += amount;
	}
	
	//Getters
	public String getProductId() {
		return productId;
	}
	
	public String getName() {
		return name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public double getPurchaseCost() {
		return purchaseCost;
	}
	
	public int getStock() {
		return stock;
	}
	
	//create a to string method which will be overriden by subclasses.
	//mode is a flag to determine if the view is admin view (1) or customer view (0)
	public abstract String toString(boolean isAdmin);
	
	public abstract String[] getAttributesAsArray();
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


}
