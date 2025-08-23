package wrapperjava;

import java.util.ArrayList;
import java.util.List;

//auto boxing and unboxing

public class Task2_Autoboxing {
	public static void main(String[] args) {

		List<Double> list = new ArrayList<Double>();
		//declaring values
		list.add(45.0);
		list.add(12.1);
		list.add(15.47);
		list.add(45.10);

		double sum = 0.0;

		for(Double val: list) {
			sum += val;
		}

		double average = sum/list.size();


		System.out.println("Sum of elements: "+sum);
		System.out.println("Average: " +average);
	}
}
