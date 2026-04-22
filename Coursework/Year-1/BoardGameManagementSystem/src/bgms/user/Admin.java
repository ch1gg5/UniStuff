package bgms.user;
import bgms.product.Product;
import bgms.product.StockManager;

public class Admin extends User {
	
	public Admin(int userId, String name, Address address) {
		super(userId, name, address);
	}
	
	public void addProductToStock(Product product, StockManager stockManager) {
		stockManager.addProduct(product);
	}

}
