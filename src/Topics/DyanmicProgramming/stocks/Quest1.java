package Topics.DyanmicProgramming.stocks;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
public class Quest1 {
    public static void main(String[] args) {
        int n = 6;
        int[] Arr = {7, 1, 5, 3, 6, 4};

        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated is " + getMaximumProfitRecursion(Arr, n));
    }
    static int getMaximumProfitRecursion(int[] arr,int n){
      return getMaximumProfitRecursion(0,0,arr,n);
    }
    static int getMaximumProfitRecursion(int ind,int buy,int[] arr,int n){
         if(ind == n){
             return 0;
         }
         int op1;
         int op2;
        if(buy == 0){
         //no buy
         op1  =  getMaximumProfitRecursion(ind+1,0,arr,n);
         //buy = - because we invested
         op2 =   -arr[ind] + getMaximumProfitRecursion(ind+1,1,arr,n);
        }else{
            //no sell
           op1 =  getMaximumProfitRecursion(ind+1,1,arr,n);
           //sell
           op2 = arr[ind] + getMaximumProfitRecursion(ind+1,0,arr,n);
        }
        return  Math.max(op1,op2);
    }
    static int getMaximumProfitMemo(int[] arr,int n){
        int[][] dp = new int[n][2];
        for (int [] a: dp) {
            Arrays.fill(a,-1);
        }
        return getMaximumProfitMemo(0,0,arr,n,dp);
    }
    static int getMaximumProfitMemo(int ind,int buy,int[] arr,int n,int[][] dp){
        if(ind == n){
            return 0;
        }
        int op1;
        int op2;
        if(dp[ind][buy] != -1){
            return dp[ind][buy];
        }
        if(buy == 0){
            //no buy
            op1  =  getMaximumProfitMemo(ind+1,0,arr,n,dp);
            //buy = - because we invested
            op2 =   -arr[ind] + getMaximumProfitMemo(ind+1,1,arr,n,dp);
        }else{
            //no sell
            op1 =  getMaximumProfitMemo(ind+1,1,arr,n,dp);
            //sell
            op2 = arr[ind] + getMaximumProfitMemo(ind+1,0,arr,n,dp);
        }
        return dp[ind][buy] = Math.max(op1,op2);
    }
    static int getMaximumProfitTab(int[] arr,int n){
        int[][] dp = new int[n+1][2];
        dp[n][0] = dp[n][1] = 0;
        for (int ind = n-1 ; ind >= 0 ; ind--) {
            for (int buy = 0; buy <=1 ; buy++) {
                int op1;
                int op2;
                if(buy == 0){
                    //no buy
                    op1  =  dp[ind+1][0];
                    //buy = - because we invested
                    op2 =   - arr[ind] + dp[ind+1][1];
                }else{
                    //no sell
                    op1 =  dp[ind+1][1];
                    //sell
                    op2 = arr[ind] + dp[ind+1][0];
                }
                dp[ind][buy] = Math.max(op1,op2);
            }
        }
        return dp[0][0];
    }
    static int getMaximumProfitspace(int[] arr,int n){
        int[] ahead =new int[2];
        ahead[0] = ahead[1] = 0;
        for (int ind = n-1 ; ind >= 0 ; ind--) {
            int[] curr = new int[2];
            for (int buy = 0; buy <=1 ; buy++) {
                int op1;
                int op2;
                if(buy == 0){
                    //no buy
                    op1  =  ahead[0];
                    //buy = - because we invested
                    op2 =   - arr[ind] + ahead[1];
                }else{
                    //no sell
                    op1 =  ahead[1];
                    //sell
                    op2 = arr[ind] + ahead[0];
                }
                curr[buy] = Math.max(op1,op2);
            }
            ahead = curr.clone();
        }
        return ahead[0];
    }
}
