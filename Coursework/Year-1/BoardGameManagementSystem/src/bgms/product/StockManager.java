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
			int productId = Integer.parseInt(row[0]);
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
		//Find the product in the stock list to ensure we have the correct reference and state
		Product stockProduct = findById(product.getProductId());
		if (stockProduct == null) return; //product not found in stock
		
		//Store the original state before modification
		String[] originalAttributes = stockProduct.getAttributesAsArray();
		
		//clone the product and update the stock of the clone, then replace the line in the file with the updated clone
		if(stockProduct instanceof BoardGame) 
		{
			BoardGame updatedProduct = new BoardGame(stockProduct.getProductId(), stockProduct.getName(), stockProduct.getPrice(), stockProduct.getPurchaseCost(), stockProduct.getStock() + amount, ((BoardGame) stockProduct).getGameType().toString(), ((BoardGame) stockProduct).getMaxPlayers());
			stock.remove(stockProduct);
			stock.add(updatedProduct);
			fileHandler.replaceLine("Stock.txt", originalAttributes, updatedProduct.getAttributesAsArray());
		} else if (stockProduct instanceof Accessory) 
		{
			Accessory updatedProduct = new Accessory(stockProduct.getProductId(), stockProduct.getName(), stockProduct.getPrice(), stockProduct.getPurchaseCost(), stockProduct.getStock() + amount, ((Accessory) stockProduct).getAccessoryType().toString(), ((Accessory) stockProduct).getCompatibility());
			stock.remove(stockProduct);
			stock.add(updatedProduct);
			fileHandler.replaceLine("Stock.txt", originalAttributes, updatedProduct.getAttributesAsArray());
		}
		
	}
	
	public Product findById(int productId) 
	{
		for (Product product : stock) 
		{
			if (product.getProductId() == productId) 
			{
				return product;
			}
		}
		return null; // Return null if no product with the given ID is found
	}
	
	public Product findByName(String name) 
	{
		for (Product product : stock) 
		{
			if (product.getName().equalsIgnoreCase(name)) 
			{
				return product;
			}
		}
		return null; // Return null if no product with the given name is found
	}
	
	public List<Accessory> findByCompatibility(String compatibility) 
	{
		List<Accessory> compatibleProducts = new ArrayList<>();
		for (Product product : stock) 
		{
			if (product instanceof Accessory) 
			{
				Accessory accessory = (Accessory) product;
				if (accessory.getCompatibility().equalsIgnoreCase(compatibility)) 
				{
					compatibleProducts.add(accessory);
				}
			}
		}
		return compatibleProducts;
	}
	
	public List<Product> getAllSortedByPrice() 
	{
		//sort the stock by price in descending order and return the sorted list
		List<Product> sortedStock = new ArrayList<>(stock);
		for (int i = 0; i < sortedStock.size() - 1; i++) 
		{
			for (int j = 0; j < sortedStock.size() - i - 1; j++) 
			{
				if (sortedStock.get(j).getPrice() < sortedStock.get(j + 1).getPrice()) 
				{
					//swap the products
					Product temp = sortedStock.get(j);
					sortedStock.set(j, sortedStock.get(j + 1));
					sortedStock.set(j + 1, temp);
				}
			}
		}
		
		
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
		List<Product> stock = new ArrayList<>(this.stock);
		
		if (isAdmin) 
		{
			stock = getAllSortedByPrice();
		}
		
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