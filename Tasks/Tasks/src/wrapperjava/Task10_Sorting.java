package wrapperjava;

import java.util.Arrays;

public class Task10_Sorting {
    public static void main(String[] args) {
        // Integer wrapper class array
        Integer[] numbers = {10, 50, 40,20, 30};

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Print sorted array
        System.out.println("Sorted Array: " + Arrays.toString(numbers));

        // Get 2nd highest value (second last element)
        int secondHighest = numbers[numbers.length - 2];

        System.out.println("Second Highest Value: " + secondHighest);
    }
}
