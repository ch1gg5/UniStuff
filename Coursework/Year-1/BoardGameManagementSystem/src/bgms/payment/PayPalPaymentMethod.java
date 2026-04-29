package bgms.payment;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import bgms.user.Address;

public class PayPalPaymentMethod implements PaymentMethod 
{
	Scanner szInput = new Scanner(System.in);

	@Override
	public Receipt processPayment(double total, Address address) {
		
		
		String szEmail;
		System.out.println("PAYPAL PAYMENT METHOD");
		
		//get todays date in the format in DD/MM/YYYY
		String szDate = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		
		
		//validate email address follows the format of an email address (contains '@' and '.')
		while(true) {
			System.out.println("PLEASE ENTER YOUR PAYPAL EMAIL ADDRESS");
			szEmail = szInput.nextLine();
			
			if (!szEmail.contains("@") || !szEmail.contains(".")) {
				System.out.println("INVALID EMAIL ADDRESS");
			}
			else {
				break;
			}
		}
		
		
		
		String message = String.format("%.2f paid via PayPal using %s on %s. Billing Address: %s.", total, szEmail, szDate, address.toString());
		
		return new Receipt(message);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
