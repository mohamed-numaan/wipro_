package collectionsjava;

import java.util.*;

class Employee {
	String name;
	String department;

	Employee(String name, String department) {
		this.name = name;
		this.department = department;
	}

	@Override
	public String toString() {
		return name;
	}
}

public class Task13_employee {
	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(
				new Employee("Alice", "HR"),
				new Employee("Bob", "IT"),
				new Employee("Charlie", "HR"),
				new Employee("David", "Finance"),
				new Employee("Eve", "IT"),
				new Employee("Frank", "Finance")
				);

		Map<String, List<Employee>> departmentMap = new HashMap<>();

		for (Employee emp : employees) {
			departmentMap
			.computeIfAbsent(emp.department, k -> new ArrayList<>())
			.add(emp);
		}


		for (Map.Entry<String, List<Employee>> entry : departmentMap.entrySet()) {
			System.out.println("Department: " + entry.getKey());
			for (Employee emp : entry.getValue()) {
				System.out.println("  - " + emp);
			}
		}
	}
}
