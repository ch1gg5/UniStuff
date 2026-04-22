package bgms.user;

public class Customer extends User 
{
	private ShoppingBasket shoppingBasket;
	
	public Customer(int userId, String name, Address address) {
		super(userId, name, address);
		this.shoppingBasket = new ShoppingBasket();
	}
	
	public ShoppingBasket getShoppingBasket() {
		return shoppingBasket;
	}

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

	}

}
