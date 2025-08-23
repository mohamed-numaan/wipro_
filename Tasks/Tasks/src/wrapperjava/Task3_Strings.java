package wrapperjava;


//parsing from strings

public class Task3_Strings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String i = "123";
		String d= "45.67";
		String bool = "true";

		int in = Integer.parseInt(i);
		double dou = Double.parseDouble(d);
		boolean b = Boolean.parseBoolean(bool);

		System.out.println("Converted Strings to primitive ");
		System.out.println("int:" +in);
		System.out.println("double: "+dou);
		System.out.println("boolean: " +b);
	}

}
