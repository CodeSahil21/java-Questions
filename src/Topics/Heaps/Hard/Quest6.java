package Topics.Heaps.Hard;
import java.util.*;
//https://leetcode.com/problems/top-k-frequent-elements/description/
public class Quest6 {
    public static void main(String[] args) {

    }
        public int[] topKFrequent(int[] nums, int k) {
            // 1. COUNT FREQUENCIES (O(N))
            Map<Integer, Integer> freqMap = new HashMap<>();
            for (int num : nums) {
                freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
            }

            // 2. BUILD AND MAINTAIN MIN-HEAP OF SIZE K (O(M log k))
            // The heap stores the unique elements and is ordered by their frequency (the value).
            // Since we want the smallest frequency at the top, we use a Min-Heap.
            // We store the elements (keys) of the map, and use the map's values for comparison.
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(
                    // Lambda: Min-Heap based on frequency (a.freq - b.freq)
                    (a, b) -> freqMap.get(a) - freqMap.get(b)
            );

            for (int element : freqMap.keySet()) {
                minHeap.offer(element); // O(log k)

                // If the heap grows larger than k, remove the element with the MINIMUM frequency.
                if (minHeap.size() > k) {
                    minHeap.poll(); // O(log k)
                }
            }

            // 3. EXTRACT RESULTS (O(k log k))
            int[] result = new int[k];
            for (int i = 0; i < k; i++) {
                result[i] = minHeap.poll();
            }

            return result;
        }

}
