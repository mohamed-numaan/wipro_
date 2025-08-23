package exceptionhandlingjava;
//exception for less than 18 
public class Task14_Age{
	static void validateAge(int age) throws Exception { 
		if (age < 18) 
			throw new Exception("You must be 18+ to vote"); 
		else 
			System.out.println("You can vote!");
	}
	public static void main(String[] args) { 
		try { 
			validateAge(16); 
		} catch (Exception e) { 
			System.out.println(e.getMessage()); 
		} 
	} 
} 