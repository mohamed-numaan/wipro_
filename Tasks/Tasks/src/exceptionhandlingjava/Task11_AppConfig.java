package exceptionhandlingjava;

public class Task11_AppConfig {
	static final String APP_NAME = "SmartBank";
	static final String VERSION = "1.0.0";
	static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bankdb";
	static final int MAX_USERS = 1000;
	static final boolean DEBUG_MODE = true;


	public static void main(String[] args) {
		System.out.println("Application: " + Task11_AppConfig.APP_NAME);
		System.out.println("Version: " + Task11_AppConfig.VERSION);
		System.out.println("Database: " + Task11_AppConfig.DATABASE_URL);
		System.out.println("Max Users: " + Task11_AppConfig.MAX_USERS);
		if (Task11_AppConfig.DEBUG_MODE) {
			System.out.println("Debugging is enabled.");
		} else {
			System.out.println("Debugging is disabled.");
		}
	}

}