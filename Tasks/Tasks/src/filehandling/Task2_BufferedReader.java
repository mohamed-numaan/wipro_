package filehandling;

//BufferedReader.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task2_BufferedReader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			BufferedReader br = new BufferedReader(new FileReader("info.txt"));
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
