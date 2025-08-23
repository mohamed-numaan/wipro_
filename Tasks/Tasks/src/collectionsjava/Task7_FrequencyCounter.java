package collectionsjava;
 
import java.util.*;

public class Task7_FrequencyCounter {
    public static void main(String[] args) {
        String input = "hello";

        LinkedHashMap<Character, Integer> count = new LinkedHashMap<>();

        for (char ch : input.toCharArray()) {
            if (count.containsKey(ch)) {
                count.put(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        } //logic

        System.out.println(count);
    }
}
