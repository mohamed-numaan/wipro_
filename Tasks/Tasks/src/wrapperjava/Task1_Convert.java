package wrapperjava;

public class Task1_Convert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//primitive
		int value_1 = 10; 
		double value_2 = 20; 
		char value_3 = 'J'; 
		
		//convert primitive to wrappers using valueOf
		Integer wrapperInt = Integer.valueOf(value_1);
		Double wrapperDouble = Double.valueOf(value_2);
		Character wrapperCharacter = Character.valueOf(value_3);
		
		//convert wrappers to primitive
		int primitiveInt = wrapperInt.intValue();
		double primitiveDouble = wrapperDouble.doubleValue();
		char primitiveChar = wrapperCharacter.charValue();
		
		//printing all
		System.out.println("Primitive int: " + value_1);
        System.out.println("Wrapper Integer: " + wrapperInt);
        System.out.println("Convert to Primitive int: " + primitiveInt);

        System.out.println("Primitive double: " + value_2);
        System.out.println("Wrapper Double: " + wrapperDouble);
        System.out.println("Convert to Primitive double: " + primitiveDouble);

        System.out.println("Primitive char: " + value_3);
        System.out.println("Wrapper Character: " + wrapperCharacter);
        System.out.println("Convert to Primitive char: " + primitiveChar);
	}

}
