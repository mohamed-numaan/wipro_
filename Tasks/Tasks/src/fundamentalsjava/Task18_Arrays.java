package fundamentalsjava;

import java.util.Scanner;
//10.1 prints average,minimum and maximum of 10 integer.
public class Task18_Arrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[10]; 
		Scanner sc = new Scanner(System.in); 
		
		int sum = 0; 
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE; 
		
		
		
		for (int i = 0; i < arr.length; i++) { 
			arr[i] = sc.nextInt(); 
			sum += arr[i]; 
			if (arr[i] < min)
			min = arr[i]; 
			if (arr[i] > max) 
			max = arr[i]; 
			} 
		System.out.println("Average: " + (sum/10.0)); 
		System.out.println("Min: " + min + ", Max: " + max);	
	}

}
