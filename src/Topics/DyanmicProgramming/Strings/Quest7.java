package Topics.DyanmicProgramming.Strings;
//https://leetcode.com/problems/shortest-common-supersequence/
public class Quest7 {
    public static void main(String[] args) {
        String s1 = "brute";
        String s2 = "groot";

        System.out.println("The Longest Common Supersequence is "+ shortestSupersequence(s1,s2));
    }

    static String shortestSupersequence(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        // 1. Calculate the length of the Longest Common Subsequence (LCS)
        int[][] dp = new int[n + 1][m + 1];
        // dp array is automatically initialized to 0, which correctly handles base cases dp[i][0] and dp[0][j]

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // Length of SCS = |s1| + |s2| - |LCS|
        int len = n + m - dp[n][m];

        // Create a char array or StringBuilder to store the result
        // Using a char array is often slightly cleaner for reverse filling
        char[] result = new char[len];
        int index = len - 1;

        int i = n;
        int j = m;

        // 2. Backtrack to construct the SCS
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                result[index] = s1.charAt(i - 1); // Common char is added once
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                result[index] = s1.charAt(i - 1); // Take char from s1
                i--;
            } else {
                result[index] = s2.charAt(j - 1); // Take char from s2 (includes the equality case)
                j--;
            }
            index--;
        }

        // 3. Append remaining characters
        while (i > 0) {
            result[index] = s1.charAt(i - 1);
            i--;
            index--;
        }
        while (j > 0) {
            result[index] = s2.charAt(j - 1);
            j--;
            index--;
        }

        // Print the result
        return new String(result);
    }
}
