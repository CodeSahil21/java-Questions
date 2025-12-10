package Topics.DyanmicProgramming.LIS;

import java.util.Arrays;

//https://leetcode.com/problems/longest-increasing-subsequence/description/
public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + lengthOfLISRecursion(arr, n));
    }
    public static  int lengthOfLISRecursion(int[] arr,int n) {
         return  lengthOfLISRecursion(0,-1,arr,n);
    }
    public static int lengthOfLISRecursion(int ind,int prev_ind,int[] arr,int n){
        if(ind == n){
            return 0;
        }
        int notPick = lengthOfLISRecursion(ind+1,prev_ind,arr,n);
        int pick = Integer.MIN_VALUE;
        if(prev_ind == -1 ||arr[ind] > arr[prev_ind]){
            pick = 1 + lengthOfLISRecursion(ind+1,ind,arr,n);
        }
        int len = Math.max(notPick,pick);
        return len;

    }
    public static  int lengthOfLISMemo(int[] arr,int n) {
        int[][] dp = new int[n][n+1];
        for (int[] a : dp){
            Arrays.fill(a,-1);
        }
        return  lengthOfLISMemo(0,-1,arr,n,dp);
    }
    public static int lengthOfLISMemo(int ind,int prev_ind,int[] arr,int n,int[][] dp){
        if(ind == n){
            return 0;
        }
        if(dp[ind][prev_ind+1] != -1){
            return dp[ind][prev_ind+1];
        }
        int notPick = lengthOfLISMemo(ind+1,prev_ind,arr,n,dp);
        int pick = Integer.MIN_VALUE;
        if(prev_ind == -1 ||arr[ind] > arr[prev_ind]){
            pick = 1 + lengthOfLISMemo(ind+1,ind,arr,n,dp);
        }
        int len = Math.max(notPick,pick);
        return dp[ind][prev_ind+1] = len;

    }
    public static int lengthOfLISTabulation(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int mapped_prev_ind = n; mapped_prev_ind >= 0; mapped_prev_ind--) {

                int prev_ind = mapped_prev_ind - 1;

                int notPick = dp[ind + 1][mapped_prev_ind];

                int pick = 0;

                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    pick = 1 + dp[ind + 1][ind + 1];
                }

                dp[ind][mapped_prev_ind] = Math.max(notPick, pick);
            }
        }

        return dp[0][0];
    }
    public static int lengthOfLIS_SpaceOptimized(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        int[] ahead = new int[n + 1];
        int[] current = new int[n + 1];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int mapped_prev_ind = n; mapped_prev_ind >= 0; mapped_prev_ind--) {

                int prev_ind = mapped_prev_ind - 1;

                int notPick = ahead[mapped_prev_ind];

                int pick = 0;

                if (prev_ind == -1 || arr[ind] > arr[prev_ind]) {
                    pick = 1 + ahead[ind + 1];
                }

                current[mapped_prev_ind] = Math.max(notPick, pick);
            }

            ahead = current.clone();
            current = new int[n + 1];
        }

        return ahead[0];
    }
    public static int lengthOfLISN(int[] arr, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            for (int prev = 0; prev < ind; prev++) {
                if(arr[prev] < arr[ind]){
                    dp[ind] = Math.max(dp[ind],1+dp[prev]);
                }
            }
            maxi = Math.max(maxi,dp[ind]);
        }
       return maxi;
    }

}
