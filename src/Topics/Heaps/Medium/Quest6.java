package Topics.Heaps.Medium;
import java.util.*;
public class Quest6 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = {20,15,26,2,98,6};
        for (int i = 0; i < n; i++) {
            Set < Integer > s = new HashSet < Integer > ();
            for (int j = 0; j < n; j++) {
                if (arr[j] < arr[i]) {
                    s.add(arr[j]);
                }
            }
            int rank = s.size() + 1;
            System.out.print(rank + " ");
        }
}
    public int[] replaceWithRank(int[] arr) {
        int n = arr.length;

        // 1. Min Heap Initialization (to get elements in sorted order)
        // O(N) space, O(N log N) time to build from array (or O(N log N) for N adds)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : arr) {
            minHeap.add(num);
        }

        // Map to store {element_value: rank}
        HashMap<Integer, Integer> rankMap = new HashMap<>();

        // Rank counter starts at 1
        int currentRank = 1;

        // 2. Calculate Ranks by Extracting from Heap
        while (!minHeap.isEmpty()) {
            int smallestElement = minHeap.poll();

            // If the element is not already in the map (i.e., it's a new unique number)
            if (!rankMap.containsKey(smallestElement)) {
                // Assign the current sequential rank
                rankMap.put(smallestElement, currentRank);
            }

            // Crucial Step: The rank counter MUST be incremented whether the element
            // was unique or a duplicate, as the next unique element gets the next rank.
            // Example: [1, 5, 8, 8, 9] -> Ranks: 1, 2, 3, 3, 4. Rank counter goes 1, 2, 3, 4, 5.
            currentRank++;
        }

        // 3. Replace Elements in Original Array Order
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            // Look up the rank for the original value and place it in the result array
            result[i] = rankMap.get(arr[i]);
        }

        return result;
    }
}
