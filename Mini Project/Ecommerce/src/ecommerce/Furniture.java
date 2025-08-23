package ecommerce;

public class Furniture extends Product{
	public String material;
	public String dimensions;

	public Furniture(String id, String name, double price, String material, String dimensions) {
		super(id, name, price);
		this.material = material;
		this.dimensions = dimensions;
	}

	@Override
	public void displayDetails() {
		System.out.println("Furniture: " + name
				+ " | Material: " + material
				+" | Dimensions: " + dimensions 
				+ " | Price: ₹" + price 
				+ " | ID: " + id 
				+ " | Stock: " + stock);
	}
}

