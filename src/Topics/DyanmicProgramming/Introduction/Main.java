package Topics.DyanmicProgramming.Introduction;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(f(n, dp));
    }

    //memoization:Memoization is a technique where you store the results of expensive function calls and reuse them when the same inputs occur again—so you don’t recalculate.
    public static int f(int n, int[] dp) {
        if (n <= 1) return n;
        if (dp[n] != -1) {
            return dp[n];
        }
        dp[n] = f(n - 1, dp) + f(n - 2, dp);
        return dp[n];
    }
//Tabulation is a bottom-up dynamic programming technique where you build a table (usually an array) from the base cases upward to solve a problem iteratively—no recursion needed.
    public static int tabulation(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int prev2 = 0;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            int cur = prev + prev2;
            prev2 = prev;
            prev = cur;
        }

        return prev;
    }
}
