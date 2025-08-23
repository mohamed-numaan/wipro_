package multithreadingjava;

//printing first 5 numbers by delay of 1 second  Thread with Sleep and Join.

class Thread1 extends Thread {
	public void run() {
		for(int i =1;i<=5;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);

			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
public class Task3_SleepJoin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread1 t = new Thread1();
		t.start();
		try {
			t.join();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("Main thread done. ");

	}

}
