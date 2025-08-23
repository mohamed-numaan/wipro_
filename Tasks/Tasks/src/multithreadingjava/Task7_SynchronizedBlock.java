package multithreadingjava;

// Fix the Shared Counter with Synchronized Block
public class Task7_SynchronizedBlock{
	static int counter =0;

	static class CounterThread1 extends Thread{
		public void run() {
			for(int i = 0; i<1000; i++) {
				synchronized (Task7_SynchronizedBlock.class) {
				counter++;	
				}
			}
		}
		
	}
	static class CounterThread2 extends Thread{
		public void run() {
			for(int i = 0; i<1000; i++) {
				synchronized(Task7_SynchronizedBlock.class){
				counter++;}
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

		System.out.println("Final counter should always be: " +  counter);
	}
}
