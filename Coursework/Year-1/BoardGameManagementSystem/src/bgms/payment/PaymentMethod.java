package bgms.payment;

import bgms.user.Address;

public interface PaymentMethod {
	
	Receipt processPayment(double total, Address address);

}
