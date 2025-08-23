package collectionsjava;

import java.util.*;

class Stud {
	String id;
	String name;

	Stud(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + " - " + name;
	}
}

public class Task14_ListToMapExample {
	public static void main(String[] args) {
		
		List<Stud> students = Arrays.asList(
			new Stud("S101", "Alice"),
			new Stud("S102", "Bob"),
			new Stud("S103", "Charlie")
		);

		
		Map<String, Stud> studentMap = new HashMap<>();
		for (Stud s : students) {
			studentMap.put(s.id, s);
		}

		// Print the map
		for (Map.Entry<String, Stud> entry : studentMap.entrySet()) {
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
	}
}
