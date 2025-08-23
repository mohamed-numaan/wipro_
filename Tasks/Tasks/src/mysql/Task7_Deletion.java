package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task7_Deletion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
				String sql = "DELETE FROM Students WHERE id =?";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1,1);
				pstmt.executeUpdate();
				conn.close();
				System.out.println("Deleted");
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
