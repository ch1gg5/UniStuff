package bgms.userInterface;
import java.util.Scanner;
import bgms.product.*;
import bgms.user.Admin;

public class AdminCLI {
	public final static String NOT_IMPLEMENTED = "Not implemented";
	public final static String INVALID = "Invalid input";
	public final static String[] PARAMETER_NAMES = {"product ID", "category", "type", "name", "price", "stock quantity", "purchase cost", "Max players (if board game) or compatibility (if accessory)"};
	
	
	//keep this commented UNTIL YOU ARE ABLE TO PASS ADMIN THROUGH IT
//	private static String addProduct(Scanner consoleInput, Admin admin) {
//		//The order of the input should follow the order appearing in the Stock.txt file
//		//read data one entry at a time.
//		int i = 0;
//		String[] szAttributes = new String[PARAMETER_NAMES.length];
//		for (String parameterName : PARAMETER_NAMES) {
//			System.out.println("input " + parameterName);
//			szAttributes[i] = consoleInput.nextLine();
//			i++;
//		}
//		
//		if (szAttributes[1].equalsIgnoreCase("board game")) {
//			//validate the input for board game
//			try {
//				Integer.parseInt(szAttributes[5]);
//				Double.parseDouble(szAttributes[4]);
//				Double.parseDouble(szAttributes[6]);
//				Integer.parseInt(szAttributes[7]);
//				if (!szAttributes[2].equalsIgnoreCase("Strategy") && !szAttributes[2].equalsIgnoreCase("Party")) {
//					return "Invalid game type: " + szAttributes[2];
//				} else {
//					//valid input, create a new board game and add it to the stock manager
//					BoardGame newBoardGame = new BoardGame(szAttributes[0], szAttributes[3], Double.parseDouble(szAttributes[4]), Double.parseDouble(szAttributes[6]), Integer.parseInt(szAttributes[5]), szAttributes[2], Integer.parseInt(szAttributes[7]));
//					admin.addProduct(newBoardGame);
//					
//
//					return NOT_IMPLEMENTED;
//				}
//			} catch (NumberFormatException e) {
//				return "Invalid input: " + e.getMessage();
//			}
//		} else if (szAttributes[1].equalsIgnoreCase("accessory")) {
//			//validate the input for accessory
//			try {
//				Integer.parseInt(szAttributes[5]);
//				Double.parseDouble(szAttributes[4]);
//				Double.parseDouble(szAttributes[6]);
//			} catch (NumberFormatException e) {
//				return "Invalid input: " + e.getMessage();
//			}
//		} else {
//			return "Invalid category: " + szAttributes[1];
//		}
//		
//		return NOT_IMPLEMENTED;
//	}

    public static void run(Scanner consoleInput, StockManager stockManager) {
    	System.out.println("ADMIN VIEW");
        //Admin admin = new Admin();

        
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
        			for (int i=1;i<9;i++) {
        				System.out.println("input parameter" + i);
        				consoleInput.nextLine();
        				
        			}
        			System.out.println(NOT_IMPLEMENTED);
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