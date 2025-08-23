package collectionsjava;

import java.util.ArrayList;
import java.util.Iterator;

public class Task9_Iterator {
	public static void main(String[] args) {
		
		ArrayList<String> ar = new ArrayList<String>();
		ar.add("Alex");
		ar.add("Bob");
		ar.add("Alan");
		ar.add("Merin");
		
		Iterator<String> itr = ar.iterator();
		while(itr.hasNext()) {
			String name = itr.next();
			if(name.startsWith("A")) {
				itr.remove();
			}
		}
		System.out.println(ar);
		
	}
}
