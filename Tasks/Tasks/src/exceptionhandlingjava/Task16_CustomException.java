package exceptionhandlingjava;

//checking balance 

class InvalidAccountException extends Exception { 
	InvalidAccountException(String msg) { 
		super(msg); 
	} 
} 

public class Task16_CustomException { 
	static void checkBalance(int balance) throws InvalidAccountException { 
		if (balance < 0) 
			throw new InvalidAccountException("Negative balance not allowed!"); 
		else  
			System.out.println("Valid balance: " + balance);
	}
	public static void main(String[] args) { 
		try { 
			checkBalance(-100); 
		} catch (InvalidAccountException e) { 
			System.out.println(e.getMessage()); 
		} 
	} 
} 
