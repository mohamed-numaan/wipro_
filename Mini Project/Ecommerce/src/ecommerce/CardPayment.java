package ecommerce;

public class CardPayment extends Payment{
	
	private String cardNumber;
	
	public CardPayment(double amount,String cardNumber) {
		super(amount);
		this.cardNumber = cardNumber;
	}
	@Override
	void processPayment() {
		System.out.println("Paid ₹: " +amount
				+" using the Card no " +cardNumber.substring(cardNumber.length()-4));
	}

}
