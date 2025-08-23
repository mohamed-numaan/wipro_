package multithreadingjava;

//Chat Simulation 
class ChatSimulation{
	boolean available = false;

	public synchronized void SendMessages(String msg) {
		if(available) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Sender: " +msg);
		available =true;
		notify();
	}
	public synchronized void ReplyMessage(String msg) {
		if(!available) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Receiver: " +msg);
		available =false;
		notify();
	}
}

class Task3 implements Runnable {
	ChatSimulation cs;
	String[] s1 = {"Hi", "How are you?"};

	public Task3(ChatSimulation cs) {
		this.cs = cs;
		new Thread(this, "SendMessages").start();
	}

	public void run() {
		for (int i = 0; i < s1.length; i++) {
			cs.SendMessages(s1[i]);
		}
	}
}

class Task4 implements Runnable {
	ChatSimulation cs;
	String[] s2 = {"Hello!", "I'm fine."};

	public Task4(ChatSimulation cs) {
		this.cs = cs;
		new Thread(this, "ReplyMessage").start();
	}

	public void run() {
		for (int i = 0; i < s2.length; i++) {
			cs.ReplyMessage(s2[i]);
		}
	}
}

public class Task10_ChatSimulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChatSimulation cs = new ChatSimulation();
		new Task3(cs);
		new Task4(cs);


	}

}
