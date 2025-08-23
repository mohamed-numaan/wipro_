package oopsjava;

//encapsulation 

class BankAccount {
	//Fields
	private long a ;
	private double balance;
	
	//setter and getter
	void setbalance(double balance) {
	this.balance = balance;
	}
	double getbalance() {
		return this.balance;
	}
		
	//methods
public void deposit(double amount) {
		if(amount>0) {
			balance += amount;
			System.out.println("Deposited: " +amount);
		}else {
			System.out.println("Invalid deposit amount.");
		}
		

	}
public void withdraw(double amount) {
		if(amount >0 && amount<= balance) {
			balance -= amount;
			System.out.println("Withdrawn: " +amount);
		}else {
			System.out.println("Invalid or insufficient balance.");
		}
		
		
	}
	void getBalance() {
		System.out.println("Current Balance: " + balance);
	}

}
public class Encapsulation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BankAccount acc = new BankAccount();
		acc.setbalance(5000.00);
		acc.deposit(2500);
		acc.withdraw(250);
		acc.getBalance();
		
		
		
	}

}
