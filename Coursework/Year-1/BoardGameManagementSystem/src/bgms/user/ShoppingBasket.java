package bgms.user;

import java.util.LinkedHashMap;
import java.util.Map;
import bgms.product.*;

public class ShoppingBasket 
{
	
	private Map<Product, Integer> items;
	
	public ShoppingBasket()
	{
		this.items = new LinkedHashMap<>(); //linked hash map keeps the order of insertion
	}
	
	public void addItem(Product product, int quantity) 
	{
		if (items.containsKey(product)) {
			items.put(product, items.get(product) + quantity);
		} else {
			items.put(product, quantity);
		}
	}
	
	public void removeItem(Product product, int quantity) 
	{
		if (items.containsKey(product)) {
			int currentQuantity = items.get(product);
			if (quantity >= currentQuantity) {
				items.remove(product);
			} else {
				items.put(product, currentQuantity - quantity);
			}
		}
	}
	
	public void removeItem(Product product) 
	{
		items.remove(product);
	}
	
	public void clearBasket() 
	{
		items.clear();
	}
	
	public double getTotalPrice() 
	{
		double total = 0.0;
		for (Map.Entry<Product, Integer> entry : items.entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			total += product.getPrice() * quantity;
		}
		return total;
	}
	
	public Map<Product, Integer> getItems() 
	{
		return items;
	}
	
	public void printBasketContents() 
	{
		if (items.isEmpty()) {
			System.out.println("Your shopping basket is empty.");
		} else {
			System.out.println("Shopping Basket Contents:");
			for (Map.Entry<Product, Integer> entry : items.entrySet()) {
				Product product = entry.getKey();
				int quantity = entry.getValue();
				System.out.println(product.getName() + " - Price: £" + product.getPrice() + " - Quantity: " + quantity + " - Subtotal: £" + (product.getPrice() * quantity));
			}
			System.out.println("Total Price: £" + getTotalPrice());
		}
	}
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
