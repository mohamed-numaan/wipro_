package oopsjava;

//inheritance

class Vehicle{
	String brand;
	int speed;
	
	void showDetails() {
		System.out.println("Brand:"+brand +" Speed: " +speed );
	}
}

class Car extends Vehicle{
	int wheels =4;
	}

class Bike extends Vehicle{
	int wheels =2;
	}

public class Inheritance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car car = new Car();
		car.brand = "VW";
		car.speed = 180;
		car.showDetails();
		
		Bike bike = new Bike();
		bike.brand = "Hero";
		bike.speed = 100;
		bike.showDetails();
	}

}
