package multithreadingjava;

// Thread Race Simulation
public class Task11 extends Thread {

	public Task11(String msg) {
		super(msg);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=1;i<=5;i++) {
			System.out.println(getName() + " running: " +i);
			try {
				Thread.sleep((int) (Math.random() *1000));
			}catch(Exception e) {
				e.printStackTrace();

			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Task11("Tortoise").start();
		new Task11("Rabbit").start();
		new Task11("Dog").start();


	}

}
