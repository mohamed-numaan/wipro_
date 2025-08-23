package fundamentalsjava;
//9.4
import java.util.Scanner;

public class Task17_Do {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in); 
		int n; 
		do { 
		System.out.println("Enter positive number (-1 to stop): "); //-1 to stop
		n = sc.nextInt(); 
		} while (n != -1); 

	}

}
