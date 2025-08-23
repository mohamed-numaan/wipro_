package app;

import mode.Student;
import serviceone.StudentService;

public class Main {
	public static void main(String[] args) {
		Student student = new Student(1, "Mohamed Numaan");
		StudentService service = new StudentService();

		service.saveStudent(student);
		service.printStudent();
	}
}
