package mysql;

import java.sql.Connection;
import java.sql.DriverManager;

public class Task1_JDBCConnect{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url  ="jdbc:mysql://localhost:3306/wiprodb_two";
		String username = "root";
		String password = "Numaan27";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url,username,password);
			System.out.print("Connected to db");
			conn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
