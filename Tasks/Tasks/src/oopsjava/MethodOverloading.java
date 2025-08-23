package oopsjava;

//Method overloading

class Calculator {
	int add(int a, int b) {
		return a+b;
	}
	double add(double a, double b) {
		return a+b;
	}
	String add(String a,String b) {
		return a +" "+ b;
	}
}

public class MethodOverloading {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Calculator c = new Calculator();
		
		
		
		System.out.println("Int add: "+c.add(10, 20));
		System.out.println("Double add: "+c.add(12.1, 12.0));
		System.out.println("String add: "+c.add("Robert", "Downey"));
	}

}
