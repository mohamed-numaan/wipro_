package oopsjava;

//interface logger

interface Logger{
	default void logInfo() {
		System.out.println("Default Info log");
	}
	static void logError(){
		System.out.println("Static error log");
	}
}

class AppLogger implements Logger{}

public class InterfaceEnhancements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AppLogger logger = new AppLogger();
		logger.logInfo();
		Logger.logError();
		
	}

}
