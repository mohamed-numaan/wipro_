package fundamentalsjava;
import java.util.Scanner;
//7.2
public class Task13_LogicalOpearotr {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter two numbers:");
		int a = sc.nextInt();
		int b = sc.nextInt();

		//Arithmetic 
		System.out.println("Addition: " + (a + b));
		System.out.println("Subtraction: " + (a - b));
		System.out.println("Multiplication: " + (a * b));
		System.out.println("Division: " + (a / b));
		System.out.println("Modulus: " + (a % b));

		// Assignment
		int x = a;  
		System.out.println("\nAssignment Operations with x = " + x);

		x += b;
		System.out.println("x += b : " + x);

		x -= b;
		System.out.println("x -= b : " + x);

		x *= b; 
		System.out.println("x *= b : " + x);

		x /= b; 
		System.out.println("x /= b : " + x);

		x %= b;
		System.out.println("x %= b : " + x);

		sc.close();
	}
}
