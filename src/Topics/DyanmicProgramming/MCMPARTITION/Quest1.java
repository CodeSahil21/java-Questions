package Topics.DyanmicProgramming.MCMPARTITION;

import java.util.Arrays;

public class Quest1 {
    //MCM->matrix chain Multiplication
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};

        int n = arr.length;

        System.out.println("The minimum number of operations are "+
                matrixMultiplication(arr,n));
    }
    static  int matrixMultiplication(int[] arr,int n){
        return MCM(1,n-1,arr,n);
    }
    static  int MCM(int i,int j,int[] arr,int n){
       if(i == j){
           return 0;
       }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j ; k++) {
        int steps  = arr[i-1] * arr[k] * arr[j] + MCM(i,k,arr,n) + MCM(k+1,j,arr,n) ;
        mini = Math.min(mini,steps);
        }
        return mini;
    }
    static  int matrixMultiplicationMemo(int[] arr,int n){
        int[][] dp = new int[n][n];
        for(int[] a:dp){
            Arrays.fill(a,-1);
        }
        return MCM(1,n-1,arr,n);
    }
    static  int MCMMEmo(int i,int j,int[] arr,int n,int[][] dp){
        if(i == j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini = Integer.MAX_VALUE;
        for (int k = i; k < j ; k++) {
            int steps  = arr[i-1] * arr[k] * arr[j] + MCMMEmo(i,k,arr,n,dp) + MCMMEmo(k+1,j,arr,n,dp) ;
            mini = Math.min(mini,steps);
        }
        return dp[i][j] = mini;
    }
    static  int matrixMultiplicationTab(int[] arr,int n){
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
        }

        //since j is always  be  right of i hence we write i+1 instead of j = 0;
        for (int i = n-1; i >= 1 ; i--) {
            for (int j = i+1; j < n ; j++) {
                int mini = Integer.MAX_VALUE;
                for (int k = i; k < j ; k++) {
                    int steps = arr[i-1]*arr[k]*arr[j] + dp[i][k] + dp[k+1][j];
                    mini = Math.min(mini,steps);
                }
                dp[i][j] = mini;
            }
        }
        return dp[1][n-1];
    }
}
/*
generally in all problems you will have an array
in which you have to try out with i as starting point and j as ending point hence k partitont whcih can be anywhere between them  and out of all these partition which ever yield you best solution you have to tell us that

how to solve
1)start with entire block/array f(i,j) where i is start point and j is end point
2)try all partitions
3)return best possible 2 partitions

 */