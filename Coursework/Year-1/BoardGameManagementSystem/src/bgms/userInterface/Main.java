package bgms.userInterface;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import bgms.product.StockManager;
import bgms.user.*;
import bgms.FileHandler.*;

public class Main {

    public static void main(String[] args) {

        Scanner consoleInput = new Scanner(System.in);
        StockManager stockManager = new StockManager();
        List<User> users = loadUsers("UserAccounts.txt");
        

        System.out.println("WELCOME");
        
        while (true) {
            printWelcomeMenu(users);

            String line = consoleInput.nextLine().trim();
            int selection = Integer.parseInt(line.trim());
            User selectedUser = null;
            // The selection corresponds to the index of the user in the list (index starts at 1), 
            //so we need to subtract 1 to get the correct index
            if (selection > 0 && selection <= users.size()) 
            {
				selectedUser = users.get(selection - 1);
				if (selectedUser instanceof Admin) 
				{
					selection = 1;
				} else if (selectedUser instanceof Customer) 
				{
					selection = 2;
				}
			} 
            

            switch (selection) {
            	case 0:
            		System.out.println("Goodbye");
            		System.out.println("Closing program...");
            		System.out.println();
            		return;
            		
            	case 1:
            		AdminCLI.run(consoleInput, stockManager, (Admin) selectedUser);
            		break;
            		
            	case 2:
            		CustomerCLI.run(consoleInput, (Customer) selectedUser);
            		break;
            }
        }
    }

    private static void printWelcomeMenu(List<User> users) {

        // Replace placeholders with enumeration of existing users (1..n)
        System.out.println("PLEASE SELECT USER BY INPUTTING THE CORRESPONDING NUMBER (or 0 for exit)");
//        System.out.println("1) userID1 | userName1 | admin");
//        System.out.println("2) userID2 | userName2 | customer");

        int i = 1;
        for(User user : users) {
			System.out.println(i + ") " + user.getUserId() + " | " + user.getName() + " | " + (user instanceof Admin ? "admin" : "customer"));
			i++;
		}
        
        System.out.println("0) Exit");
    }
    
    //Load users from file and put them in an ArrayList<User> users
    private static List<User> loadUsers(String fileName) {
		List<User> users = new ArrayList<>();
		
		FileHandler fileHandler = new FileHandler();
		String[][] userData = fileHandler.readFile(fileName);
		
		for (String[] userRow : userData) {
			int userId = Integer.parseInt(userRow[0]);
			String name = userRow[1];
			String houseNumber = userRow[2];
			String postCode = userRow[3];
			String city = userRow[4];
			String role = userRow[5];
			
			Address address = new Address(houseNumber, postCode, city);
			
			if (role.equalsIgnoreCase("admin")) {
				users.add(new Admin(userId, name, address));
			} else if (role.equalsIgnoreCase("customer")) {
				users.add(new Customer(userId, name, address));
			}
		}
		
		return users;
	}
    

    private static String readLine(Scanner consoleInput) {
        if (!consoleInput.hasNextLine()) {
            return null;
        }
        return consoleInput.nextLine();
    }
}