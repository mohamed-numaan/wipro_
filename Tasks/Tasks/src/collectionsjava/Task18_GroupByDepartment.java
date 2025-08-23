package collectionsjava;

import java.util.*;
import java.util.stream.Collectors;

class Employees {
	String name;
	String department;

	Employees(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	
	public String toString() {
		return name;
	}
}

public class Task18_GroupByDepartment {
	public static void main(String[] args) {
		List<Employees> employees = Arrays.asList(
				new Employees("Alice", "HR"),
				new Employees("Bob", "IT"),
				new Employees("Charlie", "HR"),
				new Employees("David", "Finance"),
				new Employees("Eve", "IT")
				);

		Map<String, List<Employees>> grouped = employees.stream()
				.collect(Collectors.groupingBy(e -> e.department));

		// Print grouped employees
		grouped.forEach((dept, list) -> {
			System.out.println(dept + ": " + list);
		});
	}
}
