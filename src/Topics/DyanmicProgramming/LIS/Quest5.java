package Topics.DyanmicProgramming.LIS;

import java.util.Arrays;
import java.util.Comparator;

//https://leetcode.com/problems/longest-string-chain/description/
public class Quest5 {
    public static void main(String[] args) {
       String[] str = {"a", "b", "ba", "bca", "bda", "bdca"};
        int result = longestStrChain(str);
        System.out.println("Length of the Longest String Chain: " + result);
    }
    static int longestStrChain(String[] arr) {
        int n = arr.length;

        // 3. Sort the array by string length using Arrays.sort()
        Arrays.sort(arr, comp);

        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxi = 1;

        for (int i = 0; i < n; i++) {
            for (int prevIndex = 0; prevIndex < i; prevIndex++) {
                // 4. Access elements using array indexing instead of List.get()
                if (compare(arr[i], arr[prevIndex]) && 1 + dp[prevIndex] > dp[i]) {
                    dp[i] = 1 + dp[prevIndex];
                }
            }

            if (dp[i] > maxi) {
                maxi = dp[i];
            }
        }

        return maxi;
    }
    static boolean compare(String s1, String s2) {
        if (s1.length() != s2.length() + 1) {
            return false;
        }

        int first = 0;
        int second = 0;

        while (first < s1.length()) {
            if (second < s2.length() && s1.charAt(first) == s2.charAt(second)) {
                first++;
                second++;
            } else {
                first++;
            }
        }

        return first == s1.length() && second == s2.length();
    }
    static Comparator<String> comp = (s1, s2) -> s1.length() - s2.length();
}
