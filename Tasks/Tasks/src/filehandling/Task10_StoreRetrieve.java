package filehandling;

import java.io.*;
import java.util.ArrayList;

class Student1 implements Serializable {
	String name;
	String rollno;
	int marks;

	public Student1(String name, String rollno, int marks) {
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}
}

public class Task10_StoreRetrieve {
	public static void main(String[] args) {

		// Creating list of students
		ArrayList<Student1> al = new ArrayList<Student1>();
		al.add(new Student1("Alen", "101", 100));
		al.add(new Student1("Banu", "102", 100));
		al.add(new Student1("Calvin", "103", 100));
		al.add(new Student1("Dravid", "104", 100));
		al.add(new Student1("Fazil", "105", 100));

		// Serializing the list
		try {
			FileOutputStream f = new FileOutputStream("student.ser");
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(al);
			out.close();
			System.out.println("Object serialized and written to student.ser");
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Deserializing the list and printing details
		ArrayList<Student1> deserializedList = null;
		try {
			FileInputStream fis = new FileInputStream("student.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			deserializedList = (ArrayList<Student1>) in.readObject();
			fis.close();
			in.close();

			System.out.println("\nDeserialized Student List:");
			for (Student1 s : deserializedList) {
				System.out.println("Name: " + s.name);
				System.out.println("Roll No: " + s.rollno);
				System.out.println("Marks: " + s.marks);
				System.out.println("-------------------------");
			}

		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
