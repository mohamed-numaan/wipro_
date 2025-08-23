package mysql;

import java.sql.*;


public class Task2_CreateTable {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";

		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			System.out.println("✅ Connected to db");
			Statement stmt = conn.createStatement(); 
			String createSQL = "CREATE TABLE Students (id INT PRIMARY KEY, name VARCHAR(15), email VARCHAR(10))"; 
			stmt.executeUpdate(createSQL); 
			System.out.println("Table created successfully."); 
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
