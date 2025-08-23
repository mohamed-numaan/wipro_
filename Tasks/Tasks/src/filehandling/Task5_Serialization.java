package filehandling;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



class Student implements Serializable{
	String name;
	String rollno;
	int marks;

	public Student(String name, String rollno, int marks) {
		super();
		this.name = name;
		this.rollno = rollno;
		this.marks = marks;
	}


}

public class Task5_Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Student stud = new Student("Mohamed ","101", 75);

		try {
			FileOutputStream f = new FileOutputStream("student.ser");
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(stud);
			out.close();

			System.out.println("Object serialized and written to student.ser");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		Student tObj1= null;
		try {
			FileInputStream fis = new FileInputStream("student.ser");
			ObjectInputStream in = new ObjectInputStream(fis);
			tObj1 = (Student) in.readObject();
			fis.close();
			in.close();

			System.out.println("Deserialzied Student");
			System.out.println("Name: " +tObj1.name);
			System.out.println("ROll No: " +tObj1.rollno);
			System.out.println("Marks: " +tObj1.marks);
		}
		catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
