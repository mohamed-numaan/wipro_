package collectionsjava;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class Task5_TreeSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeSet<Integer> num = new TreeSet<Integer>(Arrays.asList(14,78,45,98,15));
		Set<Integer> descSet = num.descendingSet();
		
		System.out.println("Ascending: "+num);
		System.out.println("Descending: "+descSet);

	}

}
