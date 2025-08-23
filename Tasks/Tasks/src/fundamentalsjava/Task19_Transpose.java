package fundamentalsjava;
// Three matrix  10.2
public class Task19_Transpose {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{7,8,9},{10,11,12},{13,14,15}}; 
		for (int i = 0; i < 3; i++) 
			for (int j = i; j < 3; j++) { 
				int temp = matrix[i][j]; 
				matrix[i][j] = matrix[j][i]; 
				matrix[j][i] = temp; 
		
				} 
		for (int[] row : matrix) { 
			for (int val : row) 
				System.out.print(val + " "); 
			System.out.println(); 

		}
		}
}
