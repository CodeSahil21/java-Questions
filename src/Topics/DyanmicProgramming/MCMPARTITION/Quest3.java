package Topics.DyanmicProgramming.MCMPARTITION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/burst-balloons/
public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 5, 4};
        int ans = maxCoinsTab(arr);
        System.out.println(ans);
    }
    static  int maxCoinsRecursion(int[] arr){
        int n = arr.length;
        List<Integer>  balloon = new ArrayList<>();
        balloon.add(1);
        for(int a:arr){
            balloon.add(a);
        }
        balloon.add(1);
        return maxCoinsRecursion(1,n,balloon);
    }
    static int maxCoinsRecursion(int i,int j,List<Integer>  balloon){
        if(i > j ) {
            return 0;
        }
        int maxi = Integer.MIN_VALUE;
       for (int ind = i ; ind <= j;ind++){
          int cost = balloon.get(i-1)* balloon.get(ind)*balloon.get(j+1) + maxCoinsRecursion(i,ind-1,balloon) + maxCoinsRecursion(ind+1,j,balloon);
           maxi = Math.max(maxi,cost);
       }
    return maxi;
    }

    static  int maxCoinsMemo(int[] arr){
        int n = arr.length;
        List<Integer>  balloon = new ArrayList<>();
        balloon.add(1);
        for(int a:arr){
            balloon.add(a);
        }
        balloon.add(1);
        int[][] dp = new int[n+1][n+1];
        for (int[] a : dp ) {
            Arrays.fill(a,-1);
        }
        return maxCoinsMemo(1,n,balloon,dp);
    }
    static int maxCoinsMemo(int i,int j,List<Integer>  balloon,int[][] dp){
        if(i > j ) {
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxi = Integer.MIN_VALUE;
        for (int ind = i ; ind <= j;ind++){
            int cost = balloon.get(i-1)* balloon.get(ind)*balloon.get(j+1) + maxCoinsMemo(i,ind-1,balloon,dp) + maxCoinsMemo(ind+1,j,balloon,dp);
            maxi = Math.max(maxi,cost);
        }
        return dp[i][j] = maxi;
    }
    static  int maxCoinsTab(int[] arr){
        int n = arr.length;
        List<Integer>  balloon = new ArrayList<>();
        balloon.add(1);
        for(int a:arr){
            balloon.add(a);
        }
        balloon.add(1);
        int[][] dp = new int[n+2][n+2];
        for (int i = n; i >= 1 ; i--) {
            for (int j = 1; j <= n ; j++) {
                if(i > j){
                    continue;
                }
                int maxi = Integer.MIN_VALUE;
                for (int ind = i; ind <= j ; ind++) {
                    int cost = balloon.get(i-1)* balloon.get(ind)*balloon.get(j+1) + dp[i][ind-1] + dp[ind+1][j];
                    maxi = Math.max(maxi,cost);
                }
                dp[i][j] = maxi;
            }
        }
        return dp[1][n];
    }
}
