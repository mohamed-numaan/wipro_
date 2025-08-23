package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Task6_Input {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name, email, address;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.print("Enter your Name: ");
			name = br.readLine();

			System.out.print("Enter your EmailId: ");
			email = br.readLine();

			System.out.print("Enter your address: ");
			address = br.readLine();

			BufferedWriter bw = new BufferedWriter(new FileWriter("userdata.txt"));
			bw.write("Name: "+name);
			bw.newLine();
			bw.write("Email:" +email);
			bw.newLine();
			bw.write("Address: "+address);
			bw.newLine();
			bw.close();
		}catch(Exception e) {
			System.out.println("Error while saving data"+e.getMessage());
		}
		System.out.println("Your data saved successfully!!!");
	}

}
