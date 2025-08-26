package Revise.SlidingWindowsandTwoPointers.Hard;
import java.util.*;

public class Quest2 {


    public static int subarraysWithKDistinctOptimal(int[] nums, int k) {
        return atMost(nums, k) - atMost(nums, k - 1);
    }

    private static int atMost(int[] nums, int k) {
        if (k == 0) return 0;

        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while (right < nums.length) {
            countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);

            while (countMap.size() > k) {
                countMap.put(nums[left], countMap.get(nums[left]) - 1);
                if (countMap.get(nums[left]) == 0) {
                    countMap.remove(nums[left]);
                }
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println(subarraysWithKDistinctOptimal(nums, k)); // Output: 7
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return 0;
        }

        int totalCount = 0;
        int n = nums.length;

        // 1. Iterate through each possible starting point of a subarray
        for (int i = 0; i < n; i++) {
            // This set will store distinct elements for subarrays starting at `i`
            Set<Integer> distinctElements = new HashSet<>();

            // 2. Iterate through each possible ending point for the current start
            for (int j = i; j < n; j++) {
                // Add the current element to our set
                distinctElements.add(nums[j]);

                // 3. Check if the size of the set equals k
                if (distinctElements.size() == k) {
                    totalCount++;
                }
                // 4. Optimization: if size exceeds k, no further subarray from this
                // starting point `i` will be valid, so we can break early.
                else if (distinctElements.size() > k) {
                    break;
                }
            }
        }

        return totalCount;
    }
}
