package bgms.userInterface;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import bgms.user.Customer;
import bgms.product.*;
import bgms.payment.*;

public class CustomerCLI 
{
	
	private static String cancelShoppingBasket(Customer customer, StockManager stockManager) 
	{
		//return the items in the shopping basket back to the stock manager
		for (Map.Entry<Product, Integer> entry : customer.getShoppingBasket().getItems().entrySet()) {
			Product product = entry.getKey();
			int quantity = entry.getValue();
			stockManager.increaseProductStock(product, quantity);
		}
		
		customer.getShoppingBasket().clearBasket();
		return "Shopping basket cancelled and items returned to stock.";
	}
	
	private static String addProductToBasket(Scanner consoleInput, StockManager stockManager, Customer customer)
	{
		Product product = null;
		//ask if its adding by product ID or by name
		System.out.println("Add to basket by: 1) Product ID or 2) Product name");
		int selection = Integer.parseInt(consoleInput.nextLine().trim());
		switch (selection) 
		{
			case 1:
				System.out.println("Input product ID:");
				String productId = consoleInput.nextLine().trim();
				product = stockManager.findById(productId);
				
				//throw error if the product ID is invalid 
				try 
				{
					
					product = stockManager.findById(productId);
					
					if (product == null) 
					{
						throw new IllegalArgumentException("Product ID not found: " + productId);
					}
					
					//now ask for the quantity and validate that input as well
					System.out.println("Input quantity:");
					int quantity = Integer.parseInt(consoleInput.nextLine().trim());
					
					if (quantity <= 0) 
					{
						throw new IllegalArgumentException("Quantity must be a positive integer");
					} else if (quantity > product.getStock()) 
					{
						throw new IllegalArgumentException("Quantity exceeds available stock. Available stock: " + product.getStock());
					} else 
					{
						//valid input, add the product to the shopping basket with the specified quantity
						customer.getShoppingBasket().addItem(product, quantity);
						//decrease the stock of the product in the stock manager
						stockManager.increaseProductStock(product, -quantity);
						return "Product added to basket: " + product.getName() + " (Quantity: " + quantity + ")";
					}
					
				} catch (IllegalArgumentException e) {
					//print the exception message
					System.out.println("Error: " + e.getMessage());
					
					return null;
				}
		case 2:
				System.out.println("Input product name:");
				String productName = consoleInput.nextLine().trim();
				product = stockManager.findByName(productName);
				
				//throw error if the product name is invalid 
				try 
				{
					product = stockManager.findByName(productName);
					
					if (product == null) 
					{
						throw new IllegalArgumentException("Product name not found: " + productName);
					}
					
					//now ask for the quantity and validate that input as well
					System.out.println("Input quantity:");
					int quantity = Integer.parseInt(consoleInput.nextLine().trim());
					
					if (quantity <= 0) 
					{
						throw new IllegalArgumentException("Quantity must be a positive integer");
					} else if (quantity > product.getStock()) 
					{
						throw new IllegalArgumentException("Quantity exceeds available stock. Available stock: " + product.getStock());
					} else 
					{
						//valid input, add the product to the shopping basket with the specified quantity
						customer.getShoppingBasket().addItem(product, quantity);
						//decrease the stock of the product in the stock manager
						stockManager.increaseProductStock(product, -quantity);
						return "Product added to basket: " + product.getName() + " (Quantity: " + quantity + ")";
					}
					
				} catch (IllegalArgumentException e) {
					return null;
				}
				
		default:
				return "Invalid selection";
		}
	}
	
	private static void viewShoppingBasket(Customer customer)
	{
		customer.getShoppingBasket().printBasketContents();
		return;
	}
	
	private static String lookupProductById(Scanner consoleInput, StockManager stockManager)
	{
		System.out.println("Input product ID:");
		String productId = consoleInput.nextLine().trim();
		Product productById = stockManager.findById(productId);
		if (productById != null) 
		{	
			return productById.toString(false);
			
		} else 
		{
			return "Product ID not found: " + productId;
		}
	}
	
