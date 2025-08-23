package oopsjava;

//1 creating class

class Book{
	String title;
	String author;
	double price;
	
	Book(String t,String a,double p){
		title = t;
		author =a;
		price = p;
	}
		void displayDetails() {
			System.out.println("Title: " +title);
			System.out.println("Author: " +author);
			System.out.println("Price: " +price);
	}
}

class Book2{
	void displaydetails() {
		System.out.println("Maths Book");
	}
}
public class Books {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book book1 = new Book("Wings of fire","A.P.J Abdul kalam ",300.0);
		Book book2 = new Book("Think and grow rich","Napolean Hill",165.0);
		
		book1.displayDetails();
		book2.displayDetails();

	}

}
