package ecommerce;

public class Books extends Product {
	private String author,genre;

	public Books(String id,String name, String dummy,
			double price, String bookName, String author,String genre)
	{
		super(id, name,price);
		this.author =author;
		this.genre= genre;
	}
	@Override
	public void displayDetails() {
		 System.out.println("Book: " + name
				 + " | Author: " + author 
				 + " | Genre: " + genre
				 + " | Price: ₹" + price
				 + " | ID: " + id 
				 + " | Stock: " + stock);
		 }
}
