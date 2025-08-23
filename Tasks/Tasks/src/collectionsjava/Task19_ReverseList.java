package collectionsjava;

import java.util.*;

public class Task19_ReverseList {
	public static void main(String[] args) {
		List<String> languages = new ArrayList<>(Arrays.asList("Java", "Python", "C++", "JavaScript"));
		
		System.out.println("Original: " + languages);
		Collections.reverse(languages);
		System.out.println("Reversed: " + languages);
	}
}
