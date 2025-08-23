package exceptionhandlingjava;
//Task 2: Abstract + Non-abstract 
abstract class Animal { 
	abstract void sound(); 
	void displayType() { 
		System.out.println("This is an animal."); 
	} 
}

class Dog extends Animal { 
	void sound() { 
		System.out.println("Dog says: Bark!"); 
	} 
}

public class Task2 { 
	public static void main(String[] args) { 
		Animal a = new Dog(); 
		a.sound(); 
		a.displayType(); 
	} 
} 