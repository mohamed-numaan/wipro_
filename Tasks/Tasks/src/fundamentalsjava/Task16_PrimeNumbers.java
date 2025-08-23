package fundamentalsjava;

//9.3Printing first 10 prime numbers.

public class Task16_PrimeNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	int coun = 0, number =2;
	while(coun<10) {
		boolean prime = true;
		for(int i =2;i<=number/2;i++)
			if(number%i == 0) {
				prime =false;
				break;
			}
		if(prime) {
			System.out.println(number);
			coun++;
		}
		number++;
	}
	}
	}
