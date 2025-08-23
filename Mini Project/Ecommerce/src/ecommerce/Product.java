package ecommerce;

public abstract class Product {
	protected String id, name;
	protected double price;
	protected int stock =10;

	public Product(String id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public abstract void displayDetails();

	public boolean isAvailable(int quantity) {
		return stock >= quantity;
	}

	public void reduceStock(int quantity) {
		if(isAvailable(quantity)) {
			stock -= quantity;
		}
	}

	public void increaseStock(int quantity) {
		stock+= quantity;
	}
	
	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getId() {
		return id;
	}

	public int getStock() {
		return stock;
	}

}