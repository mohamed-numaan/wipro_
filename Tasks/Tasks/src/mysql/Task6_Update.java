package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task6_Update {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
				
			String sql = "UPDATE Students SET email =? WHERE id= ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "newbob@gmail.com");
			pstmt.setInt(2, 2);
			pstmt.executeUpdate();
			System.out.println("Updated");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
