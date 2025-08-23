package multithreadingjava;
// Shared Counter Without Synchronization
public class Task6_SharedCounter{
	static int counter =0;

	static class CounterThread1 extends Thread{
		public void run() {
			for(int i = 0; i<1000; i++) {
				counter++;
			}
		}
	}
	static class CounterThread2 extends Thread{
		public void run() {
			for(int i = 0; i<1000; i++) {
				counter++;
			}
		}
	}
	public static void main(String[] args) {

		CounterThread1 ct1 = new CounterThread1();
		CounterThread2 ct2 = new CounterThread2();

		ct1.start();
		ct2.start();
		try {
			ct1.join();
			ct2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("Final counter value expected less than 2000 due to race condition: " + counter);
	}
}
