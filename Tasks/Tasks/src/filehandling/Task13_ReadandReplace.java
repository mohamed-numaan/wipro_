package filehandling;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Task13_ReadandReplace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			FileWriter writer = new FileWriter("data.txt");
			writer.write("Java is programming language \n");
			writer.write("Learn Java step-by-step.\n");
			writer.write("Java has built.in functions.\n");
			writer.write("By Java we can consume programming knowledge.\n");
			writer.close();

			BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
			StringBuilder modifiedcontent = new StringBuilder();
			String line;

			while((line=reader.readLine())!=null) {
				String replacedLine = line.replaceAll("\\bJava\\b", "Python");
				modifiedcontent.append(replacedLine).append("/n");
			}
			reader.close();
			BufferedWriter writer2 = new BufferedWriter(new FileWriter("data.txt"));
			writer2.write(modifiedcontent.toString());
			writer2.close();

			System.out.println("Word 'Java' has been successfully replaced with 'Python'.");

		}catch(Exception e) {
			e.getStackTrace();
		}
	}

}
