package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3_Count {
	public static void main(String[] args) {
		int wordCount =0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("info.txt"));
			String line;
			
			while((line = br.readLine()) != null) {
				String[] words = line.split("\\s+");
				wordCount += words.length;
			}
			System.out.println("Total words:" +wordCount);
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
