package bgms.payment;

public class Receipt {
	private String message;
	
	public Receipt(String message) {
		this.message = message;
	}
	
	public void printReceipt() {
		System.out.println(message);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
