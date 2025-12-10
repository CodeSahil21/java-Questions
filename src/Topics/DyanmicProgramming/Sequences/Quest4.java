package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3};
        int k = 3;

        // Calculate and print the number of subsets that sum up to k
        System.out.println("The number of subsets found are " + findWaysTabSpace(arr, k));
    }
    static int findWaysRecursion(int[] arr,int k){
       int n = arr.length;
       return findWaysRecursion(arr,k,n-1);
    }
    static  int findWaysRecursion(int[] arr,int k, int i){
        if(k == 0){
            return 1;
        }
        if(i == 0 ){
            return (arr[i] == k) ? 1: 0;
        }
        int notPick = findWaysRecursion(arr,k,i-1);
        int pick = 0;
        if(k >= arr[i]) {
            pick = findWaysRecursion(arr, k - arr[i], i - 1);
        }
        return pick+notPick;
    }
    /*
        static  int findWaysRecursion(int[] arr,int k, int i){
        if(i == 0 ){
            if(k == 0 && arr[0] == 0){
             return 2;
             }
            if(k == 0 || sum == arr[0]){
            return 1;
            }
            return 0;
        }
        int notPick = findWaysRecursion(arr,k,i-1);
        int pick = 0;
        if(k >= arr[i]) {
            pick = findWaysRecursion(arr, k - arr[i], i - 1);
        }
        return pick+notPick;
    }
     */

    static int findWaysMemo(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        for (int[] a:dp) {
            Arrays.fill(a,-1);
        }
        return findWaysMemo(arr,dp,k,n-1);
    }
    static  int findWaysMemo(int[] arr,int[][] dp,int k, int i){
        if(k == 0){
            return 1;
        }
        if(i == 0 ){
            return (arr[i] == k) ? 1: 0;
        }
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        int notPick = findWaysMemo(arr,dp,k,i-1);
        int pick = 0;
        if(k >= arr[i]) {
            pick = findWaysMemo(arr, dp,k - arr[i], i - 1);
        }
        return dp[i][k] = pick+notPick;
    }

    static int findWaysTab(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        for(int i = 0; i < n; i++){
            dp[i][0] = 1;
        }
        if(arr[0] <= k){
            dp[0][arr[0]] =1;
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int target = 1; target <= k ; target++) {
                int left = dp[ind-1][target];
                int right = 0;
                if(target >= arr[ind]){
                    right = dp[ind-1][target - arr[ind]];
                }
                dp[ind][target] = right + left;
            }
        }

     return dp[n-1][k];
    }
    /*\
        static int findWaysTab(int[] arr,int k){
        int n = arr.length;
        int[][] dp = new int[n][k+1];
        if(arr[0] == 0) dp[0][0] =2;
        else dp[0][0] =1;
         if(arr[0] != 0 && arr[0] <= k){
            dp[0][arr[0]] =1;
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int target = 1; target <= k ; target++) {
                int left = dp[ind-1][target];
                int right = 0;
                if(target >= arr[ind]){
                    right = dp[ind-1][target - arr[ind]];
                }
                dp[ind][target] = right + left;
            }
        }

     return dp[n-1][k];
    }
     */

    static int findWaysTabSpace(int[] arr,int k){
      int n = arr.length;
      int[] prev = new int[k+1];
      prev[0] = 1;
      if(arr[0] <= k){
            prev[arr[0]] =1;
      }
        for (int ind = 1; ind < n; ind++) {
            int[] curr = new int[k+1];
            curr[0] = 1;
            for (int target = 1; target <= k ; target++) {
                int notpick = prev[target];
                int pick = 0;
                if(target >= arr[ind]){
                    pick = prev[target-arr[ind]];
                }
                curr[target] = notpick + pick;
            }
            prev = curr;
        }
        return prev[k];
    }
}
