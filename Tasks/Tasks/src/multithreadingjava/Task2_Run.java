package multithreadingjava;

//runnable Task 2: Create a Thread by Implementing Runnable 

class RunnabaleCounter implements Runnable{
	RunnabaleCounter(){
		System.out.println("RunnableCounter");
	}	
	@Override
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println(i);

		}
		System.out.println("Done!!!");
	}

}

public class Task2_Run {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RunnabaleCounter rc = new RunnabaleCounter();
		Thread thread = new Thread(rc);
		thread.start();
	}

}
