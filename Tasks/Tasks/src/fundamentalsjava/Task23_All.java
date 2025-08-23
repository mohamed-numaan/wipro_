package fundamentalsjava;
//11.3 printing the time taken for string, stringbuffer and stringbuilder.
public class Task23_All {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long start, end; 
		start = System.currentTimeMillis(); 
		
		String s = ""; 
		for (int i = 0; i < 100000; i++)
			s += "a"; 
		end = System.currentTimeMillis();
		System.out.println("String: " + (end - start));
		
		start = System.currentTimeMillis(); 
		StringBuffer sb = new StringBuffer(); 
		for (int i = 0; i < 100000; i++) 
			sb.append("a"); 
		end = System.currentTimeMillis(); 
		System.out.println("StringBuffer: " + (end - start)); 
		
		start = System.currentTimeMillis(); 
		StringBuilder sbld = new StringBuilder(); 
		for (int i = 0; i < 100000; i++) 
			sbld.append("a"); 
		end = System.currentTimeMillis(); 
		System.out.println("StringBuilder: " + (end - start));

	}

}
