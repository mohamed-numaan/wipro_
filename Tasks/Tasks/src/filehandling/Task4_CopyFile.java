package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task4_CopyFile {
	public static void main(String[] args) {
		String sourceFile = "info.txt";
		String destinationFile = "copy.txt";

		try (
			BufferedReader reader = new BufferedReader(new FileReader(sourceFile));
			BufferedWriter writer = new BufferedWriter(new FileWriter(destinationFile))
		) {
			String line;
			while ((line = reader.readLine()) != null) {
				writer.write(line);
				writer.newLine(); 
				writer.close();// to maintain original line breaks
			}
			System.out.println("Content copied from info.txt to copy.txt successfully.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
