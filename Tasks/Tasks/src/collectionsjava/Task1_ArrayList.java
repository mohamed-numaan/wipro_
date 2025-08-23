package collectionsjava;
import java.util.*;
//Create an ArrayList of Strings, add 5 elements, remove the 2nd element, and print all elements. 
public class Task1_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> language = new ArrayList<String>();
		language.add("Java");
		language.add("C");
		language.add("C++");
		language.add("Ruby");
		language.add("Python");
		
		language.remove(1);
		System.out.println(language);
	}

}
