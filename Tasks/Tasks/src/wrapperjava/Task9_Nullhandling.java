package wrapperjava;

public class Task9_Nullhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Double dobj= null;
		try {
			double d = dobj;
		}
		catch(NullPointerException e) {
			System.out.println("Caught Exception" +e.getMessage());
		}
		
		double safeResult = (dobj!=null) ? dobj: 12.0;
		System.out.println("Default: " +safeResult);
	}

}
