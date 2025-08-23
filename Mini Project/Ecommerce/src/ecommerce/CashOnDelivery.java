package ecommerce;

public class CashOnDelivery extends Payment {
	double amount;

	public CashOnDelivery(double amount) {
		super(amount);

	}
	@Override
	public void processPayment() {
		System.out.println("Payment of ₹" + amount
				+ " will be collected on delivery.");
	}
}
