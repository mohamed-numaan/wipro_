package multithreadingjava;


// Countdown Timer using Threads 
public class Task12_Timer extends Thread{

	public void run() {
		// TODO Auto-generated method stub
		for(int i=10;i>=1;i--) {
			System.out.println("Countdown: " +i);
			try {
				Thread.sleep(1000); //delay 1 second
			}catch(Exception e) {
				e.getStackTrace();
			}
		}
		System.out.println("Time's up!");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Task12_Timer().start();

	}

}
