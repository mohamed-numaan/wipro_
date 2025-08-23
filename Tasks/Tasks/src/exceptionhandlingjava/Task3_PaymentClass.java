package exceptionhandlingjava;

public class Task3_PaymentClass {

	//abstract
	static abstract class PaymentMethod {
		abstract void pay(double amount);
	}

	static class CreditCard extends PaymentMethod {
		@Override
		void pay(double amount) {
			System.out.println("Paid " + amount + " using Credit Card.");
		}
	}
	static class UPI extends PaymentMethod {
		@Override
		void pay(double amount) {
			System.out.println("Paid " + amount + " using UPI.");
		}
	}
	static class Cash extends PaymentMethod {
		@Override
		void pay(double amount) {
			System.out.println("Paid " + amount + " using Cash.");
		}
	}

	// Main method
	public static void main(String[] args) {
		PaymentMethod p1 = new CreditCard();
		PaymentMethod p2 = new UPI();
		PaymentMethod p3 = new Cash();

		p1.pay(1000);
		p2.pay(500);
		p3.pay(200);
	}
}
