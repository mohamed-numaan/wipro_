package multithreadingjava;

//Thread  Create a Thread by Extending the Thread Class

public class Task1_Create extends Thread {

	public void run() {
		for(int i =1;i<=5;i++) {
			System.out.println("Hello from Thread!");
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Done!!!");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Task1_Create myThread = new Task1_Create();
		myThread.start();


	}

}
