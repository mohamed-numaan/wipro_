package collectionsjava;

import java.util.*;

public class Task11_Comparable {
	static class Student implements Comparable<Student> {
		String name;
		int marks;

		Student(String name, int marks) {
			this.name = name;
			this.marks = marks;
		}

		public int compareTo(Student other) {
			return this.marks - other.marks;
		}

		public String toString() {
			return name + " - " + marks;
		}
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<>();

		students.add(new Student("Alice", 85));
		students.add(new Student("Bob", 70));
		students.add(new Student("Charlie", 90));
		students.add(new Student("David", 60));

		System.out.println("Before Sorting:");
		for (Student s : students) {
			System.out.println(s);
		}

		Collections.sort(students);
		System.out.println("\nAfter Sorting (by marks ascending):");

		for (Student s : students) {
			System.out.println(s);
		}
	}
}
