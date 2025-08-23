package oopsjava;

interface Calculate{
	int operation(int a,int b);
};

public class Lambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate add = (x,y) -> x+y;
		Calculate sub = (x,y) -> x-y;
		Calculate mul = (x,y) -> x*y;
		Calculate div = (x,y) -> x/y;
		
		
		System.out.println(add.operation(10,20));
		System.out.println(sub.operation(40,20));
		System.out.println(mul.operation(4,20));
		System.out.println(div.operation(50,20));

	}

}
