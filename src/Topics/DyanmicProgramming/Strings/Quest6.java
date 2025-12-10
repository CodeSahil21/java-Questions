package Topics.DyanmicProgramming.Strings;
//https://leetcode.com/problems/delete-operation-for-two-strings/description/
public class Quest6 {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "anc";
        System.out.println("The Minimum operations required to convert str1 to str2: "
                + canYouMake(str1, str2));
    }
    static int canYouMake(String s1,String s2){
        int n = s1.length();
        int m = s2.length();
        int lcs = lcsTabulation2(s1,s2);
        int operations = n + m - (2*lcs);
        return operations;
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
