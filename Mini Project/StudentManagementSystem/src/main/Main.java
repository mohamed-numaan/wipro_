package main;

import java.util.*;
import java.util.stream.Collectors;

// Base class
class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	//encapsulation
	public String getName() { return name; }
	public int getAge() { return age; }
}
//interface
interface Printable {
	void printDetails();
}
//abstract
abstract class User {
	protected String username;
	protected String password;

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public abstract boolean login(String username, String password);
}
//sub class
class Student extends Person implements Printable {
	private String grade;

	public Student(String name, int age, String grade) {
		super(name, age);
		this.grade = grade;
	}

	public String getGrade() { 
		return grade; 
	}

	@Override
	public void printDetails() {
		System.out.println("Name: " + getName() + ", Age: " + getAge() + ", Grade: " + grade);
	}
}

class Admin extends User {
	public Admin(String username, String password) {
		super(username, password);
	}

	@Override
	public boolean login(String username, String password) {
		return this.username.equals(username) && this.password.equals(password);
	}
}

public class Main {
	private static List<Student> students = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// Create Admin
		Admin admin = new Admin("admin", "1234");
		System.out.println("Login to Student Management System:");
		System.out.print("Enter Username: ");
		String u = sc.nextLine();
		System.out.print("Enter Password: ");
		String p = sc.nextLine();

		if (!admin.login(u, p)) {
			System.out.println("Login Failed!");
			return;
		}
		System.out.println("Login Successful!\n");

		while (true) {
			System.out.println("\n--- Student Management System ---");
			System.out.println("1. Add Student");
			System.out.println("2. Display Students");
			System.out.println("3. Search Students by Grade");
			System.out.println("4. Exit");
			System.out.print("Choose an option: ");
			int choice = sc.nextInt();
			sc.nextLine(); // consume newline

			switch (choice) {
			case 1:
				System.out.print("Enter Name: ");
				String name = sc.nextLine();
				System.out.print("Enter Age: ");
				int age = sc.nextInt();
				sc.nextLine();
				System.out.print("Enter Grade: ");
				String grade = sc.nextLine();
				students.add(new Student(name, age, grade));
				System.out.println("Student Added!");
				break;

			case 2:
				System.out.println("\n--- Student List ---");
				for (Student s : students) {
					s.printDetails();
				}
				break;

			case 3:
				System.out.print("Enter Grade to Search: ");
				String g = sc.nextLine();
				List<Student> filtered = students.stream()
						.filter(s -> s.getGrade().equalsIgnoreCase(g))
						.collect(Collectors.toList());
				if (filtered.isEmpty()) {
					System.out.println("No students found in grade " + g);
				} else {
					System.out.println("Students in grade " + g + ":");
					filtered.forEach(Student::printDetails);
				}
				break;

			case 4:
				System.out.println("Exiting System. Goodbye!");
				return;

			default:
				System.out.println("Invalid Choice!");
			}
		}
	}
}
