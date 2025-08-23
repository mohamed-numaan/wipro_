package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Task3_InsertData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement(); 
			stmt.executeUpdate("INSERT INTO Students VALUES(1,'Alice','alice@gmail.com')");
			stmt.executeUpdate("INSERT INTO Students VALUES(2,'Bob marley','bob@gmail.com')");
			System.out.println("Data inseretd successfully.");
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
