package exceptionhandlingjava;

public class Task7_SmartDeviceSystem {

	interface Controllable {
		void turnOn();
		void turnOff();
		default void status() {
			System.out.println("Device is operational and can be controlled.");
		}

		//Static
		static void deviceInfo() {
			System.out.println("All smart devices can be controlled remotely.");
		}
	}

	//SmartLight
	static class SmartLight implements Controllable {
		@Override
		public void turnOn() {
			System.out.println("Smart Light turned ON.");
		}

		@Override
		public void turnOff() {
			System.out.println("Smart Light turned OFF.");
		}
	}

	// SmartFan
	static class SmartFan implements Controllable {
		@Override
		public void turnOn() {
			System.out.println("Smart Fan started.");
		}

		@Override
		public void turnOff() {
			System.out.println("Smart Fan stopped.");
		}
	}

	// SmartTv
	static class SmartTV implements Controllable {
		@Override
		public void turnOn() {
			System.out.println("Smart TV turned ON.");
		}

		@Override
		public void turnOff() {
			System.out.println("Smart TV turned OFF.");
		}
	}

	public static void main(String[] args) {
		Controllable.deviceInfo();

		Controllable light = new SmartLight();
		Controllable fan = new SmartFan();
		Controllable tv = new SmartTV();

		light.turnOn();
		light.status();
		light.turnOff();

		fan.turnOn();
		fan.status();
		fan.turnOff();

		tv.turnOn();
		tv.status();
		tv.turnOff();
	}
}
