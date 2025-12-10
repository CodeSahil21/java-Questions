package Topics.DyanmicProgramming.Strings;

import java.util.Arrays;

public class Quest1 {
    public static void main(String[] args) {
        String s1 = "acd";
        String s2 = "ced";

        // Call the lcs function and print the result
        System.out.println("The Length of Longest Common Subsequence is " + lcsReursion(s1, s2));
    }
    static int lcsReursion(String s1, String s2){
       return f(s1,s2,s1.length()-1,s2.length()-1);
    }
    static int f(String S1, String S2, int ind1, int ind2) {

        // Base Case (Termination)
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }

        // Case 1: Characters Match
        if (S1.charAt(ind1) == S2.charAt(ind2)) {
            // Match: Count it (1) and recurse on the reduced problem (ind1-1, ind2-1)
            return 1 + f(S1, S2, ind1 - 1, ind2 - 1);
        }

        // Case 2: Characters Do Not Match
        else {
            // Mismatch: Recurse on two paths (skipping ind2 or skipping ind1) and take the maximum length.
            return Math.max(f(S1, S2, ind1, ind2 - 1),
                    f(S1, S2, ind1 - 1, ind2));
        }
    }

    static int lcsMemo(String s1, String s2){
        int[][] dp = new int[s1.length()][s2.length()];
        for (int[] arr : dp) {
            Arrays.fill(arr,-1);
        }
        return fMemo(dp,s1,s2,s1.length()-1,s2.length()-1);
    }
    static int fMemo(int[][] dp,String S1, String S2, int ind1, int ind2) {

        // Base Case (Termination)
        if (ind1 < 0 || ind2 < 0) {
            return 0;
        }
         if(dp[ind1][ind2] != -1){
             return dp[ind1][ind2];
         }
        // Case 1: Characters Match
        if (S1.charAt(ind1) == S2.charAt(ind2)) {
            // Match: Count it (1) and recurse on the reduced problem (ind1-1, ind2-1)
            return dp[ind1][ind2] = 1 + fMemo(dp,S1, S2, ind1 - 1, ind2 - 1);
        }

        // Case 2: Characters Do Not Match
        else {
            // Mismatch: Recurse on two paths (skipping ind2 or skipping ind1) and take the maximum length.
            return dp[ind1][ind2] = Math.max(fMemo(dp,S1, S2, ind1, ind2 - 1), fMemo(dp,S1, S2, ind1 - 1, ind2));
        }
    }
    /*
        static int lcsMemo(String s1, String s2){
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        for (int[] arr : dp) {
            Arrays.fill(arr,-1);
        }
        return fMemo(dp,s1,s2,s1.length(),s2.length());
    }
    static int fMemo(int[][] dp,String S1, String S2, int ind1, int ind2) {

        // Base Case (Termination)
        if (ind1 == 0 || ind2 == 0) {
            return 0;
        }
         if(dp[ind1][ind2] != -1){
             return dp[ind1][ind2];
         }
        // Case 1: Characters Match
        if (S1.charAt(ind1-1) == S2.charAt(ind2-1)) {
            // Match: Count it (1) and recurse on the reduced problem (ind1-1, ind2-1)
            return dp[ind1][ind2] = 1 + fMemo(dp,S1, S2, ind1 - 1, ind2 - 1);
        }

        // Case 2: Characters Do Not Match
        else {
            // Mismatch: Recurse on two paths (skipping ind2 or skipping ind1) and take the maximum length.
            return dp[ind1][ind2] = Math.max(fMemo(dp,S1, S2, ind1, ind2 - 1), fMemo(dp,S1, S2, ind1 - 1, ind2));
        }
    }
     */
    static int lcsTabulationSpace(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n < m) {
            return lcsTabulationSpace(s2, s1);
        }

        int[] prev = new int[m + 1];
        int[] curr = new int[m + 1];

        for (int j = 0; j < m; j++) {
            prev[j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                }
                else {
                    curr[j] = Math.max(prev[j], curr[j - 1]);
                }
            }
            System.arraycopy(curr, 0, prev, 0, m + 1);
        }

        return prev[m];
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
