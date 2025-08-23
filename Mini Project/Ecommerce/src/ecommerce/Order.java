package ecommerce;

import java.util.List;

public class Order {
	private Customer customer;
	private List<Product> products;
	private double totalAmount; 
	boolean isCancelled = false;


	public Order(Customer customer,List<Product> products, double totalAmount) {
		this.customer = customer;
		this.products = products;
		this.totalAmount = calculateTotal();
	}

	public double calculateTotal() {
		return products.stream().mapToDouble(Product::getPrice).sum();
	}


	public void placeOrder(Payment payment, Discountable discountable) {

		if(isCancelled) {
			System.out.println("-----");
			return;
		}
		for (Product p : products) {
			if (!p.isAvailable(1)) {
				System.out.println("❌ Product " + p.name + " is out of stock.");
				return;
			}
		}

		// Reduce stock after all checks pass
		for (Product p : products) {
			p.reduceStock(1);
		}
		customer.displayCustomer();
		products.forEach(Product::displayDetails);

		double discounted = discountable.applyDiscount(totalAmount);
		System.out.println("Total after discount: ₹" + discounted);

		payment.amount = discounted;
		payment.processPayment();
	}
	public void cancelOrder() {
		if (isCancelled) {
			System.out.println("⚠️ Order already cancelled.");
			return;
		}

		for (Product p : products) {
			p.increaseStock(1); // Restore stock
		}
		isCancelled = true;
		System.out.println("✅ Order has been cancelled and stock restored.");
	}

	public boolean isCancelled() {
		return isCancelled;
	}
	public void setCancelled(boolean cancelled) {
		isCancelled = cancelled;
	}
	public Customer getCustomer() {
		return customer;
	}

	public List<Product> getProducts() {
		return products;
	}

	public double getTotalAmount() {
		return totalAmount;
	}
}







