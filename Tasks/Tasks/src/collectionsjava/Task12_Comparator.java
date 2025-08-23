package collectionsjava;
//Students using a comparator
import java.util.*;

class Students {
	int rollNo;
	String name;
	Students(int rollNo, String name) {
		this.rollNo = rollNo;
		this.name = name;
	}
	@Override
	public String toString() {
		return rollNo + " " + name;
	}
}
class SortByName implements Comparator<Students> {
	public int compare(Students o1, Students o2) {
		return o1.name.compareTo(o2.name);
	}
}

public class Task12_Comparator {
	public static void main(String[] args) {
		List<Students> list = new ArrayList<>();
		list.add(new Students(104, "Maya"));
		list.add(new Students(101, "Alex"));
		list.add(new Students(102, "Charlie"));
		list.add(new Students(103, "JD"));

		// Sort by name
		Collections.sort(list, new SortByName());
		System.out.println("Sorted by names:");

		for (Students s : list) {
			System.out.println(s);
		}
	}
}
