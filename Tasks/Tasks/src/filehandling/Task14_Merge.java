package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Task14_Merge {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileWriter writer1 = new FileWriter("file1.txt");
			writer1.write("Java is programming language \n");
			writer1.write("Learn Java step-by-step.\n");
			writer1.close();

			FileWriter writer2 = new FileWriter("file2.txt");
			writer2.write("Python is programming language \n");
			writer2.write("Learn Python step-by-step.\n");
			writer2.close();

			BufferedReader br1 = new BufferedReader(new FileReader("file1.txt"));
			BufferedReader br2 = new BufferedReader(new FileReader("file2.txt"));
			BufferedWriter mergedWriter = new BufferedWriter(new FileWriter("merged.txt"));

			String line;
			while ((line = br1.readLine()) != null) {
				mergedWriter.write(line);
				mergedWriter.newLine();
			}

			// Read from file2
			while ((line = br2.readLine()) != null) {
				mergedWriter.write(line);
				mergedWriter.newLine();
			}

			// Close all
			br1.close();
			br2.close();
			mergedWriter.close();

			System.out.println("Files merged successfully into merged.txt");

		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
