package collectionsjava;

import java.util.*;
import java.util.stream.*;

public class Task17_Square {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

		// Square each number and collect to new list
		List<Integer> squared = numbers.stream()
			.map(n -> n * n)
			.collect(Collectors.toList());

		System.out.println("Squared numbers: " + squared);
	}
}
