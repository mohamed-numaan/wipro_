package fundamentalsjava;
//9.1 checks among three integer which is larger
public class Task14_ThreeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a =10;
		int b=20;
		int c=30;
		
		if(a>b && a>c) {
			System.out.println("a is largest");
		}
		else if(b>a && b>c) {
			System.out.println("B is largest");
		}
		else {
			System.out.println("C is largest");
		}
	}

}
