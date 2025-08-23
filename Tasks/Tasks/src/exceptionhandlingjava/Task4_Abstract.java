package exceptionhandlingjava;

interface RemoteControl{
	abstract void turnOn();

	default void batteryStatus() {
		System.out.println("Battery level is sufficient");
	}
}
class TV implements RemoteControl{

	public void turnOn() {
		System.out.println("TV is ON.");
	}
}


public class Task4_Abstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TV tv = new TV();
		tv.turnOn();
		tv.batteryStatus();


	}

}
