package collectionsjava;

import java.util.*;


public class Task6_Map {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashMap<Integer, String> stRollNames = new HashMap<Integer, String>();
		stRollNames.put(21, "Alex");
		stRollNames.put(22, "Baren");
		stRollNames.put(23, "Calvin");
		stRollNames.put(24, "Dany");
		stRollNames.put(25, "Elisa");
		
		stRollNames.remove(21);
		
		Iterator<Map.Entry<Integer,String>> itr = stRollNames.entrySet().iterator();
		
		while(itr.hasNext()) {
			Map.Entry<Integer, String> entry = itr.next();
			System.out.println("Roll no: "+entry.getKey() +" Name: "+ entry.getValue());
		}
	}

}
