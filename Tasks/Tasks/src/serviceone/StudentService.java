package serviceone;

import mode.Student;

public class StudentService {
	private Student student;

	public void saveStudent(Student student) {
		this.student = student;
		System.out.println("Student saved successfully!");
	}

	public void printStudent() {
		if (student != null) {
			System.out.println("Student ID: " + student.getId());
			System.out.println("Student Name: " + student.getName());
		} else {
			System.out.println("No student found!");
		}
	}
}
