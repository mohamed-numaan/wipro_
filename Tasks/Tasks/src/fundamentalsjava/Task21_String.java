package fundamentalsjava;
//String 11.1 
public class Task21_String {
	public static void main(String[] args) {
		String str = "Mohamed Numaan";
		int len = str.length();
		String uc = str.toUpperCase();
		String lc = str.toLowerCase();
		String ss = str.substring(5);
		System.out.println("Length of the str is: " +len);
		System.out.println(uc);
		System.out.println(lc);
		System.out.println(str.indexOf('o'));
		
	}
}
