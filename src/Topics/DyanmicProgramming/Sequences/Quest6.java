package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

//https://takeuforward.org/data-structure/unbounded-knapsack-dp-23/
public class Quest6 {
    public static void main(String[] args) {
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + Knapsack01Tabulation(n, W, val, wt));
    }
    public static int unboundedKnapsackRecursion(int n,int W,int[] val,int[] wt){
      return Knapsack01RecursionC(n-1,W,val,wt);
    }
    private static int Knapsack01RecursionC(int ind,int W,int[] val, int[] wt){
        if(ind == 0){
            if(wt[0] <= W){
                return val[0];
            }else{
                return 0;
            }
        }

        int notTake = Knapsack01RecursionC(ind-1,W,val,wt);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + Knapsack01RecursionC(ind-1,W-wt[ind],val,wt);
        }
        return Math.max(notTake,take);
    }
    public static int Knapsack01Memomize(int n,int W,int[] val,int[] wt){
        int[][] dp = new int[n][W+1];
        for (int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return Knapsack01Memoization(n-1,W,val,wt,dp);
    }
    private static int Knapsack01Memoization(int ind,int W,int[] val, int[] wt,int[][] dp){
        if(ind == 0){
            if(wt[0] <= W){
                return val[0];
            }else{
                return 0;
            }
        }
        if(dp[ind][W] != -1){
            return dp[ind][W];
        }
        int notTake = Knapsack01Memoization(ind-1,W,val,wt,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + Knapsack01Memoization(ind-1,W-wt[ind],val,wt,dp);
        }
        return dp[ind][W] = Math.max(notTake,take);
    }
    // Corrected initialization and base case logic for Java
    public static int Knapsack01Tabulation(int n, int W, int[] val, int[] wt) {
        // 1. Initialize DP table (all cells are default 0)
        int[][] dp = new int[n][W + 1];
        // No need for Arrays.fill(arr, -1);

        // 2. Base Case (Striver's simplified approach)
        int weight0 = wt[0];
        int value0 = val[0];

        // Only loop for capacities where the item *can* fit (j >= wt[0])
        for (int j = weight0; j <= W; j++) {
            dp[0][j] = value0;
        }

        // ... rest of the transition logic (which also needs the capacity check fix)
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= W ; j++) {
                int notTake = dp[i-1][j];
                int take = Integer.MIN_VALUE;

                // The critical FIX needed in your original code: Check against current capacity 'j'
                if(wt[i] <= j){
                    take = val[i] + dp[i-1][j - wt[i]];
                }

                dp[i][j] = Math.max(take, notTake);
            }
        }
        return dp[n-1][W];
    }
    public static int Knapsack01TabulationSpace(int n, int W, int[] val, int[] wt) {
        // 1. Initialize DP table (all cells are default 0)
        int[] prev = new int[W+1];
        // No need for Arrays.fill(arr, -1);

        // 2. Base Case (Striver's simplified approach)
        int weight0 = wt[0];
        int value0 = val[0];

        // Only loop for capacities where the item *can* fit (j >= wt[0])
        for (int j = weight0; j <= W; j++) {
            prev[j] = value0;
        }

        // ... rest of the transition logic (which also needs the capacity check fix)
        for (int i = 1; i < n; i++) {
            int[] curr = new int[W+1];
            for (int j = 0; j <= W ; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;

                // The critical FIX needed in your original code: Check against current capacity 'j'
                if(wt[i] <= j){
                    take = val[i] + prev[j - wt[i]];
                }

                curr[j] = Math.max(take, notTake);
            }
            prev = curr;
        }
        return prev[W];
    }
}
