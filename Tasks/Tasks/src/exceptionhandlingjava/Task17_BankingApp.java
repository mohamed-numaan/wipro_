package exceptionhandlingjava;

class MinimumBalanceException extends Exception {
	public MinimumBalanceException(String message) {
		super(message);
	}
}

class BankAccount {
	private String accountNumber;
	private double balance;
	private static final double MIN_BALANCE = 1000.0;

	public BankAccount(String accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public void deposit(double amount) {
		balance += amount;
		System.out.println("Deposited ₹" + amount + ". Current Balance: ₹" + balance);
	}

	public void withdraw(double amount) throws MinimumBalanceException {
		if (balance - amount < MIN_BALANCE) {
			throw new MinimumBalanceException(
					"Withdrawal denied! Minimum balance of ₹" + MIN_BALANCE + " must be maintained."
					);
		}
		balance -= amount;
		System.out.println("Withdrew ₹" + amount + ". Current Balance: ₹" + balance);
	}

	public double getBalance() {
		return balance;
	}
}

public class Task17_BankingApp {
	public static void main(String[] args) {
		BankAccount account = new BankAccount("A12345", 5000);

		System.out.println("Initial Balance: ₹" + account.getBalance());

		account.deposit(2000);

		try {
			account.withdraw(5500); 
			account.withdraw(700);  //throw exception
		} catch (MinimumBalanceException e) {
			System.out.println("Exception: " + e.getMessage());
		}

		System.out.println("Final Balance: ₹" + account.getBalance());
	}
}
