package collectionsjava;

import java.util.*;

public class Task4_SetProperties {

    public static void main(String[] args) {
        List<String> inputBrands = Arrays.asList(
            "Toyota", "Mahindra", "Mahindra", "Maruti Suzuki", "Chevrolet", "Chevrolet"
        );

        HashSet<String> brandSet = new HashSet<>();

        System.out.println("Adding brands:");
        for (String brand : inputBrands) {
            if (brandSet.contains(brand)) {
                System.out.println(brand + " not allowed (duplicate)");
            } else {
                brandSet.add(brand);
                System.out.println(brand + " added");
            }
        }

        // Print final list of unique brands
        System.out.println("\nFinal Brand List (no duplicates):");
        System.out.println(brandSet);
    }
}
