package Topics.DyanmicProgramming.stocks;
import java.util.*;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/
public class Quest4 {
    public static void main(String[] args) {

    }
    static int getAns(int[] Arr, int ind, int buy, int n, int[][] dp) {
        if (ind >= n) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;

        if (buy == 0) {
            int skip = getAns(Arr, ind + 1, 0, n, dp);
            int buyStock = -Arr[ind] + getAns(Arr, ind + 1, 1, n, dp);

            profit = Math.max(skip, buyStock);
        }

        if (buy == 1) {
            int skip = getAns(Arr, ind + 1, 1, n, dp);
            int sellStock = Arr[ind] + getAns(Arr, ind + 2, 0, n, dp);

            profit = Math.max(skip, sellStock);
        }

        return dp[ind][buy] = profit;
    }

    public int stockProfit(int[] Arr) {
        int n = Arr.length;

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int ans = getAns(Arr, 0, 0, n, dp);
        return ans;
    }

    public static int stockProfitTab(int[] Arr) {
        int n = Arr.length;

        // DP array size must be [n+2][2] to safely access dp[ind+2]
        // for the cooldown day (i.e., dp[n] and dp[n+1] are base cases).
        int[][] dp = new int[n + 2][2];

        // Base Cases (ind = n and ind = n+1):
        // dp[n][any] = 0 and dp[n+1][any] = 0.
        // Java initializes integer arrays to 0, so no explicit initialization is needed.

        // Loop backward from the last possible transaction day (n-1) to the first day (0)
        for (int ind = n - 1; ind >= 0; ind--) {
            // Loop through the two possible states: 0 (Can Buy) and 1 (Holding Stock)
            for (int buy = 0; buy <= 1; buy++) {

                int op1; // Option 1: Skip/No Transaction
                int op2; // Option 2: Transact (Buy or Sell)

                if (buy == 0) { // State: Can Buy
                    // No Buy (Skip): Profit from next day, state remains 0.
                    op1 = dp[ind + 1][0];

                    // Buy: Cost -Arr[ind] + profit from next day, state changes to 1.
                    op2 = -Arr[ind] + dp[ind + 1][1];

                    dp[ind][buy] = Math.max(op1, op2);
                } else { // State: Holding Stock (Can Sell)
                    // No Sell (Skip): Profit from next day, state remains 1.
                    op1 = dp[ind + 1][1];

                    // Sell: Gain +Arr[ind] + profit from day (ind+2), state changes to 0.
                    // The ind+2 lookup handles the one-day cooldown.
                    op2 = Arr[ind] + dp[ind + 2][0];

                    dp[ind][buy] = Math.max(op1, op2);
                }
            }
        }

        // The result is the max profit starting from Day 0, in the Can Buy state (0).
        return dp[0][0];
    }

}
