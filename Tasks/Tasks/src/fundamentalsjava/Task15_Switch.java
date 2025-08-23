package fundamentalsjava;

import java.util.Scanner;

//Calculation 9.2

public class Task15_Switch {
	public static void  main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a,b,res;
		String c;
		System.out.println("Enter the value of a: ");
		a = sc.nextInt();
		System.out.println("Enter the value of b: ");
		b = sc.nextInt();
		System.out.println("Select the operator +-*/: ");
		c = sc.next();
		
		switch (c) {
		case "+":
			res = a+b;
			System.out.println("Sum of a and b: " +res);
			break;
		case "-":
			res = a-b;
			System.out.println("Substraction of a and b: " +res);
			break;
		case "*":
			res = a*b;
			System.out.println("Multiply of a and b: " +res);
			break;
		case "/":
			if(b==0) {
				System.out.println("Can't divide by zero");
			}else {
				res = a/b;
				System.out.println("Divide: " +res);
			}
			break;
		default:
			System.out.println("Invalid operator!");
			break;
		}
	}
}
