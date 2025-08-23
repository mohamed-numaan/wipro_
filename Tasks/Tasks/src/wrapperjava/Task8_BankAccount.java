package wrapperjava;

class BankAccount{
	String accountNumber = "IOB0000001"; //for example
	Double balance =0.0 ;

	public BankAccount() {
		if(balance == null) {
			balance =0.0;
		}
	}

	void withdraw(Double amount) {
		if (balance == null) 
			balance = 0.0;
		if(amount<balance) {
			balance -= amount;
			System.out.println("Withdrawn: "+amount 
					+" Remaining Balance is: "+balance);
		}
		else {
			System.out.println("insufficinet amount");
		}
	}
	void deposit(double amount) {
		if (balance == null)
			balance = 0.0;
		balance+= amount;
		System.out.println("Deposited: " +balance);
	}

	void showBalance() {
		System.out.println("Account: " + accountNumber + ", Balance: " + balance);

	}
}

public class Task8_BankAccount {
	public static void main(String[] args) {

		BankAccount ba = new BankAccount();
		ba.showBalance();
		ba.deposit(5000.0);
		ba.withdraw(2000.0);
		ba.showBalance();
	}
}
