package Topics.DyanmicProgramming.MCMPARTITION;

import java.util.Arrays;

//https://leetcode.com/problems/palindrome-partitioning-ii/
public class Quest5 {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println("Minimum cuts needed: " + minCutMemo(s));
    }

    public static int minCut(String s) {
        return minCutsHelper(s, 0);
    }
    private static boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    private static int minCutsHelper(String s, int start) {
        int n = s.length();

        if (start == n)
            return 0;

        if (isPalindrome(s, start, n - 1))
            return 0;

        int minCuts = Integer.MAX_VALUE;

        for (int end = start; end < n; end++) {
            if (isPalindrome(s, start, end)) {

                int cuts = 1 + minCutsHelper(s, end + 1);

                minCuts = Math.min(minCuts, cuts);
            }
        }

        return minCuts;
    }
    public static int minCutMemo(String s) {
        int[] dp = new int[s.length()];
        Arrays.fill(dp, -1);
        return minCutsHelperMemo(s, 0,dp);
    }

    private static int minCutsHelperMemo(String s, int start,int[] dp) {
        int n = s.length();

        if (start == n)
            return 0;
        if(dp[start] != -1){
            return  dp[start];
        }
        if (isPalindrome(s, start, n - 1))
            return 0;

        int minCuts = Integer.MAX_VALUE;

        for (int end = start; end < n; end++) {
            if (isPalindrome(s, start, end)) {

                int cuts = 1 + minCutsHelperMemo(s, end + 1,dp);

                minCuts = Math.min(minCuts, cuts);
            }
        }

        return dp[start] =  minCuts;
    }
    public static int minCutTab(String s) {
        int n = s.length();
        int[] dp = new int[n+1];
        dp[n] = 0;
        for (int i = n-1; i >= 0 ; i--) {
            int minCuts = Integer.MAX_VALUE;

            for (int end = i; end < n; end++) {
                if (isPalindrome(s, i, end)) {

                    int cuts = 1 +dp[end+1];

                    minCuts = Math.min(minCuts, cuts);
                }
            }
            dp[i] = minCuts;
        }
        return dp[0]-1;//since it also call for i == n ex ABC it also does for c next partiton
    }
}
