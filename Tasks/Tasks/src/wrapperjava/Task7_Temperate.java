package wrapperjava;

import java.util.ArrayList;

public class Task7_Temperate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] celsius = {"10","20","30"};
	
		ArrayList<Double> fahrenheitList = new ArrayList<>();
		for(int i=0;i<=celsius.length-1;i++) {
			int in = Integer.parseInt(celsius[i]);
			double f = (in *9.0/5)+32; //converting celsius to fahrenheit
			fahrenheitList.add(f);
			System.out.print("Celsius:" +in +"°C");
			System.out.println();
			System.out.println("Fahrenheit: "+f +"°F");
		}
		}
	}


