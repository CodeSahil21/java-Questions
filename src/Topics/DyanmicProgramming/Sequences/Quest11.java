package Topics.DyanmicProgramming.Sequences;

import java.util.Arrays;

//https://takeuforward.org/data-structure/rod-cutting-problem-dp-24/
public class Quest11 {
    public static void main(String[] args) {
        // Rod Lengths (items/weights) and Prices (values)
        int[] availableLengths = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        int totalRodLength = 8;

        int n = availableLengths.length;

        System.out.println("Max Profit (Recursion): " + rodCuttingRecursion(n, totalRodLength, prices, availableLengths));
        System.out.println("Max Profit (Memoization): " + rodCuttingMemo(n, totalRodLength, prices, availableLengths));
        System.out.println("Max Profit (Tabulation): " + rodCuttingTabulation(n, totalRodLength, prices, availableLengths));
        System.out.println("Max Profit (Space-Optimized): " + rodCuttingTabulationSpace(n, totalRodLength, prices, availableLengths));
    }

    // --- 1. Pure Recursion (Brute Force) ---
    static int rodCuttingRecursion(int n, int N, int[] price, int[] length) {
        return rodCuttingRecursionC(n - 1, N, n, price, length);
    }

    static int rodCuttingRecursionC(int ind, int currentLength, int n, int[] price, int[] length) {
        if (ind == 0) {
            return (currentLength / length[0]) * price[0];
        }
        int notCut = rodCuttingRecursionC(ind - 1, currentLength, n, price, length);
        int makeCut = Integer.MIN_VALUE;
        if (length[ind] <= currentLength) {
            makeCut = price[ind] + rodCuttingRecursionC(ind, currentLength - length[ind], n, price, length);
        }
        return Math.max(makeCut, notCut);
    }

    // --- 2. Memoization (Top-Down DP) ---
    static int rodCuttingMemo(int n, int N, int[] price, int[] length) {
        int[][] dp = new int[n][N + 1];
        for (int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return rodCuttingMemoC(n - 1, N, n, price, length, dp);
    }

    static int rodCuttingMemoC(int ind, int currentLength, int n, int[] price, int[] length, int[][] dp) {
        if (ind == 0) {
            return (currentLength / length[0]) * price[0];
        }
        if (dp[ind][currentLength] != -1) {
            return dp[ind][currentLength];
        }

        int notCut = rodCuttingMemoC(ind - 1, currentLength, n, price, length, dp);
        int makeCut = Integer.MIN_VALUE;
        if (length[ind] <= currentLength) {
            makeCut = price[ind] + rodCuttingMemoC(ind, currentLength - length[ind], n, price, length, dp);
        }

        return dp[ind][currentLength] = Math.max(makeCut, notCut);
    }

    // --- 3. Tabulation (Bottom-Up DP) ---
    static int rodCuttingTabulation(int n, int N, int[] price, int[] length) {
        int[][] dp = new int[n][N + 1];

        for (int l = 0; l <= N; l++) {
            dp[0][l] = (l / length[0]) * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int l = 0; l <= N; l++) {

                int notCut = dp[ind - 1][l];
                int makeCut = Integer.MIN_VALUE;
                if (length[ind] <= l) {
                    makeCut = price[ind] + dp[ind][l - length[ind]];
                }

                dp[ind][l] = Math.max(makeCut, notCut);
            }
        }

        return dp[n - 1][N];
    }

    // --- 4. Space-Optimized Tabulation (O(N) Space) ---
    static int rodCuttingTabulationSpace(int n, int N, int[] price, int[] length) {
        int[] prev = new int[N + 1];
        int[] curr = new int[N + 1];

        for (int l = 0; l <= N; l++) {
            prev[l] = (l / length[0]) * price[0];
        }

        for (int ind = 1; ind < n; ind++) {
            for (int l = 0; l <= N; l++) {

                int notCut = prev[l];
                int makeCut = Integer.MIN_VALUE;
                if (length[ind] <= l) {
                    makeCut = price[ind] + curr[l - length[ind]];
                }

                curr[l] = Math.max(makeCut, notCut);
            }

            // Update prev for the next item's iteration
            prev = curr.clone();
        }

        return prev[N];
    }

}
