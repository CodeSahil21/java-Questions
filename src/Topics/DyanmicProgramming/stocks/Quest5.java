package Topics.DyanmicProgramming.stocks;
import java.util.*;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/
public class Quest5 {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2, 8, 4, 9};
        int n = prices.length;
        int fee = 2;

        System.out.println("The maximum profit that can be generated is " + maxProfitMemo(n, fee, prices));
    }
    private static int getMaxProfitMemoHelper(int[] Arr, int ind, int buy, int n, int fee, int[][] dp) {
        if (ind == n) {
            return 0;
        }

        if (dp[ind][buy] != -1) {
            return dp[ind][buy];
        }

        int profit = 0;

        if (buy == 0) {
            int skip = getMaxProfitMemoHelper(Arr, ind + 1, 0, n, fee, dp);
            int buyStock = -Arr[ind] + getMaxProfitMemoHelper(Arr, ind + 1, 1, n, fee, dp);

            profit = Math.max(skip, buyStock);
        } else {
            int skip = getMaxProfitMemoHelper(Arr, ind + 1, 1, n, fee, dp);
            int sellStock = Arr[ind] - fee + getMaxProfitMemoHelper(Arr, ind + 1, 0, n, fee, dp);

            profit = Math.max(skip, sellStock);
        }

        return dp[ind][buy] = profit;
    }

    public static int maxProfitMemo(int n, int fee, int[] Arr) {
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n][2];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return getMaxProfitMemoHelper(Arr, 0, 0, n, fee, dp);
    }

    public static int maxProfitTab(int n, int fee, int[] Arr) {
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[n + 1][2];

        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;

                if (buy == 0) {
                    profit = Math.max(dp[ind + 1][0], -Arr[ind] + dp[ind + 1][1]);
                } else {
                    profit = Math.max(dp[ind + 1][1], Arr[ind] - fee + dp[ind + 1][0]);
                }

                dp[ind][buy] = profit;
            }
        }

        return dp[0][0];
    }

    public static long maxProfitSpaceOpt(int n, int fee, int[] Arr) {
        if (n == 0) {
            return 0;
        }

        long[] ahead = new long[2];
        long[] cur = new long[2];

        for (int ind = n - 1; ind >= 0; ind--) {
            long profitIfCanBuy = Math.max(
                    ahead[0],
                    -Arr[ind] + ahead[1]
            );
            cur[0] = profitIfCanBuy;

            long profitIfHolding = Math.max(
                    ahead[1],
                    Arr[ind] - fee + ahead[0]
            );
            cur[1] = profitIfHolding;

            ahead[0] = cur[0];
            ahead[1] = cur[1];
        }

        return ahead[0];
    }
}
