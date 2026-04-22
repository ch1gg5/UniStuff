package bgms.userInterface;
import java.util.Scanner;
import bgms.product.StockManager;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        StockManager stockManager = new StockManager();

        System.out.println("WELCOME");
        
        while (true) {
            printWelcomeMenu();

            String line = consoleInput.nextLine().trim();

            int selection = Integer.parseInt(line.trim());

            switch (selection) {
            	case 0:
            		System.out.println("Goodbye");
            		System.out.println("Closing program...");
            		System.out.println();
            		return;
            		
            	case 1:
            		AdminCLI.run(consoleInput, stockManager);
            		break;
            		
            	case 2:
            		CustomerCLI.run(consoleInput);
            		break;
            }
        }
    }

    private static void printWelcomeMenu() {

        // Replace placeholders with enumeration of existing users (1..n)
        System.out.println("PLEASE SELECT USER BY INPUTTING THE CORRESPONDING NUMBER (or 0 for exit)");
        System.out.println("1) userID1 | userName1 | admin");
        System.out.println("2) userID2 | userName2 | customer");

        System.out.println("0) Exit");
    }

    private static String readLine(Scanner consoleInput) {
        if (!consoleInput.hasNextLine()) {
            return null;
        }
        return consoleInput.nextLine();
    }
}