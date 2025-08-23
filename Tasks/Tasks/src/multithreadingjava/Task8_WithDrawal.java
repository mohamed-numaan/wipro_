package multithreadingjava;
// Bank Account Withdrawal Simulation 
class BankAccount {
	private double balance = 15000.15;
	synchronized void withdraw(double amount, String user) {
		if(balance>=amount) {
			System.out.println(user +"is withdrawing: " +amount);
			balance -= amount;
			System.out.println("Remaining Balance: " +balance);
		}else {
			System.out.println("Insufficient balance!!!");
		}
	}
}
public class Task8_WithDrawal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount ba = new BankAccount();

		Runnable userA = () -> ba.withdraw(16000, "User-A ");
		Runnable userb = () -> ba.withdraw(14999.15, "User-b ");

		new Thread(userA).start();
		new Thread(userb).start();

	}

}
