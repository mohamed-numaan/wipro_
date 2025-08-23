package collectionsjava;

import java.util.ArrayList;
import java.util.ListIterator;

public class Task10_ListIterator {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("Alice");
		names.add("Bob");
		names.add("Charlie");
		names.add("Diana");

		ListIterator<String> listItr = names.listIterator();

		System.out.println("Forward Traversal:");
		while (listItr.hasNext()) {

			System.out.println(listItr.next());
		}

		System.out.println("\nBackward Traversal:");
		while (listItr.hasPrevious()) {
			System.out.println(listItr.previous());
		}
	}
}
