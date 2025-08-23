package exceptionhandlingjava;

import java.util.Scanner;

//divide exception

public class Task12_Divide {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Num1: ");
		int a = sc.nextInt();
		System.out.print("Enter Num2: ");
		int b = sc.nextInt();
		try {
			int result = a/b;
			System.out.print("Result: " +result);
		}catch(ArithmeticException e){
			System.out.println("Can't divide by 0");

		}finally {
			sc.close();
		}
	}

}
