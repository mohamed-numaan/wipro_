package fundamentalsjava;
//3.2The program that accepts string in command-Line argument
public class Task3_CLA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if(args.length>0) {
			System.out.println("Message: " +args[0]);
		}
		else {
			System.out.println("Please enter your first and last name as command-line argument");
		}
		}

}
