package collectionsjava;

import java.util.*;

public class Task15_PriorityQueue {
    public static void main(String[] args) {
        
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Alice", 85);
        scores.put("Bob", 92);
        scores.put("Charlie", 88);
        scores.put("David", 76);
        scores.put("Eve", 95);
        scores.put("Frank", 90);

        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getValue)
        );

        for (Map.Entry<String, Integer> entry : scores.entrySet()) {
            pq.offer(entry);
            if (pq.size() > 3) {
                pq.poll(); 
            }
        }

        // Sort top 3 in descending order
        List<Map.Entry<String, Integer>> top3 = new ArrayList<>(pq);
        top3.sort((a, b) -> b.getValue() - a.getValue());

        System.out.println("Top 3 highest scoring students:");
        for (Map.Entry<String, Integer> e : top3) {
            System.out.println(e.getKey() + " - " + e.getValue());
        }
    }
}
