package collectionsjava;

import java.util.*;

public class Task8_SortKeys {
	public static void main(String[] args) {
		// Step 1: Create and populate an unsorted HashMap
		HashMap<Integer, String> studentMap = new HashMap<>();
		studentMap.put(105, "Ravi");
		studentMap.put(102, "Anjali");
		studentMap.put(108, "Karan");
		studentMap.put(101, "Sneha");
		studentMap.put(103, "Vikram");

		System.out.println("Unsorted HashMap:");
		for (Map.Entry<Integer, String> entry : studentMap.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}

		TreeMap<Integer, String> sortedMap = new TreeMap<>(studentMap);

		// Print the sorted TreeMap
		System.out.println("\nSorted TreeMap (by keys):");
		for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " => " + entry.getValue());
		}
	}
}
