package exceptionhandlingjava;


interface Printable{
	void print();
}
interface Scannable{
	void scan();
}

class MultifunctionPrinter implements Printable,Scannable{
	public void print() {
		System.out.println("Printing the document...");
	}

	public void scan() {
		System.out.println("Scanning the document...");
	}
}

public class Task6_MultipleInterfaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultifunctionPrinter mfp = new MultifunctionPrinter();
		mfp.print();
		mfp.scan();


	}

}
