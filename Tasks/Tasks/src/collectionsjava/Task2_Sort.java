package collectionsjava;

import java.util.*;

public class Task2_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Integer> numbers = Arrays.asList(7,27,21,11);
		
		Collections.sort(numbers);
		System.out.println("Ascending order: " +numbers);
		
		Collections.sort(numbers,Collections.reverseOrder());
		System.out.println("Descending order: " +numbers);
		

}
}