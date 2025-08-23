package multithreadingjava;
// Thread Priority Demo
public class Task5_Priority extends Thread {

    public void run() {
        System.out.println("Thread: " + getName() + ", Priority: " + getPriority());
    }

    public static void main(String[] args) {
        Task5_Priority t1 = new Task5_Priority();
        Task5_Priority t2 = new Task5_Priority();
        Task5_Priority t3 = new Task5_Priority();

        t1.setName("T1");
        t2.setName("T2");
        t3.setName("T3");

        t1.setPriority(Thread.MIN_PRIORITY);   // 1
        t2.setPriority(Thread.NORM_PRIORITY);  // 5
        t3.setPriority(Thread.MAX_PRIORITY);   // 10

        try {
            t1.start();
            t1.join(); 

            t2.start();
            t2.join();  
            
            t3.start();
            t3.join();  
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
