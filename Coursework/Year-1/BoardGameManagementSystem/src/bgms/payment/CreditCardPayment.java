package bgms.payment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import bgms.user.Address;

public class CreditCardPayment implements PaymentMethod {

	@Override
	public Receipt processPayment(double total, Address address) {
		
		Scanner szInput = new Scanner(System.in);
		String szCardNumber;
		String szSecurityCode;
		System.out.println("CREDIT CARD PAYMENT METHOD");
		
		//get todays date in the format in DD/MM/YYYY
		String szDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		//Credit card number should be 6 digits and security code should be 3 digits
		while(true) {
			System.out.println("PLEASE ENTER YOUR CREDIT CARD NUMBER");
			szCardNumber = szInput.nextLine();
			System.out.println("PLEASE ENTER YOUR SECURITY CODE");
			szSecurityCode = szInput.nextLine();
			
			if (szCardNumber.length() != 6 || szSecurityCode.length() != 3) {
				System.out.println("INVALID CREDIT CARD NUMBER");
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
