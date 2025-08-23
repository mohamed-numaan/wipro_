package wrapperjava;

public class Task4_Compare {

    public static void main(String[] args) {

        // Autoboxing
    	int a = 100;
        Integer num1 = a; // Autoboxing

        // Using new keyword (creates a new object)
        Integer num2 = new Integer(100);

        // using ==
        if (num1 == num2) {
            System.out.println("num1 == num2: true");
        } else {
            System.out.println("num1 == num2: false");
        }
        //returns false object reference memory

        // using .equals()
        if (num1.equals(num2)) {
            System.out.println("num1.equals(num2): true");
        } else {
            System.out.println("num1.equals(num2): false");
        }
        //return true checks value
    }
}
