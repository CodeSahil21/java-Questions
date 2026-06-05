package Topics.Arrays.Easy;
//https://leetcode.com/problems/maximum-subarray/description/
//53 Maximum Subarray: Kadane's Algorithm
public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maxsubarray :" + maxSubArray(arr));
    }

    //o(n) complexity
    public static int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        // Initialize max_current and max_global with the first element of the array
        int max_current = nums[0];
        int max_global = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update max_current to the maximum of the current element alone or the current element plus the previous max_current
            max_current = Math.max(nums[i], max_current + nums[i]);
            // Update max_global to the maximum of max_global and max_current
            max_global = Math.max(max_global, max_current);
        }
        // Return the maximum sum found
        return max_global;
    }
}
/*
Phase 1: The Brute Force Approach ($O(n^2)$)Explain to the interviewer that you’ll start by exploring all possible subarrays to establish a baseline.The Narrative: "My first instinct is to check every possible subarray. I can use a nested loop where the outer loop marks the start and the inner loop calculates the sum of all subarrays beginning at that index."Javapublic static int maxSubArrayBruteForce(int[] nums) {
    int maxGlobal = Integer.MIN_VALUE;

    for (int i = 0; i < nums.length; i++) {
        int currentSubarraySum = 0;
        for (int j = i; j < nums.length; j++) {
            currentSubarraySum += nums[j];
            maxGlobal = Math.max(maxGlobal, currentSubarraySum);
        }
    }
    return maxGlobal;
}
Why this is "Better" than $O(n^3)$: "Notice I'm reusing the currentSubarraySum instead of a third loop. However, this is still $O(n^2)$ time complexity. For an array of $10^5$ elements, this would perform $10^{10}$ operations, which is too slow for production or competitive environments."Phase 2: The Logic Shift (Kadane’s Insight)Before jumping into the final code, explain the "Aha!" moment. This is what interviewers actually look for.The Narrative: "I realized that as I move through the array, I don't need to look back at every starting point. At any index $i$, I only have two choices:Extend: Add the current element to the existing best subarray ending at $i-1$.Restart: If the previous sum was negative, it’s actually dragging me down. I should start a brand new subarray at $i$."Phase 3: The Optimal Solution ($O(n)$)Now, write the clean, optimized version. Explain that you are using Dynamic Programming to reduce the time complexity to linear.Javapublic static int maxSubArray(int[] nums) {
    // Edge case: although usually guaranteed non-empty
    if (nums == null || nums.length == 0) return 0;

    // Initialize with the first element
    int maxCurrent = nums[0];
    int maxGlobal = nums[0];

    for (int i = 1; i < nums.length; i++) {

//The Core Decision:
//Is the current element stronger on its own,
//or does the previous sum help it?

    maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);

    // Update the 'all-time' record
    maxGlobal = Math.max(maxGlobal, maxCurrent);
}

    return maxGlobal;
}
Phase 4: Summarizing for the InterviewerWrap up by highlighting the efficiency gains and the space complexity.MetricBrute ForceKadane's AlgorithmTime Complexity$O(n^2)$$O(n)$Space Complexity$O(1)$$O(1)$VerdictToo slow for large $n$Optimal for all $n$Final Touch: "By moving from checking every possibility to making a greedy choice at each step, we've optimized the runtime from quadratic to linear while maintaining constant space."How does this narrative flow feel to you? Should we add the logic for returning the actual subarray indices as well?
 */
/*

 */

