package Topics.DyanmicProgramming.Strings;

import java.util.Arrays;

//https://leetcode.com/problems/distinct-subsequences/
public class Quest8 {
    public static void main(String[] args) {
        String s1 = "babgbag";
        String s2 = "bag";

        System.out.println("The Count of Distinct Subsequences is " + subsequenceCountingRecursion(s1, s2));
    }
    static int subsequenceCountingRecursion(String s1,String s2){
      int n = s1.length();
      int m = s2.length();
      return  subsequenceCountingRecursion(n-1,m-1,s1,s2);
    }
    static int subsequenceCountingRecursion(int ind1,int ind2,String s1,String s2){
        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return subsequenceCountingRecursion(ind1-1,ind2-1,s1,s2) + subsequenceCountingRecursion(ind1-1,ind2,s1,s2);
        }else{
            return subsequenceCountingRecursion(ind1-1,ind2,s1,s2);
        }
    }
    static int subsequenceCountingMemo(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for (int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return  subsequenceCountingMemo(n-1,m-1,s1,s2,dp);
    }
    static int subsequenceCountingMemo(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind2 < 0){
            return 1;
        }
        if(ind1 < 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = subsequenceCountingMemo(ind1-1,ind2-1,s1,s2,dp) + subsequenceCountingMemo(ind1-1,ind2,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = subsequenceCountingMemo(ind1-1,ind2,s1,s2,dp);
        }
    }
    /*
        static int subsequenceCountingMemo(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        return  subsequenceCountingMemo(n,m,s1,s2,dp);
    }
    static int subsequenceCountingMemo(int ind1,int ind2,String s1,String s2,int[][] dp){
        if(ind2 == 0){
            return 1;
        }
        if(ind1 == 0){
            return 0;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
            return dp[ind1][ind2] = subsequenceCountingMemo(ind1-1,ind2-1,s1,s2,dp) + subsequenceCountingMemo(ind1-1,ind2,s1,s2,dp);
        }else{
            return dp[ind1][ind2] = subsequenceCountingMemo(ind1-1,ind2,s1,s2,dp);
        }
    }
     */
    static int subsequenceCountingTab(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i <= n ; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j <= m; j++) {
             dp[0][j] = 0;
        }
        for (int i = 1; i <=n ; i++) {
            for (int j = 1; j <= m ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return  dp[n][m];
    }
    static int subsequenceCountingTabSpace(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        prev[0] = 1;
        for (int i = 1; i <=n ; i++) {
            int[] curr = new int[m+1];
            curr[0] = 1;
            for (int j = 1; j <= m ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    curr[j] = prev[j-1] + prev[j];
                }else{
                    curr[j] = prev[j];
                }
            }
            prev = curr;
        }
        return  prev[m];
    }

}
