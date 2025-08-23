package oopsjava;

//abstract and interface

abstract class Appliance{
	abstract void turnOn();
}
interface Connectable {
	void connect();
}

class SmartTV extends Appliance implements Connectable {
	void turnOn() {
		System.out.println("SmartTv is ON");
	}
	
	public void connect() {
		System.out.println("Connected to Wifi");
	}
	
}
public class AbstarctclassInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SmartTV tv = new SmartTV();
		tv.turnOn();
		tv.connect();

	}

}
