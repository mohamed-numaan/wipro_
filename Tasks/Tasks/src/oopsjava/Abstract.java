package oopsjava;

//abstract

abstract class Shape{
	//abstract method
	abstract double area(); 
}

class Circle extends Shape{
	double radius;
	Circle(double r){
		radius = r;
	}
	double area() {
		return 3.14*(radius*radius);
	}
	}

class Rectangle extends Shape{
	double length,width;
	Rectangle(double l, double w){
		length =l;
		width =w;
	}		
		double area() {
			return length*width;
		}
	}

public class Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Shape s1 = new Circle(2);
		Shape s2 = new Rectangle(4,5);
	
		System.out.println("Area of a circle: " +s1.area());
		System.out.println("Area of a Rectangle: "+s2.area());
	}

}
