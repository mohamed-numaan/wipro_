package collectionsjava;

import java.util.*;

public class Task20_FrequencyCount {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("Java", "C", "Java", "Python", "Java", "C++");

		int count = Collections.frequency(list, "Java");
		System.out.println("Frequency of 'Java': " + count);
	}
}
