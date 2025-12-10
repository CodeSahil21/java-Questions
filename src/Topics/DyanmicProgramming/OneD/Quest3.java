package Topics.DyanmicProgramming.OneD;

public class Quest3 {
    public static void main(String[] args) {

    }
    private int solveRecursive(int[] heights, int i, int k) {
        // Base case: at the starting stair, no energy is consumed.
        if (i == 0) {
            return 0;
        }

        int minEnergy = Integer.MAX_VALUE;

        // Iterate through all possible previous jumps (up to k steps)
        for (int j = 1; j <= k; j++) {
            // Check if a jump of size j is possible (i.e., not jumping off the start)
            if (i - j >= 0) {
                int jumpEnergy = solveRecursive(heights, i - j, k) + Math.abs(heights[i] - heights[i - j]);
                minEnergy = Math.min(minEnergy, jumpEnergy);
            }
        }
        return minEnergy;
    }
    private int solveMemo(int[] heights, int i, int k, int[] dp) {
        if (i == 0) {
            return 0;
        }

        // Check the cache
        if (dp[i] != -1) {
            return dp[i];
        }

        int minEnergy = Integer.MAX_VALUE;

        for (int j = 1; j <= k; j++) {
            if (i - j >= 0) {
                int jumpEnergy = solveMemo(heights, i - j, k, dp) + Math.abs(heights[i] - heights[i - j]);
                minEnergy = Math.min(minEnergy, jumpEnergy);
            }
        }
        // Store result in the cache before returning
        return dp[i] = minEnergy;
    }
    public int frogJumpTab(int[] heights, int k) {
        int n = heights.length;
        int[] dp = new int[n];
        dp[0] = 0; // Base case

        // Iterate through all stairs from 1 to N-1
        for (int i = 1; i < n; i++) {
            int minEnergy = Integer.MAX_VALUE;

            // Iterate through all possible jumps up to k steps
            for (int j = 1; j <= k; j++) {
                // Ensure the jump is within bounds
                if (i - j >= 0) {
                    int jumpEnergy = dp[i - j] + Math.abs(heights[i] - heights[i - j]);
                    minEnergy = Math.min(minEnergy, jumpEnergy);
                }
            }
            dp[i] = minEnergy;
        }
        return dp[n - 1];
    }
}

