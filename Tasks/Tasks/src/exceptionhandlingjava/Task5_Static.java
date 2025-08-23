package exceptionhandlingjava;

interface Info { 
	static void showDetails() { 
		System.out.println("Static method in Interface"); 
	} 
} 
public class Task5_Static { 
	public static void main(String[] args) { 
		Info.showDetails(); 
	} 
} 