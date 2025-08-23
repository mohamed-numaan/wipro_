package oopsjava;

import java.util.Arrays;
import java.util.List;

//sorting from ascending to descending and check the name the start with a char.

public class Lambda_Collections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = Arrays.asList("Alice", "Bob", "Evans", "Chris", 
				"Amit");
		names.forEach(name -> System.out.println("Name: " + name));
		System.out.println("\nNames starting with A:");
		names.stream().filter(n -> n.startsWith("A")) .forEach(System.out::println); 
		System.out.println("\nSorted Names:"); 
		names.stream().sorted()
		.forEach(System.out::println);

	}

}
