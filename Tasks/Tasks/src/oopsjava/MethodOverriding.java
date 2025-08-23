package oopsjava;

//method overriding

class Animal{
	void sound() {
		System.out.println("Animal Sound");
	}
}

class Dog extends Animal{
	void sound() {
		System.out.println("Dog barks!!!");
	}
}

class Cat extends Animal{
	void sound() {
		System.out.println("Cat meow!!!");
	}
}

class Cow extends Animal{
	void sound() {
		System.out.println("Cow moo!!!");
	}
}
public class MethodOverriding {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal a1 = new Dog();
		Animal a2 = new Cat();
		Animal a3 = new Cow();
		a1.sound();
		a2.sound();
		a3.sound();

	}

}
