package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Task4_Retrieve {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery("SELECT * FROM Students");
			while(rs.next()) {
				System.out.println("id: "+rs.getInt("id") 
						+ " Name: " + rs.getString("name") 
						+ " Email: " +rs.getString("email"));
			}
			
			conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
