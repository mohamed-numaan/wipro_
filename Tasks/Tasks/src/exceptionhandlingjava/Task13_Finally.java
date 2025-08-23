package exceptionhandlingjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//reading the file
public class Task13_Finally {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader("data.txt"));
		}catch(IOException e) {
			System.out.println("Error reading file");
		}finally {
			try {
				if(reader != null)
					reader.close();
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				reader.close();
			}
			System.out.println("File closed");
		}
	}
}
