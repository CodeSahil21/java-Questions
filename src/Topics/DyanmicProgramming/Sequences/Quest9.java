package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

//https://leetcode.com/problems/coin-change-ii/description/
public class Quest9 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        int target = 4;
        int n = arr.length;

        // Call the countWaysToMakeChange function and print the result
        System.out.println("The total number of ways is " + countWaysToMakeChangeRecursion(arr, n, target));
    }

    static int countWaysToMakeChangeRecursion(int[] arr,int n,int target){
        return countWaysToMakeChangeRecursion(arr,n,n-1,target);
    }
    static int countWaysToMakeChangeRecursion(int[] arr,int n,int ind,int target){
         if(ind == 0){
             if(target % arr[0] == 0){
                 return 1;
             }else{
                 return 0;
             }
         }
        int notTake = countWaysToMakeChangeRecursion(arr,n,ind-1,target);
        int take = 0;
        if(arr[ind] <= target){
            take = countWaysToMakeChangeRecursion(arr,n,ind,target-arr[ind]);
        }
        return notTake +take;
    }
    static int countWaysToMakeChangeMemoization(int[] arr,int n,int target){
        int[][] dp = new int[n][target+1];
        for(int[] a : dp){
            Arrays.fill(a,-1);
        }
        return countWaysToMakeChangeMemo(arr,dp,n,n-1,target);
    }
    static int countWaysToMakeChangeMemo(int[] arr,int[][] dp,int n,int ind,int target){
        if(ind == 0){
            if(target % arr[0] == 0){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[ind][target] != -1){
            return dp[ind][target];
        }
        int notTake = countWaysToMakeChangeMemo(arr,dp,n,ind-1,target);
        int take = 0;
        if(arr[ind] <= target){
            take = countWaysToMakeChangeMemo(arr,dp,n,ind,target-arr[ind]);
        }
        return dp[ind][target] = notTake +take;
    }
    static int countWaysToMakeChangeTabulation(int[] arr,int n,int target){
        int[][] dp = new int[n][target+1];
        for(int t =0 ; t <= target;t++){
            if(t % arr[0] == 0){
                dp[0][t] = 1;
            }else{
                dp[0][t] = 0;
            }
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int t = 0; t <= target ; t++) {
                int notTake = dp[ind-1][t];
                int take = 0;
                if(arr[ind] <= t){
                    take = dp[ind][t-arr[ind]];
                }
                dp[ind][t] = notTake + take;
            }
        }
        return dp[n-1][target];
    }
    static int countWaysToMakeChangeTabulationSpace(int[] arr,int n,int target){
        int[] prev = new int[target+1];
        int[] curr = new int[target+1];
        for(int t =0 ; t <= target;t++){
            if(t % arr[0] == 0){
                prev[t] = 1;
            }else{
                prev[t] = 0;
            }
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int t = 0; t <= target ; t++) {
                int notTake = prev[t];
                int take = 0;
                if(arr[ind] <= t){
                    take = curr[t-arr[ind]];
                }
                curr[t] = notTake + take;
            }
            prev = curr.clone();
        }
        return curr[target];
    }
}
