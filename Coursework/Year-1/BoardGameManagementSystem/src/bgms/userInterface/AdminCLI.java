package bgms.userInterface;
import java.util.Scanner;
import bgms.product.*;
import bgms.user.Admin;

public class AdminCLI {
	public final static String NOT_IMPLEMENTED = "Not implemented";
	public final static String INVALID = "Invalid input";
	public final static String[] PARAMETER_NAMES = {"product ID (Must be an Integer)", "category (board game or accessory)", 
			"type (strategy or party if board game) (Accessory Kit, Miniature or Dice if accessory)", 
			"name", "price", "stock quantity", "purchase cost", "Max players (if board game) or compatibility (if accessory)"};
	
	
	private static void addProduct(Scanner consoleInput, StockManager stockManager, Admin admin) {
		//The order of the input should follow the order appearing in the Stock.txt file
		//read data one entry at a time.
		int i = 0;
		String[] szAttributes = new String[PARAMETER_NAMES.length];
		for (String parameterName : PARAMETER_NAMES) {
			System.out.println("input " + parameterName);
			szAttributes[i] = consoleInput.nextLine();
			i++;
		}
		
		int productId = Integer.parseInt(szAttributes[0]);
		String category = szAttributes[1];
		String type = szAttributes[2];
		String name = szAttributes[3];
		
		
		//check if product id exists and if it is 4 digits
		if(stockManager.findById(productId) != null) 
		{
			System.err.println("Invalid input: Product ID already exists in stock");
			return;
		} 
		else if (productId < 1000 || productId > 9999) 
		{
			System.err.println("Invalid input: Product ID must be a 4-digit integer");
			return;
		}
		
		try {
			int quantity = Integer.parseInt(szAttributes[5]);
			double price = Double.parseDouble(szAttributes[4]);
			double purchaseCost = Double.parseDouble(szAttributes[6]);
			
			if (category.equalsIgnoreCase("board game")) 
			{
				int maxPlayers = Integer.parseInt(szAttributes[7]);
				if (!type.equalsIgnoreCase("Strategy") && !type.equalsIgnoreCase("Party")) 
				{
					System.err.println("Invalid input: Type must be either Strategy or Party for board games");
				} else 
				{
					//valid input, create a new board game and add it to the stock manager
					BoardGame newBoardGame = new BoardGame(productId, name, price, purchaseCost, quantity, type, maxPlayers);
					admin.addProductToStock(newBoardGame, stockManager);
					System.out.println("Board game added successfully: " + newBoardGame.getName());
				}
			} else if (category.equalsIgnoreCase("accessory")) 
			{
				String compatibility = szAttributes[7];
				if (!type.equalsIgnoreCase("Kit") && !type.equalsIgnoreCase("Miniature") && !type.equalsIgnoreCase("Dice")) 
				{
					System.err.println("Invalid input: Type must be either Kit, Miniature or Dice for accessories");
				} else 
				{
					//valid input, create a new accessory and add it to the stock manager
					Accessory newAccessory = new Accessory(productId, name, price, purchaseCost, quantity, type, compatibility);
					admin.addProductToStock(newAccessory, stockManager);
					System.out.println("Accessory added successfully: " + newAccessory.getName());
				}
			} else 
			{
				System.err.println("Invalid category: " + category);
			}
		} catch (NumberFormatException e) {
			System.err.println("Invalid input: " + e.getMessage());
		}
		
	
		
	}

    public static void run(Scanner consoleInput, StockManager stockManager, Admin admin) {
    	System.out.println("ADMIN VIEW");

        
        while (true) {
        	printAdminMenu();
        	
        	//throw exception if the input is not an integer
        	int selection;
        	try {
        		selection = Integer.parseInt(consoleInput.nextLine().trim());
			} catch (NumberFormatException e) {
				System.err.println(INVALID);
				System.out.println();
				continue;
        	}
        	
        	switch (selection) {
        		case 1:
        			stockManager.displayStock(true);
        			System.out.println();
        			break;
        		
        		case 2:
        			//The order of the input should follow the order appearing in the Stock.txt file
        			//read data one entry at a time.
        			
        			addProduct(consoleInput, stockManager, admin);
        			System.out.println();
        			break;
        			
        		case 0:
        			return;
        			
        		default:
        			System.err.println("Invalid Number. Please try again.");
        			System.out.println();
        	}
        }
    }
    
    
    private static void printAdminMenu() {

        System.out.println("PLEASE SELECT ACTION BY INPUTTING THE CORRESPONDING NUMBER (or 0 for logout)");
        System.out.println("1) View all products");
        System.out.println("2) Add new product");
        

        System.out.println("0) Log out");
    }
    
    
    
}