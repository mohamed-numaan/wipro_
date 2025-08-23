package filehandling;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Task12_ReverseText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Input: ");
			String input =br.readLine();
			
			StringBuilder reversed = new StringBuilder(input).reverse();
			
			System.out.println("Reversed: " +reversed);
			
			}catch(Exception e) {
				
			}
	}

}
