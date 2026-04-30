package bgms.payment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import bgms.user.Address;

public class CreditCardPayment implements PaymentMethod 
{
	Scanner szInput = new Scanner(System.in);

	@Override
	public Receipt processPayment(double total, Address address) {
		
		
		String szCardNumber;
		String szSecurityCode;
		System.out.println("CREDIT CARD PAYMENT METHOD");
		
		//get todays date in the format in DD/MM/YYYY
		String szDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		//Credit card number should be 6 digits and security code should be 3 digits
		while(true) {
			System.out.println("PLEASE ENTER YOUR CREDIT CARD NUMBER (6 DIGITS)");
			szCardNumber = szInput.nextLine();
			System.out.println("PLEASE ENTER YOUR SECURITY CODE (3 DIGITS)");
			szSecurityCode = szInput.nextLine();
			
			if (szCardNumber.length() != 6 || szSecurityCode.length() != 3) {
				System.err.println("INVALID CREDIT CARD NUMBER");
			}
			else {
				break;
			}
		}
		
		
		
		
		String message = String.format("%.2f paid via Credit Card %s on %s. Billing Address: %s.", total, szCardNumber, szDate, address.toString());
		
		return new Receipt(message);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}