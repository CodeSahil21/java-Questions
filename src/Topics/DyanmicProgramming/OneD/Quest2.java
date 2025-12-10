package Topics.DyanmicProgramming.OneD;

import java.util.Arrays;

public class Quest2 {
        public static void main(String[] args) {
            int[] heights1 = {30,10, 60,10,60, 50};
            int actual1 = minEnergyFrogJump3(heights1);
            System.out.println("Min energy for heights [30,10,60,10,60,50] is: " + actual1);
        }
    public static int minEnergyFrogJump(int[] heights) {
        // We start the recursion from the last stair (N-1)
        return minEnergyFrogJump(heights, heights.length - 1);
    }

    private static int minEnergyFrogJump(int[] heights, int n) {
        // Base case: If we are at the first stair (index 0), no energy is consumed.
        if (n == 0) {
            return 0;
        }

        // Option 1: Jump from n-1 to n (1 step)
        int jumpOne = minEnergyFrogJump(heights, n - 1) + Math.abs(heights[n] - heights[n - 1]);

        // Option 2: Jump from n-2 to n (2 steps)
        int jumpTwo = Integer.MAX_VALUE; // Initialize with a large value
        if (n > 1) {
            jumpTwo = minEnergyFrogJump(heights, n - 2) + Math.abs(heights[n] - heights[n - 2]);
        }

        // Return the minimum of the two options
        return Math.min(jumpOne, jumpTwo);
    }
        public static int minEnergyFrogJump1(int[] heights) {
            int[] dp = new int[heights.length];
            Arrays.fill(dp,-1);
            return minEnergyFrogJump1(heights, heights.length - 1,dp);
        }

        private static int minEnergyFrogJump1(int[] heights, int n,int[] dp) {
            if (dp[n] != -1) {
                return dp[n];
            }
            if (n == 0) {
                return 0;
            }

            int jumpOne = minEnergyFrogJump1(heights, n - 1,dp) + Math.abs(heights[n] - heights[n - 1]);

            int jumpTwo = Integer.MAX_VALUE;
            if (n > 1) {
                jumpTwo = minEnergyFrogJump1(heights, n - 2,dp) + Math.abs(heights[n] - heights[n - 2]);
            }

            return dp[n] = Math.min(jumpOne, jumpTwo);
        }
//Trick to memoization
//Look at the parameters changing
//declare an array of  n+1
//store it before return
//check dp[n] is previously computed

//Tabulation:bottom up
//Look for the base case
//when other line will be executed
public static int minEnergyFrogJump2(int[] heights){
    int n = heights.length;
    if (n <= 1) {
        return 0;
    }

    int[] dp = new int[n];
    dp[0] = 0; // Base case: no energy to be at stair 0

    for(int i = 1; i < n; i++){
        // Option 1: Jump from i-1 to i
        int jumpOne = dp[i-1] + Math.abs(heights[i] - heights[i-1]);

        // Option 2: Jump from i-2 to i (only possible if i > 1)
        int jumpTwo = Integer.MAX_VALUE;
        if (i > 1) {
            jumpTwo = dp[i - 2] + Math.abs(heights[i] - heights[i-2]);
        }

        // Store the minimum of the two options
        dp[i] = Math.min(jumpOne, jumpTwo);
    }
    return dp[n-1];
}
//
public static int minEnergyFrogJump3(int[] heights) {
    int n = heights.length;
    if (n <= 1) {
        return 0;
    }

    // Initialize variables for the first two stairs
    int prev2 = 0; // Cost to reach stair 0
    int prev1 = Math.abs(heights[1] - heights[0]); // Cost to reach stair 1//0

    // Loop from the third stair
    for (int i = 2; i < n; i++) {
        // Option 1: Jump from i-1
        int jumpOne = prev1 + Math.abs(heights[i] - heights[i-1]);

        // Option 2: Jump from i-2
        int jumpTwo = prev2 + Math.abs(heights[i] - heights[i-2]);

        // Calculate min energy for the current stair
        int current = Math.min(jumpOne, jumpTwo);

        // Shift variables for the next iteration
        prev2 = prev1;
        prev1 = current;
    }

    // The final result is stored in prev1
    return prev1;
}
//there will always be space optimization if there ind -1 and ind -2
}
