package collectionsjava;

import java.util.*;
import java.util.stream.*;

public class Task16_StreamAPI {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("John", "Alice", "James", "Bob", "Jill", "Eve");

		// Filter names starting with "J"
		List<String> jNames = names.stream()
			.filter(name -> name.startsWith("J"))
			.collect(Collectors.toList());

		// Print result
		System.out.println("Names starting with J: " + jNames);
	}
}
