package multithreadingjava;
//ITC  Producer-Consumer (1 Item Buffer) 
class Buffer{
	private int data;
	private boolean b = false;
	
	synchronized void Producer(int value) {
		while(b) {
			try {
				wait();
			}catch(InterruptedException e) {
				System.out.println("InterruptedExeption");
			}
		}
		data = value;
		System.out.println(data);
		b= true;
		notify();
	} 
	synchronized void Consume() {
		while(!b) {
			try {
				wait();
			}catch(InterruptedException e) {
				System.out.println("InterruptedExeption");
			}
		}
		System.out.println(data);
		b= false;
		notify();
	} 
	
}
public class Task9_Producer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Buffer b = new Buffer();
		
		 Thread producer = new Thread(() -> {
	            for(int i = 1; i <= 5; i++){
	            	b.Producer(i);} 
	        }); 
	 
	        Thread consumer = new Thread(() -> { 
	            for(int i = 1; i <= 5; i++) { 
	            	b.Consume(); 
	            }
	        }); 
	 
	        producer.start(); consumer.start();
	}

}
