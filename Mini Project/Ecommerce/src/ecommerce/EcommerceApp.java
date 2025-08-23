package ecommerce;

import java.util.*;

public class EcommerceApp {
	public static void main(String[] args) {
		if (args.length > 0 && args[0].equalsIgnoreCase("reset")) {
			StockFileManager.resetStock();
			return; // exit after reset
		}
		Scanner sc = new Scanner(System.in);

		Map<String, Integer> stockMap = StockFileManager.loadStock();
		// Customer input
		System.out.print("Enter Customer Name: ");
		String name = sc.nextLine();

		System.out.print("Enter Customer Email: ");
		String email = sc.nextLine();

		Customer customer = new Customer(name, email);

		// Product selection
		List<Product> selectedProducts = new ArrayList<>();

		System.out.println("\n📦 Available Products (Stock: Max 10):");
		System.out.println("1. iPhone 15");
		System.out.println("2. Polo T-shirt");
		System.out.println("3. Rich Dad Poor Dad (Book)");
		System.out.println("4. Wooden Chair");

		System.out.print("How many products do you want to buy? ");
		int count = sc.nextInt();
		sc.nextLine(); // Consume newline

		for (int i = 0; i < count; i++) {
			System.out.print("Enter product number (1-4): ");
			int option = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (option) {
			case 1:
				if (stockMap.get("P1001") > 0) {
					selectedProducts.add(new Electronics("P1001", "iPhone 15", 79999.0, "Apple", stockMap.get("P1001")));
					stockMap.put("P1001", stockMap.get("P1001") - 1);
				} else {
					System.out.println("❌ iPhone is out of stock.");
				}
				break;
			case 2:
				if (stockMap.get("C1002") > 0) {
					selectedProducts.add(new Clothing("C1002", "Polo T-shirt", 1499.0, "L", "Cotton"));
					stockMap.put("C1002", stockMap.get("C1002") - 1);
				} else {
					System.out.println("❌ T-shirt is out of stock.");
				}
				break;
			case 3:
				if (stockMap.get("B1003") > 0) { 
					selectedProducts.add(new Books("B1003", "Rich Dad Poor Dad", null, 399, "Robert Kiyosaki", "Finance", "Parenting"));
					stockMap.put("B1003", stockMap.get("B1003") - 1);
				} else {
					System.out.println("❌ Book is out of stock.");
				}
				break;
			case 4:
				if (stockMap.get("F1004") > 0) {
					selectedProducts.add(new Furniture("F1004", "Wooden Chair", 2499, "Wood", "40x40x90 cm"));
					stockMap.put("F1004", stockMap.get("F1004") - 1);
				} else {
					System.out.println("❌ Furniture is out of stock.");
				}
				break;
			default:
				System.out.println("Invalid choice. Skipping.");
			}

		}

		// Create order
		double totalAmount = selectedProducts.stream().mapToDouble(Product::getPrice).sum();
		Order order = new Order(customer, selectedProducts, totalAmount);

		// Discount via lambda
		Discountable discount = (price) -> price * 0.9; // 10% off

		// Payment method input
		System.out.println("\n💳 Choose Payment Method:");
		System.out.println("1. UPI");
		System.out.println("2. Card");
		System.out.println("3. Cash On Delivery");

		System.out.print("Option: ");
		int paymentChoice = sc.nextInt();
		sc.nextLine(); // consume newline

		Payment payment = null;
		switch (paymentChoice) {
		case 1:
			System.out.print("Enter UPI ID: ");
			String upi = sc.nextLine();
			payment = new UPIPayment(0, upi);
			break;
		case 2:
			System.out.print("Enter Card Number: ");
			String card = sc.nextLine();
			payment = new CardPayment(0, card);
			break;
		case 3:
			payment = new CashOnDelivery(0);
			break;
		default:
			System.out.println("Invalid choice. Defaulting to COD.");
			payment = new CashOnDelivery(0);
		}

		// Place order
		order.placeOrder(payment, discount);

		// Save to file
		FileManager.saveOrder(order);

		// After placing and saving the order
		// Save updated stock to file after successful order
		StockFileManager.saveStock(stockMap);

		// Show updated stock for all products
		System.out.println("\n📦 Remaining Stock After Order:");
		Map<String, Integer> updatedStockMap = StockFileManager.loadStock();
		System.out.println("iPhone 15: " + updatedStockMap.get("P1001"));
		System.out.println("Polo T-shirt: " + updatedStockMap.get("C1002"));
		System.out.println("Rich Dad Poor Dad (Book): " + updatedStockMap.get("B1003"));
		System.out.println("Wooden Chair: " + updatedStockMap.get("F1004"));



		// Ask for cancellation
		System.out.print("\nDo you want to cancel your order? (yes/no): ");
		String cancel = sc.nextLine().trim().toLowerCase();

		if (cancel.equals("yes")) {
			FileManager.cancelOrderByEmail(email);
		} else {
			System.out.println("✅ Order confirmed and saved.");
		}
		sc.close();
	}
}

