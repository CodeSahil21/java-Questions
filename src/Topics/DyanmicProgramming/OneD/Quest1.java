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
            return 0;
        }
        int left =  climbStairs(n-1);
        int right = climbStairs(n-2);

        return left + right;
    }
    public int climbStairs(int n, int[] memo) {
        if (memo[n] != 0) {
            return memo[n];
        }

        if (n == 1) {
            memo[n] = 1;
            return 1;
        }
        if (n == 2) {
            memo[n] = 2;
            return 2;
        }

        // Compute the result and store it
        memo[n] = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);

        // Return the stored result
        return memo[n];
    }
    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        }

        int prev1 = 2; // Ways to climb 2 stairs
        int prev2 = 1; // Ways to climb 1 stair
        int current = 0;

        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }
}
//try to represent the problem in terms of index
///do all possible stuff on that index according to problem statement
//coutn all the way-sum up all the ways
//min or mx(of all stuffs) -> find min and max