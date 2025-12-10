package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change/
public class Quest7 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int T = 7;

        // Call the minimumElements function and print the result
        System.out.println("The minimum number of coins required to form the target sum is " + minimumElementsRecursion(arr, T));
    }
    public static int minimumElementsRecursion(int[] arr,int target){
        int n= arr.length;
        return minimumElementsRecursion(arr,target,n-1);
    }
    public static int minimumElementsRecursion(int[] arr,int target,int ind){

        if(ind == 0){
            if(target % arr[0] == 0){
                return target/arr[0];
            }else {
                return Integer.MAX_VALUE;
            }
        }
        int notTake = minimumElementsRecursion(arr,target,ind-1);
        int take = Integer.MAX_VALUE;
        if(arr[ind] <= target){
            take =  1 + minimumElementsRecursion(arr,target-arr[ind],ind);
        }
        return Math.min(notTake,take);
    }

    public static int minimumElementsMemoization(int[] arr,int target){
        int n= arr.length;
        int[][] dp = new int[n][target+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        int ans = minimumElementsMemoization(arr,target,n-1,dp);
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
    public static int minimumElementsMemoization(int[] arr,int target,int ind,int[][] dp){
        if (target == 0) {
            return 0;
        }
        if(ind == 0){
            if(target % arr[0] == 0){
                return target/arr[0];
            }else {
                return (int) Math.pow(10, 9);
            }
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int notTake = minimumElementsMemoization(arr,target,ind-1,dp);
        int take = (int) Math.pow(10, 9);
        if(arr[ind] <= target){
            take =  1 + minimumElementsMemoization(arr,target-arr[ind],ind,dp);
        }
        return dp[ind][target] = Math.min(notTake,take);
    }

    public static int minimumElementsTabulation(int[] arr,int target){
        int n= arr.length;
        int[][] dp = new int[n][target+1];
        for (int i = 0; i <= target; i++) {
            if(target % arr[0] == 0){
                dp[0][target] = target /arr[0];
            }else{
                dp[0][target] = Integer.MAX_VALUE;
            }
        }
        for(int ind = 1; ind < n; ind++){
            for (int Target = 0; Target <= target ; Target++) {
                int notTake = dp[ind-1][Target];
                int take =  Integer.MAX_VALUE;
                if(arr[ind] <=  Target){
                    take = 1 + dp[ind][Target - arr[ind]];
                }
                dp[ind][Target] = Math.min(notTake,take);
            }
        }
        int ans = dp[n - 1][target];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
    static int minimumElements(int[] arr, int T) {
        int n = arr.length;

        // Create two arrays to store results of subproblems: prev and cur
        int[] prev = new int[T + 1];
        int[] cur = new int[T + 1];

        // Initialize the prev array for the first element of the array
        for (int i = 0; i <= T; i++) {
            if (i % arr[0] == 0)
                prev[i] = i / arr[0];
            else
                prev[i] = (int) Math.pow(10, 9);
        }

        // Fill the cur array using dynamic programming
        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= T; target++) {
                int notTake = prev[target];
                int take = (int) Math.pow(10, 9);

                // If the current element is less than or equal to the target, calculate 'take'
                if (arr[ind] <= target)
                    take = 1 + cur[target - arr[ind]];

                // Store the minimum result in the cur array
                cur[target] = Math.min(notTake, take);
            }

            // Update prev with cur for the next iteration
            prev = cur.clone();
        }

        // Get the minimum number of elements needed for the target sum
        int ans = prev[T];

        // If it's not possible to achieve the target sum, return -1
        if (ans >= (int) Math.pow(10, 9))
            return -1;
        return ans;
    }
}
