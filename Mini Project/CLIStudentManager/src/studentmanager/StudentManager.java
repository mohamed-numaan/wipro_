package studentmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentManager {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/testdb";
		String username = "root";
		String password = "Numaan27";
		try (Connection conn = DriverManager.getConnection(url, username, password)) {
			Scanner sc = new Scanner(System.in);
			int choice;

			do {
				System.out.println("1. Add\n2. View\n3. Update\n4. Delete\n5. Exit"); 
				choice = sc.nextInt(); 
				sc.nextLine(); 

				switch(choice) {
				case 1:
					System.out.println("Id: ");
					int id = sc.nextInt();
					System.out.println("Name: ");
					String name = sc.nextLine();
					System.out.println("Email: ");
					String email = sc.nextLine();
					PreparedStatement ps = conn.prepareStatement("INSERT INTO Students VALUES (?, ?, ?)"); 
					ps.setInt(1, id); ps.setString(2, name); ps.setString(3, email); 
					ps.executeUpdate(); 
					break; 

				case 2: 
					ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM Students"); 
					while (rs.next()) { 
						System.out.println(rs.getInt("id") + " - " + 
								rs.getString("name") + " - " + rs.getString("email")); 
					} 
					break; 

				case 3: 
					System.out.print("Enter ID to update: "); int uid = 
					sc.nextInt(); 
					sc.nextLine(); 
					System.out.print("New Email: "); String newEmail = 
							sc.nextLine(); 
					PreparedStatement ups = conn.prepareStatement("UPDATE Students SET email=? WHERE id=?"); 
					ups.setString(1, newEmail); ups.setInt(2, uid); 
					ups.executeUpdate(); 
					break; 

				case 4: 
					System.out.print("Enter ID to delete: "); int did = 
					sc.nextInt(); 
					PreparedStatement dps = conn.prepareStatement("DELETE FROM Students WHERE id=?"); 
					dps.setInt(1, did); dps.executeUpdate(); 
					break; 
				case 5: 
					System.out.println("Exiting..."); 
					break; 

				}

			}while(choice !=5);

			conn.close();

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
