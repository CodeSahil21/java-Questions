package Topics.GreedyAlgo.easy;

import java.util.Arrays;

//https://leetcode.com/problems/assign-cookies/description/
public class Quest1 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s)); // Output: 1
    }

    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;  // Pointer for children
        int right = 0;  // Pointer for cookies

        while (left < g.length && right < s.length) {
            if (g[left] <= s[right]) {
                left++;
            }
            right++;
        }

        return left;
    }
}
