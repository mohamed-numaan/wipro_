package fundamentalsjava;
//5.2
public class Task7_CLIReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 if (args.length < 1) {
	            System.out.println("Please provide a string as a command-line argument.");
	            return;
	        }

		String input = args[0] ;
		String reversed = "";
		//Example hello 
		for(int i = input.length()-1;i>=0;i--) { 
			reversed += input.charAt(i);
		}
		System.out.println("String: " +input);
		System.out.println("Reversed String: " +reversed);
	}

}
