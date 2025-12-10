package Topics.DyanmicProgramming.OneD;

import java.util.Arrays;

public class Quest4 {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println("Maximum amount robbed from [1, 2, 3, 1] is: " + rob(nums1)); // Expected output: 4

        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println("Maximum amount robbed from [2, 7, 9, 3, 1] is: " + rob(nums2)); // Expected output: 12
    }
    public static int rob(int[] nums) {
         return rob(nums,nums.length-1);
    }
    private static int rob(int[] nums, int ind){
        if(ind == 0){
            return nums[ind];
        }
        if(ind < 0){
            return 0;
        }
        int pick = nums[ind] + rob(nums,ind-2);
        int notPick =  rob(nums,ind-1);
        return  Math.max(pick,notPick);
    }
    public static int robmemo(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Initialize dp array with -1 to indicate uncomputed values
        Arrays.fill(dp, -1);
        return robmemo(nums, dp, n - 1);
    }
    private static  int robmemo(int[] nums,int[] dp,int ind){
        if(ind == 0){
            return nums[ind];
        }
        if(ind < 0){
            return 0;
        }
        if(dp[ind] != -1){
            return dp[ind];
        }
        int pick = nums[ind] + robmemo(nums,dp,ind-2);
        int notPick =  robmemo(nums,dp,ind-1);
        return  dp[ind] = Math.max(pick,notPick);
    }

    public static int robTab(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // Create the DP array to store max amounts at each house
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Iterate from the third house
        for (int i = 2; i < n; i++) {
            // Option 1: Take the current house
            // You cannot rob the previous house, so add to the amount from two houses back
            int take = nums[i] + dp[i - 2];

            // Option 2: Do NOT take the current house
            // The max amount is simply the max amount from the previous house
            int notTake = dp[i - 1];

            // Store the maximum of the two options
            dp[i] = Math.max(take, notTake);
        }

        // The final answer is the max amount at the last house
        return dp[n - 1];
    }
    public static int robTab2(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }


        // Base cases
        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        // Iterate from the third house
        for (int i = 2; i < n; i++) {
            // Option 1: Take the current house
            // You cannot rob the previous house, so add to the amount from two houses back
            int take = nums[i] + prev2;

            // Option 2: Do NOT take the current house
            // The max amount is simply the max amount from the previous house
            int notTake = prev1;

            // Store the maximum of the two options
            int current = Math.max(take,notTake);
            prev2 = prev1;
            prev1 = current;

        }

        // The final answer is the max amount at the last house
        return prev1;
    }
}
