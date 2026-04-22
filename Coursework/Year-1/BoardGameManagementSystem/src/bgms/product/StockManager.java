package bgms.product;

import java.util.ArrayList;
import java.util.List;

import bgms.FileHandler.*;

public class StockManager 
{
	
	private List<Product> stock;
	private FileHandler fileHandler;
	
	public StockManager() {
		this.fileHandler = new FileHandler();
		this.stock = new ArrayList<>();
		loadStock();
	}
	
	public void loadStock()
	{
		String[][] data = fileHandler.readFile("Stock.txt");
		for( String[] row : data)
		{
			String productId = row[0];
			String category = row[1].trim();
	        String type = row[2].trim();
	        String name = row[3].trim();
	        double price = Double.parseDouble(row[4].trim());
	        int quantity = Integer.parseInt(row[5].trim());
	        double purchaseCost = Double.parseDouble(row[6].trim());
	        String extra = row[7].trim();

	        if (category.equals("board game")) 
	        {
	        	BoardGame boardGame = new BoardGame(productId, name, price, purchaseCost, quantity, type, Integer.parseInt(extra));
	            stock.add(boardGame);
	            
	        } else 
	        {
	            Accessory accessory = new Accessory(productId, name, price, purchaseCost, quantity, type, extra);
	            stock.add(accessory);
	        }
	        
			
		}
	}
	
	public void addProduct(Product product) 
	{
		stock.add(product);
		fileHandler.appendToFile("Stock.txt", product.getAttributesAsArray());
	}
	
	public void increaseProductStock(Product product, int amount) 
	{
		//clone the product and update the stock of the clone, then replace the line in the file with the updated clone
		if(product instanceof BoardGame) 
		{
			BoardGame updatedProduct = new BoardGame(product.getProductId(), product.getName(), product.getPrice(), product.getPurchaseCost(), product.getStock() + amount, ((BoardGame) product).getGameType().toString(), ((BoardGame) product).getMaxPlayers());
			stock.remove(product);
			stock.add(updatedProduct);
			fileHandler.replaceLine("Stock.txt", product.getAttributesAsArray(), updatedProduct.getAttributesAsArray());
		} else if (product instanceof Accessory) 
		{
			Accessory updatedProduct = new Accessory(product.getProductId(), product.getName(), product.getPrice(), product.getPurchaseCost(), product.getStock() + amount, ((Accessory) product).getAccessoryType().toString(), ((Accessory) product).getCompatibility());
			stock.remove(product);
			stock.add(updatedProduct);
			fileHandler.replaceLine("Stock.txt", product.getAttributesAsArray(), updatedProduct.getAttributesAsArray());
		}
		
	}
	
	public Product findById(String productId) 
	{
		for (Product product : stock) 
		{
			if (product.getProductId().equals(productId)) 
			{
				return product;
			}
		}
		return null; // Return null if no product with the given ID is found
	}
	
	public List<Product> getAllSortedByPrice() 
	{
		List<Product> sortedStock = new ArrayList<>(stock);
		sortedStock.sort((p1, p2) -> Double.compare(p1.getPrice(), p2.getPrice())); //using lambda to sort the stock
		return sortedStock;
	}
	
	public List<Product> filterByCompatibility(String compatibility) 
	{
		List<Product> filteredStock = new ArrayList<>();
		for (Product product : stock) {
			if (product instanceof Accessory) 
			{
				Accessory accessory = (Accessory) product;
				if (accessory.getCompatibility().equalsIgnoreCase(compatibility)) 
				{
					filteredStock.add(accessory);
				}
			}
		}
		return filteredStock;
	}
	
	
	public List<Product> getStock() {
		return stock;
	}
	
	//display stock
	public void displayStock(boolean isAdmin)
	{
		for (Product product : stock) 
		{
			System.out.println(product.toString(isAdmin));
		}
	}
	
	

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Test the stock manager by loading the stock and displaying it
		StockManager stockManager = new StockManager();
		stockManager.displayStock(true);

	}

}
