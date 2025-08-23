package exceptionhandlingjava;
//multiple catch blocks
public class Task15_CatchBlocks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try { 
			int[] arr = new int[5]; 
			arr[5] = 100 / 0; 
		} catch (ArithmeticException e) { 
			System.out.println("Divide by zero error."); 
		} catch (ArrayIndexOutOfBoundsException e) { 
			System.out.println("Array index error."); 
		} 

	}

}
