package filehandling;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Task11_FileNotFound {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("service.txt");
			System.out.println("Success");
		}catch(FileNotFoundException e) {
			System.out.println("File not found. Please check the file name.");
		}
	}
}
