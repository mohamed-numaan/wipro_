package wrapperjava;

class Box<T> {
	T value;
	void set(T value) {
		this.value = value;
	}

	T get(){
		return value;
	}
}

public class Task5_Generics{
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Box<Integer> intBox = new Box<Integer>();
		Box<Double> doubleBox = new Box<Double>();

		intBox.set(10);
		
		doubleBox.set(10.1214);
		
		System.out.println("Integer value from Box: " +intBox.get());
		System.out.println("Double value from Box: " +doubleBox.get());
	}
}


