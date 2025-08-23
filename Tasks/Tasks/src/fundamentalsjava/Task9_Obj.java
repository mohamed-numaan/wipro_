package fundamentalsjava;
//6.2
public class Task9_Obj {
	@Override
	protected void finalize() {
		System.out.println("Large object collected!");
	}

	public static void main(String[] args) {

		for (int i = 1; i <= 5; i++) {
			
			byte[] largeObj = new byte[10 * 1024 * 1024]; 
			System.out.println("Created large object " + i);
			largeObj = null; 
		}

		System.gc(); 
		System.out.println("Requested garbage collection");
	}
}
