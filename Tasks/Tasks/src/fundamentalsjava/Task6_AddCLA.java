package fundamentalsjava;
//5.1Passing values in arguments 10+20;
public class Task6_AddCLA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num1 = Integer.parseInt(args[0]);
		
		int num2 = Integer.parseInt(args[1]);
		
		int sum = num1 + num2;
		System.out.println("Sum:" +sum);

	}

}
