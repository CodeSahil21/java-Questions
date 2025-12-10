package Topics.DyanmicProgramming.Strings;

public class Quest3 {
    public static void main(String[] args) {
        String s1 = "abcjklp";
        String s2 = "acjkp";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Substring is " + lcs(s1, s2));
    }
    static int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int ans  = 0 ;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    ans = Math.max(ans,dp[i][j]);
                }
                else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }
    static int lcsSpace(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int ans  = 0 ;
        int[] prev = new int[m + 1];
        for (int i = 1; i <= n; i++) {
            int[] curr = new int[m + 1];
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                    ans = Math.max(ans,curr[j]);
                }
                else {
                    curr[j] = 0;
                }
            }
            prev = curr.clone();
        }
        return ans;
    }
}
