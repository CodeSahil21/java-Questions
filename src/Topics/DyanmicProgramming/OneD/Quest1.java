package Topics.DyanmicProgramming.OneD;
import java.util.*;
//https://leetcode.com/problems/climbing-stairs/description/
public class Quest1 {
    public static void main(String[] args) {
        // Test case 1
        int n1 = 2;
        int expected1 = 2;
        int actual1 = climbStairs(n1);
        System.out.println("Testing n = " + n1 + ": " + (actual1 == expected1 ? "Passed ✅" : "Failed ❌"));

        // Test case 2
        int n2 = 3;
        int expected2 = 3;
        int actual2 = climbStairs(n2);
        System.out.println("Testing n = " + n2 + ": " + (actual2 == expected2 ? "Passed ✅" : "Failed ❌"));

        // Test case 3
        int n3 = 4;
        int expected3 = 5;
        int actual3 = climbStairs(n3);
        System.out.println("Testing n = " + n3 + ": " + (actual3 == expected3 ? "Passed ✅" : "Failed ❌"));


    }
    public static int climbStairs(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        int left =  climbStairs(n-1);
        int right = climbStairs(n-2);

        return left + right;
    }
    public static int climbStairsMemo(int n, int[] dp) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        if (dp[n] != -1) return dp[n]; // already computed

        int left = climbStairsMemo(n - 1, dp);
        int right = climbStairsMemo(n - 2, dp);

        return dp[n] = left + right;
    }
    public static int climbStairsTab(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
    public static int climbStairsOptimized(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;

        int prev2 = 1; // f(0)
        int prev1 = 1; // f(1)

        for (int i = 2; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}
//try to represent the problem in terms of index
///do all possible stuff on that index according to problem statement
//coutn all the way-sum up all the ways
//min or mx(of all stuffs) -> find min and max