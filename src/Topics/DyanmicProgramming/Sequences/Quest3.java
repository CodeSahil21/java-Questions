package Topics.DyanmicProgramming.Sequences;
//https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/description/
public class Quest3 {
    public static void main(String[] args) {
     int[] arr = {1,2,3,4};
     int n = arr.length;
     System.out.println("The minimum absolute difference is: " + minimumDifference(arr));
    }
    public static int minimumDifference(int[] nums) {
       int n = nums.length;
       int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += nums[i];
        }
       boolean[] prev = new boolean[totalSum+1];
        prev[0] = true;
        if(totalSum >= nums[0]){
            prev[nums[0]] = true;
        }
        for (int ind = 1; ind < n ; ind++) {
            boolean[] curr = new boolean[totalSum+1];
            curr[0] = true;
            for (int target = 1; target <= totalSum; target++) {
                boolean notTake = prev[target];
                boolean take = false;
                if(target >= nums[ind]){
                    take = prev[target - nums[ind]];
                }
                curr[target] = take| notTake;
            }
            prev = curr;
        }
        int mini= Integer.MAX_VALUE;
        for (int i = 0; i <= totalSum ; i++) {
            if(prev[i]){
                int diff = Math.abs(i - (totalSum -i));
                mini = Math.min(diff,mini);
            }
        }
        return mini;
    }
    /*
    public static int minimumDifference(int[] nums) {
    int n = nums.length;
    int totalSum = 0;
    int negSum = 0; // Will store the sum of all negative elements (S_min)

    // 1. Calculate the necessary range and totalSum.
    for (int num : nums) {
        totalSum += num;
        if (num < 0) {
            negSum += num;
        }
    }

    // Calculate the maximum possible positive sum (S_max)
    int posSum = totalSum - negSum;

    // The offset to shift the smallest possible sum (negSum) to index 0.
    int offset = Math.abs(negSum);

    // The size of the DP array must cover the range from negSum to posSum.
    int dpSize = posSum - negSum + 1; // Correct size: S_max - S_min + 1

    // The boolean array now tracks possible sums S, where the index is (S + offset).
    boolean[] prev = new boolean[dpSize];

    // Base Case: Sum 0 is always possible. It maps to the index 'offset'.
    // If the original totalSum was used here, it would fail for negative numbers.
    prev[offset] = true;

    // **Note:** The original initialization for nums[0] is removed, as it's handled
    // by starting the main DP loop from ind=0. Since you requested the original loop structure,
    // we'll keep the ind=1 start but adjust the initialization to handle nums[0] correctly.

    // Correct Initialization for nums[0] using the new shifted index:
    // The sum nums[0] maps to index (nums[0] + offset).
    int firstNumIdx = nums[0] + offset;
    if (firstNumIdx >= 0 && firstNumIdx < dpSize) {
        prev[firstNumIdx] = true;
    }


    // 2. Dynamic Programming Transition (Starting from the second element, ind=1).
    for (int ind = 1; ind < n; ind++) {
        boolean[] curr = new boolean[dpSize];

        // Sum 0 is always possible, maps to index 'offset'.
        curr[offset] = true;

        // Loop through all possible shifted indices.
        for (int sumIdx = 0; sumIdx < dpSize; sumIdx++) {

            // Not Take: Inherit possibility from the previous element.
            boolean notTake = prev[sumIdx];

            // Take: Check if the previous sum needed was possible.
            // Required previous index = (Current Sum Index) - (Current Number)
            int prevIdx = sumIdx - nums[ind];
            boolean take = false;

            // Check if the previous index is within the valid bounds of the DP array.
            if (prevIdx >= 0 && prevIdx < dpSize) {
                take = prev[prevIdx];
            }

            curr[sumIdx] = take | notTake;
        }
        prev = curr;
    }

    // 3. Find the Minimum Difference.
    int mini = Integer.MAX_VALUE;

    // Loop over all indices that represent a possible subset sum.
    for (int sumIdx = 0; sumIdx < dpSize; sumIdx++) {
        if (prev[sumIdx]) {
            // Un-shift the index to get the true subset sum S1.
            int S1 = sumIdx - offset;

            // Calculate the absolute difference: |S1 - S2| = |S1 - (totalSum - S1)| = |2*S1 - totalSum|
            int diff = Math.abs(totalSum - 2 * S1);
            mini = Math.min(diff, mini);
        }
    }
    return mini;
}
     */
}
