package Topics.DyanmicProgramming.Sequences;
import java.util.*;
public class Quest10 {
    public static void main(String[] args) {
        int[] wt = { 2, 4, 6 };
        int[] val = { 5, 11, 13 };
        int W = 10;

        int n = wt.length;

        // Call the unboundedKnapsack function and print the result
        System.out.println("The Maximum value of items, the thief can steal is " + unboundedKnapsackRecursion(n, W, val, wt));
    }
    static int unboundedKnapsackRecursion(int n,int W,int[] val,int[] wt){
        return unboundedKnapsackRecursionC(n-1,W,n,val,wt);
    }
    static int unboundedKnapsackRecursionC(int ind,int W,int n,int[] val,int[] wt){
        if(ind == 0){
            return ( W/wt[0])*val[0];
        }
        int notTake = unboundedKnapsackRecursionC(ind-1,W,n,val,wt);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + unboundedKnapsackRecursionC(ind,W- wt[ind],n,val,wt);
        }
        return  Math.max(take ,notTake);
    }
    static int unboundedKnapsackMemo(int n,int W,int[] val,int[] wt){
        int[][] dp = new int[n][W+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return unboundedKnapsackMemo(n-1,W,n,val,wt,dp);
    }
    static int unboundedKnapsackMemo(int ind,int W,int n,int[] val,int[] wt,int[][] dp){
        if(ind == 0){
            return ( W/wt[0])*val[0];
        }
        if(dp[ind][W] != -1){
            return dp[ind][W];
        }
        int notTake = unboundedKnapsackMemo(ind-1,W,n,val,wt,dp);
        int take = Integer.MIN_VALUE;
        if(wt[ind] <= W){
            take = val[ind] + unboundedKnapsackMemo(ind,W- wt[ind],n,val,wt,dp);
        }
        return dp[ind][W] = Math.max(take ,notTake);
    }

    static int unboundedKnapsackTabulation(int n,int W,int[] val,int[] wt){
        int[][] dp = new int[n][W+1];
        for(int w = 0 ; w <= W;w++){
            dp[0][w] = (w/wt[0])*val[0];
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int w = 0; w <= W ; w++) {
                int notTake = dp[ind-1][w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= W){
                    take = val[ind] + dp[ind][w-wt[ind]];
                }
                dp[ind][w] = Math.max(take,notTake);
            }
        }
        return dp[n-1][W];
    }

    static int unboundedKnapsackTabulationSpace(int n,int W,int[] val,int[] wt){
        int[] prev = new int[W+1];
        int[] curr = new int[W+1];
        for(int w = 0 ; w <= W;w++){
            prev[w] = (w/wt[0])*val[0];
        }
        for (int ind = 1; ind < n ; ind++) {
            for (int w = 0; w <= W ; w++) {
                int notTake = prev[w];
                int take = Integer.MIN_VALUE;
                if(wt[ind] <= W){
                    take = val[ind] + curr[w-wt[ind]];
                }
                curr[w] = Math.max(take,notTake);
            }
            prev = curr.clone();
        }
        return curr[W];
    }
}
