package ecommerce;

public class UPIPayment extends Payment {
	private String upiId;

	public UPIPayment(double amount,String upiId) {
		super(amount);
		this.upiId = upiId;
	}

	@Override
	void processPayment() {
		System.out.println("Paid ₹" +amount
				+"via UPI: " +upiId);

	}

}
