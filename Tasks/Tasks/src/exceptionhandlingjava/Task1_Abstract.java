package exceptionhandlingjava;

abstract class Shape {
	// Abstract method
	abstract void area();
}

class Circle extends Shape {
	double radius;

	// Constructor
	Circle(double radius) {
		this.radius = radius;
	}
	void area() {
		double result = Math.PI * radius * radius;
		System.out.println("Area of Circle: " + result);
	}
}

class Rectangle extends Shape {
	double length, breadth;

	// Constructor
	Rectangle(double length, double breadth) {
		this.length = length;
		this.breadth = breadth;
	}

	void area() {
		double result = length * breadth;
		System.out.println("Area of Rectangle: " + result);
	}
}

public class Task1_Abstract {
	public static void main(String[] args) {
		Shape circle = new Circle(5.0);
		circle.area();

		Shape rectangle = new Rectangle(4.0, 6.0);
		rectangle.area();
	}
}
