package fundamentalsjava;
//StringBuffer mutable 112
public class Task22_StringBuffer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer("Java is ");
		sb.append(" and programming language ");
		sb.insert(8, "Independent");
		sb.delete(0, 8); //deletes java is a 
		System.out.println(sb);
		

	}

}
