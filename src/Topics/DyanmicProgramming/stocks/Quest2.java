package Topics.DyanmicProgramming.stocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/description/
public class Quest2 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + maxProfitRecursion(prices));
    }
    static int maxProfitRecursion(int[] arr){
        int n = arr.length;
        return maxProfitRecursion(0,0,2,arr,n);
    }
    static int maxProfitRecursion(int ind,int buy,int cap,int[] arr,int n){
     if(ind == n || cap == 0){
         return 0;
     }
        int op1;
        int op2;
        if(buy == 0){
            //no buy
            op1  =  maxProfitRecursion(ind+1,0,cap,arr,n);
            //buy = - because we invested
            op2 =   -arr[ind] + maxProfitRecursion(ind+1,1,cap,arr,n);
        }else{
            //no sell
            op1 =  maxProfitRecursion(ind+1,1,cap,arr,n);
            //sell
            op2 = arr[ind] + maxProfitRecursion(ind+1,0,cap-1,arr,n);
        }
        return  Math.max(op1,op2);
    }
    static int maxProfitMemo(int[] arr){
        int n = arr.length;
        int[][][] dp = new int[n][2][3];
        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return maxProfitMemo(0,0,2,arr,n,dp);
    }
    static int maxProfitMemo(int ind,int buy,int cap,int[] arr,int n,int[][][] dp){
        if(ind == n || cap == 0){
            return 0;
        }
        int op1;
        int op2;
        if(dp[ind][buy][cap] != -1){
            return dp[ind][buy][cap];
        }
        if(buy == 0){
            //no buy
            op1  =  maxProfitMemo(ind+1,0,cap,arr,n,dp);
            //buy = - because we invested
            op2 =   -arr[ind] + maxProfitMemo(ind+1,1,cap,arr,n,dp);
        }else{
            //no sell
            op1 =  maxProfitMemo(ind+1,1,cap,arr,n,dp);
            //sell
            op2 = arr[ind] + maxProfitMemo(ind+1,0,cap-1,arr,n,dp);
        }
        return dp[ind][buy][cap] =  Math.max(op1,op2);
    }

    static int maxProfitTab(int[] arr){
        int n = arr.length;
        int[][][] dp = new int[n+1][2][3];
//        for (int ind = 0; ind < n-1; ind++) {
//            for (int buy = 0; buy <=1 ; buy++) {
//                dp[ind][buy][0] = 0;
//            }
//        }
//        for (int buy = 0; buy <= 1 ; buy++) {
//            for (int cap = 0; cap < 2; cap++) {
//                dp[n][buy][cap] = 0;
//            }
//        }
        for (int ind = n-1; ind >= 0 ; ind--) {
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int op1;
                    int op2;
                    if(buy == 0){
                        //no buy
                        op1  =  dp[ind+1][0][cap];
                        //buy = - because we invested
                        op2 =   -arr[ind] + dp[ind+1][1][cap];
                    }else{
                        //no sell
                        op1 =  dp[ind+1][1][cap];
                        //sell
                        op2 = arr[ind] + dp[ind+1][0][cap-1];
                    }
                     dp[ind][buy][cap] =  Math.max(op1,op2);
                }
            }
        }
     return dp[0][0][2];
    }
    static int maxProfitTabSpace(int[] arr){
        int n = arr.length;
        int[][] ahead = new int[2][3];
//        for (int ind = 0; ind < n-1; ind++) {
//            for (int buy = 0; buy <=1 ; buy++) {
//                dp[ind][buy][0] = 0;
//            }
//        }
//        for (int buy = 0; buy <= 1 ; buy++) {
//            for (int cap = 0; cap < 2; cap++) {
//                dp[n][buy][cap] = 0;
//            }
//        }
        for (int ind = n-1; ind >= 0 ; ind--) {
            int[][] curr = new int[2][3];
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int op1;
                    int op2;
                    if(buy == 0){
                        //no buy
                        op1  =  ahead[0][cap];
                        //buy = - because we invested
                        op2 =   -arr[ind] + ahead[1][cap];
                    }else{
                        //no sell
                        op1 =  ahead[1][cap];
                        //sell
                        op2 = arr[ind] + ahead[0][cap-1];
                    }
                    curr[buy][cap] =  Math.max(op1,op2);
                }
            }
            ahead = curr.clone();
        }
        return ahead[0][2];
    }


}
