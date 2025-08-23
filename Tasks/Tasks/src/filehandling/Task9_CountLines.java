package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Task9_CountLines {
	public static void main(String[] args) {
		int lineCount = 0;
		int wordCount = 0;
		int charCount = 0;

		try {
			FileWriter writer = new FileWriter("sample.txt");
			writer.write("Java I/O is powerful!\n");
			writer.write("Learn Java step-by-step.\n");
			writer.write("This file has multiple lines.\n");
			writer.write("Text analytics using file I/O.\n");
			writer.close();
			System.out.println("Successfully written.");

			// Read and analyze content
			BufferedReader br = new BufferedReader(new FileReader("sample.txt"));
			String line;

			while ((line = br.readLine()) != null) {
				lineCount++;
				String[] words = line.trim().split("\\s+");
				wordCount += words.length;

				// Count characters (excluding spaces)
				charCount += line.replace(" ", "").length();
			}
			br.close();

			// Print results
			System.out.println("Lines: " + lineCount);
			System.out.println("Words: " + wordCount);
			System.out.println("Characters (excluding spaces): " + charCount);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
