package fundamentalsjava;
//bubble sort 10.3
public class Task20_Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {15, 12, 48, 1, 13}; 
		for (int i = 0; i < arr.length-1; 
				i++) 
			for (int j = 0; j < arr.length-1-i;
					j++) 
		if (arr[j] > arr[j+1]) { 
		int temp = arr[j]; 
		arr[j] = arr[j+1]; 
		arr[j+1] = temp; 
		} 
		for (int n : arr) System.out.print(n + " ");

	}

}
