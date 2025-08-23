package mysql;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Task9_Stored {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			CallableStatement cs = conn.prepareCall("{call getStudentById(?)}"); 
			cs.setInt(1, 2); 
			ResultSet rs = cs.executeQuery(); 
			while (rs.next()) { 
				System.out.println("Name: " + rs.getString("name") + ", Email: " + 
						rs.getString("email")); 
			}
			conn.close();
		}catch(SQLException e) {
			e.getStackTrace();
		}

	}

}
