package fundamentalsjava;
// 8.1 
public class Task12_Operators {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int number1 = 20;
		int number2 = 10;
		//Calculations
		int result = number1 + number2;
		System.out.println("Add: " +result);
		result = number1 - number2;
		System.out.println("Sub: " +result);
		result = number1 * number2;
		System.out.println("Mul: " +result);
		result = number1 / number2;
		System.out.println("Divide: " +result);
		
		//Operator
		int number = 2;
		System.out.println(number++); //Post increment
		System.out.println(++number); //Pre-increment 
		
		int num = 20;
		System.out.println(num>>1); //Right shift op
		System.out.println(num<<1); //left shift op
		
		boolean a = true , b = true;
		System.out.println(a & b); //Bitwise
		System.out.println(a && b); // Logical
		
	}

}
