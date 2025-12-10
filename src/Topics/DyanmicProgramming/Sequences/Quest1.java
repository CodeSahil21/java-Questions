package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

public class Quest1 {
    public static void main(String args[]) {
        int[] arr = { 1, 2, 3, 4 };
        int k = 4;
        int n = arr.length;

        // Check if there exists a subset with the given target sum
        if (subsetSumToKTabSpace(n, k, arr))
            System.out.println("Subset with the given target found");
        else
            System.out.println("Subset with the given target not found");
    }
    static boolean subsetSumToKRecursion(int n,int k,int[] arr){
          return subsetSumToKRecursion(n,k,arr,n-1);
    }

    static boolean subsetSumToKRecursion(int n,int k,int[] arr,int ind){
        if(k == 0){
            return true;
        }
        if(ind == 0){
            return arr[0] == k;
        }
        boolean nottake =  subsetSumToKRecursion(n,k,arr,ind-1);
        boolean take = false;
        if(k >= arr[ind]){
          take =   subsetSumToKRecursion(n,k-arr[ind],arr,ind-1);
        }
        return nottake || take;
    }

    static boolean subsetSumToKMemo(int n,int k,int[] arr){
        int[][] dp = new int[n][k+1];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }
        return subsetSumToKMemo(n,k,arr,dp,n-1)==1;
    }

    static int subsetSumToKMemo(int n,int k,int[] arr,int[][] dp,int ind){
        if(k == 0){
            return 1;
        }
        if(ind == 0){
           if(arr[0] == k){
               return 1;
            }
           return 0;
        }
        if(dp[ind][k] != -1){
            return dp[ind][k];
        }
        int nottake =  subsetSumToKMemo(n,k,arr,dp,ind-1);
        int take = 0;
        if(k >= arr[ind]){
            take =   subsetSumToKMemo(n,k-arr[ind],arr,dp,ind-1);
        }
        if(nottake == 1 || take == 1){
            dp[ind][k] = 1;
            return 1;
        }else{
            dp[ind][k] = 0;
            return 0;
        }
    }

    static boolean subsetSumToKTab(int n,int k,int[] arr) {
        boolean[][] dp = new boolean[n][k+1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }
        for (int ind = 1; ind < n; ind++) {
            for (int t = 1; t <=k ; t++) {
                boolean notTake = dp[ind-1][t];
                boolean take = false;
                if(t >= arr[ind]) {
                     take = dp[ind - 1][t - arr[ind]];
                }
                dp[ind][t] = take | notTake;
            }
        }
     return dp[n-1][k];
    }
    static boolean subsetSumToKTabSpace(int n,int k,int[] arr) {
      boolean[] prev = new boolean[k+1];
      prev[0] = true;
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for (int ind = 1; ind < n ; ind++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for (int t = 1; t <=k ; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t >= arr[ind]){
                    take = prev[t - arr[ind]];
                }
                curr[t] = take | notTake;
            }
            prev = curr;
        }
        return prev[k];
    }

}
