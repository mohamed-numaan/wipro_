package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class Task5_PreparedStmt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement(); 
			String sql = "INSERT INTO Students (id, name, email) VALUES (?, ?, ?)"; 
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setInt(1, 3); 
			pstmt.setString(2, "Charlie"); 
			pstmt.setString(3, "charlie@example.com");
			pstmt.executeUpdate();
			System.out.println("Inserted using prepared statwment");
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
