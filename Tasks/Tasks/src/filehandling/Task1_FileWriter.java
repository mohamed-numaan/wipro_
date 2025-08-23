package filehandling;

//Objective: Learn how to create and write to a file using FileWriter.

import java.io.FileWriter;
import java.io.IOException;

public class Task1_FileWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
			FileWriter writer = new FileWriter("info.txt");
			writer.write("Java I/O is powerful!");
			writer.append("Learn Java step-by-step");
			writer.close();
			System.out.println("Successfully wriiten");
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