	private static String purchaseItemsInBasket(Scanner consoleInput, Customer customer)
	{
		viewShoppingBasket(customer);
		double totalPrice = customer.getShoppingBasket().getTotalPrice();
		Receipt receipt;
		
		System.out.println("Would you like to proceed with the purchase? (yes/no)");
		String szInput = consoleInput.nextLine().trim();
		if (szInput.equalsIgnoreCase("yes"))
		{
			System.out.println("Paypal or Credit Card? (paypal/credit)");
			szInput = consoleInput.nextLine().trim();
			
			//use the payment package
			if (szInput.equalsIgnoreCase("paypal"))
			{
				PayPalPaymentMethod paypalPayment = new PayPalPaymentMethod();
				receipt = paypalPayment.processPayment(totalPrice, customer.getAddress());
				receipt.printReceipt();
				customer.getShoppingBasket().clearBasket();
				return "Success";
				
			} else if (szInput.equalsIgnoreCase("credit"))
			{
				//same for credit card payment
				CreditCardPayment creditCardPayment = new CreditCardPayment();
				receipt = creditCardPayment.processPayment(totalPrice, customer.getAddress());
				receipt.printReceipt();
				customer.getShoppingBasket().clearBasket();
				return "Success";
				
			} else 
			{
				return "Invalid payment method selected. Purchase cancelled.";
			}
			
		} else 
		{
			return "Purchase cancelled.";
		}
	}
	
	private static void filterByCompatibility(Scanner consoleInput, StockManager stockManager)
	{
		System.out.println("Input compatibility to search for:");
		String compatibility = consoleInput.nextLine().trim();
		List<Accessory> compatibleProducts = stockManager.findByCompatibility(compatibility);
		if (compatibleProducts.isEmpty()) 
		{
			System.out.println("No products found with that compatibility.");
		} else 
		{
			for (Accessory accessory : compatibleProducts) 
			{
				System.out.println(accessory.toString(false));
			}
		}
	}

    public static void run(Scanner consoleInput, StockManager stockManager, Customer customer) 
    {

        System.out.println("CUSTOMER VIEW");
        
        while (true) 
        {
	        printCustomerMenu(customer);
	        int selection = Integer.parseInt(consoleInput.nextLine().trim());
	        
	        switch (selection) 
	        {
				case 1:
					stockManager.displayStock(false);
					System.out.println();
					break;
				case 2:
					String result = addProductToBasket(consoleInput, stockManager, customer);
					
					if (result != null)
					{	
						System.out.println(result);
					} else 
					{
						System.out.println("Failed to add product to basket. Please check your input and try again.");
					}
					System.out.println();
					break;
				case 3:
					viewShoppingBasket(customer);
					System.out.println();
					break;
				case 4:
					purchaseItemsInBasket(consoleInput, customer);
					System.out.println();
					break;
				case 5:
					System.out.println(cancelShoppingBasket(customer, stockManager));
					System.out.println();
					break;
				case 6:
					System.out.println(lookupProductById(consoleInput, stockManager));
					System.out.println();
					
					break;
				case 7:
					filterByCompatibility(consoleInput, stockManager);
					System.out.println();
					break;
				case 0:
					//before logging out, clear the shopping basket and return the items to stock
					cancelShoppingBasket(customer, stockManager);
					System.out.println("Logging out...");
					System.out.println();
					return;
					
				default:
					//invalid input
	        }
	        
        
        }
        
        
    }
    
    private static void printCustomerMenu(Customer customer) {
    	System.out.println("Account: " + customer.getUserId() + " | " + customer.getName());
        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add product to shopping basket");
        System.out.println("3) View contents of shopping basket");
        System.out.println("4) Purchase items in the basket");
        System.out.println("5) Cancel shopping basket");
        System.out.println("6) Lookup with product ID");
        System.out.println("7) Search/filter based on compatilbility");

        System.out.println("0) Log out");
    }
}