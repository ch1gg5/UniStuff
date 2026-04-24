package bgms.userInterface;
import java.util.Scanner;
import bgms.user.Customer;
import bgms.product.StockManager;

public class CustomerCLI {

    public static void run(Scanner consoleInput, StockManager stockManager, Customer customer) {

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