package ecommerce;

public class Electronics extends Product {
	private String brand;
	private int warrantyInMonths;

	public Electronics(String id, String name, double price, String brand, int warrantyInMonths) {
		super(id, name, price);
		this.brand = brand;
		this.warrantyInMonths = warrantyInMonths;

	}
	@Override
	public void displayDetails() {
		System.out.println("Electronics: " + name
				+ " | Brand: " + brand
				+" | Warranty: " + warrantyInMonths 
				+ " months | Price: ₹" + price 
				+ " | ID: " + id
				+" | Stock: " + stock);
	}

}
