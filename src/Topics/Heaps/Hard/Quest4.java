package Topics.Heaps.Hard;
import java.util.*;
public class Quest4 {
    public List<Integer> maxCombinations(int[] nums1, int[] nums2, int k) {

        // List to store all possible pair sums
        List<Integer> allSums = new ArrayList<>();

        // 1. GENERATE ALL SUMS (O(N*M))
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                // Store the sum of the pair
                allSums.add(nums1[i] + nums2[j]);
            }
        }

        // 2. SORT ALL SUMS (O(N*M log(N*M)))
        // Collections.reverseOrder() ensures descending order (largest to smallest)
        allSums.sort(Collections.reverseOrder());

        // 3. RETURN TOP K (O(k))
        // subList(0, k) grabs the elements from index 0 up to (but not including) index k
        return allSums.subList(0, k);
    }
    public List<Integer> maxCombinationsOptimized(int[] nums1, int[] nums2, int k) {
        // 1. Sort both arrays (O(N log N))
        Arrays.sort(nums1); // Sorts ascending, so largest elements are at the end (n-1)
        Arrays.sort(nums2);
        int n = nums1.length;

        // 2. Max Heap Setup (Comparator b[0] - a[0] ensures max sum is at the top)
        // Stores: [Sum, index_i, index_j]
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        // 3. Visited Set Setup
        Set<String> visited = new HashSet<>();

        // 4. Seed the Heap with the absolute max sum (n-1, n-1)
        maxHeap.offer(new int[]{nums1[n - 1] + nums2[n - 1], n - 1, n - 1});
        visited.add((n - 1) + "," + (n - 1));

        List<Integer> result = new ArrayList<>();

        // 5. Extract top k combinations (The Merge Search)
        while (k-- > 0 && !maxHeap.isEmpty()) {
            int[] current = maxHeap.poll();
            int sum = current[0], i = current[1], j = current[2];

            result.add(sum); // Add current largest sum to result

            // 6. Explore Neighbor (i-1, j): Moving left in nums1
            if (i - 1 >= 0) {
                String key1 = (i - 1) + "," + j;
                if (!visited.contains(key1)) {
                    maxHeap.offer(new int[]{nums1[i - 1] + nums2[j], i - 1, j});
                    visited.add(key1);
                }
            }

            // 7. Explore Neighbor (i, j-1): Moving left in nums2
            if (j - 1 >= 0) {
                String key2 = i + "," + (j - 1);
                // NOTE: We only check one direction (i, j-1).
                // The pair (i-1, j-1) will be explored later when either (i-1, j) or (i, j-1) is popped.
                if (!visited.contains(key2)) {
                    maxHeap.offer(new int[]{nums1[i] + nums2[j - 1], i, j - 1});
                    visited.add(key2);
                }
            }
        }

        return result;
    }
}
