package multithreadingjava;


//check thread state whether it is alive or not

public class Task4_Alive extends Thread{
	public void run() {
		try {
			Thread.sleep(300);
		}catch(InterruptedException ex) {
			System.out.println(ex.getMessage());
		}
		System.out.println("Thread execution done: ");
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Task4_Alive tobj1 = new Task4_Alive();
		System.out.println(tobj1.isAlive());
		tobj1.start();
		System.out.println(tobj1.isAlive());
		try {
			tobj1.join();
			System.out.println(tobj1.isAlive());
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
