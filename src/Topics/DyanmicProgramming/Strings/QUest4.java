package Topics.DyanmicProgramming.Strings;
//https://leetcode.com/problems/longest-palindromic-subsequence/
public class QUest4 {
    public static void main(String[] args) {
        String s = "bbabcbcab";
        System.out.print("The Length of Longest Palindromic Subsequence is ");
        System.out.println(longestPalindromeSubsequence(s));
    }
    static int longestPalindromeSubsequence(String s){
        String reversed = new StringBuilder(s).reverse().toString();
        return lcsTabulation2(s,reversed);
    }
    static int lcsTabulation2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
