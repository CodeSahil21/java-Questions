package Topics.DyanmicProgramming.MCMPARTITION;
//https://leetcode.com/problems/partition-array-for-maximum-sum/description/
public class Quest7 {

    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println("Maximum sum after partitioning: " + maxSumAfterPartitioningT(arr, k));
    }

    private int helperR(int[] arr, int k, int start) {
        int n = arr.length;

        if (start == n) return 0;

        int maxSum = 0;
        int maxElem = 0;

        // Try partitions of length 1 to k starting at 'start'
        for (int length = 1; length <= k && start + length <= n; length++) {
            // Update max element for this partition length
            maxElem = Math.max(maxElem, arr[start + length - 1]);

            // Calculate current sum: maxElem * length + recursive result for remaining array
            int currentSum = maxElem * length + helperR(arr, k, start + length);

            // Update maxSum if current partition leads to higher sum
            maxSum = Math.max(maxSum, currentSum);
        }

        // Memoize and return the best max sum for this start index
        return  maxSum;
    }
    public int maxSumAfterPartitioningR(int[] arr, int k) {
        int n = arr.length;
        // Start recursion from index 0
        return helperR(arr, k, 0);
    }
    public int maxSumAfterPartitioningM(int[] arr, int k) {
        int n = arr.length;

        // Initialize memo array with -1 to indicate unvisited states
        int[] memo = new int[n];
        java.util.Arrays.fill(memo, -1);

        // Start recursion from index 0
        return helperM(arr, k, 0, memo);
    }
    private int helperM(int[] arr, int k, int start, int[] memo) {
        int n = arr.length;

        // Base case: if start reached end, no elements left to partition
        if (start == n) return 0;

        // Return cached result if already computed for this start index
        if (memo[start] != -1) return memo[start];

        int maxSum = 0;
        int maxElem = 0;

        // Try partitions of length 1 to k starting at 'start'
        for (int length = 1; length <= k && start + length <= n; length++) {
            // Update max element for this partition length
            maxElem = Math.max(maxElem, arr[start + length - 1]);

            // Calculate current sum: maxElem * length + recursive result for remaining array
            int currentSum = maxElem * length + helperM(arr, k, start + length, memo);

            // Update maxSum if current partition leads to higher sum
            maxSum = Math.max(maxSum, currentSum);
        }

        // Memoize and return the best max sum for this start index
        return memo[start] = maxSum;
    }
    public static int maxSumAfterPartitioningT(int[] arr, int k) {
        int n = arr.length;

        // DP array to store max sum from index i to end
        int[] dp = new int[n + 1];

        // Iterate from right to left over the array
        for (int i = n - 1; i >= 0; i--) {
            int maxElem = 0;
            int maxSum = 0;

            // Check all partitions of length 1 to k starting at i
            for (int length = 1; length <= k && i + length <= n; length++) {
                // Update maximum element for current partition
                maxElem = Math.max(maxElem, arr[i + length - 1]);

                // Calculate sum if partition ends here
                int currentSum = maxElem * length + dp[i + length];

                // Update maxSum if currentSum is greater
                maxSum = Math.max(maxSum, currentSum);
            }

            // Store maximum sum for subarray starting at i
            dp[i] = maxSum;
        }

        // Return max sum achievable starting at index 0
        return dp[0];
    }
}



