package wrapperjava;

import java.util.ArrayList;
import java.util.Collections;

public class Task6_ArrayList {
	public static void main(String[] args) {
		ArrayList<Integer> marks = new ArrayList<>();
		marks.add(100);
		marks.add(75);
		marks.add(60);
		marks.add(80);
		marks.add(35);
		
		System.out.println("Original Marks: " +marks);
		

		Integer maxMark = Collections.max(marks);
		System.out.println("Maximum mark is: " +maxMark);
		
		Integer minMark = Collections.min(marks);
		System.out.println("Minimum mark is :" +minMark);
		
		
		int sum =0;
		for(Integer mark: marks) {
			sum +=mark;
		}
		
		double average = sum/marks.size();
		System.out.println("Average is:" +average);
		
	}
}
