package bgms.userInterface;
import java.util.Scanner;
import bgms.product.*;
import bgms.user.Admin;

public class AdminCLI {
	public final static String NOT_IMPLEMENTED = "Not implemented";
	public final static String INVALID = "Invalid input";
	public final static String[] PARAMETER_NAMES = {"product ID", "category (board game or accessory)", 
			"type (strategy or party if board game) (Accessory Kit, Miniature or Dice if accessory)", 
			"name", "price", "stock quantity", "purchase cost", "Max players (if board game) or compatibility (if accessory)"};
	
	
	private static String addProduct(Scanner consoleInput, StockManager stockManager, Admin admin) {
		//The order of the input should follow the order appearing in the Stock.txt file
		//read data one entry at a time.
		int i = 0;
		String[] szAttributes = new String[PARAMETER_NAMES.length];
		for (String parameterName : PARAMETER_NAMES) {
			System.out.println("input " + parameterName);
			szAttributes[i] = consoleInput.nextLine();
			i++;
		}
		
		if (szAttributes[1].equalsIgnoreCase("board game")) 
		{
			//validate the input for board game
			try {
				Integer.parseInt(szAttributes[5]);
				Double.parseDouble(szAttributes[4]);
				Double.parseDouble(szAttributes[6]);
				Integer.parseInt(szAttributes[7]);
				if (!szAttributes[2].equalsIgnoreCase("Strategy") && !szAttributes[2].equalsIgnoreCase("Party")) 
				{
					return "Invalid game type: " + szAttributes[2];
				} else 
				{
					//valid input, create a new board game and add it to the stock manager
					BoardGame newBoardGame = new BoardGame(szAttributes[0], szAttributes[3], Double.parseDouble(szAttributes[4]), Double.parseDouble(szAttributes[6]), 
							Integer.parseInt(szAttributes[5]), szAttributes[2], Integer.parseInt(szAttributes[7]));
					admin.addProductToStock(newBoardGame, stockManager);
					

					return "Board game added successfully";
				}
			} catch (NumberFormatException e) 
			{
				return "Invalid input: " + e.getMessage();
			}
		} else if (szAttributes[1].equalsIgnoreCase("accessory")) 
		{
			//validate the input for accessory
			try {
				Integer.parseInt(szAttributes[5]);
				Double.parseDouble(szAttributes[4]);
				Double.parseDouble(szAttributes[6]);
			} catch (NumberFormatException e) {
				return "Invalid input: " + e.getMessage();
			}
		} 
		
		
		return "Invalid category: " + szAttributes[1];
		
	}

    public static void run(Scanner consoleInput, StockManager stockManager, Admin admin) {
    	System.out.println("ADMIN VIEW");

        
        while (true) {
        	printAdminMenu();
        	
        	int selection = Integer.parseInt(consoleInput.nextLine().trim());
        	
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
        			System.out.println(INVALID);
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