package Topics.DyanmicProgramming.OneD;

import java.util.*;

//https://leetcode.com/problems/house-robber-ii/
public class Quest5 {
    public static void main(String[] args) {

    }
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        ArrayList<Integer> temp1 = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i != 0) {
                temp1.add(nums[i]);
            }
            if (i != n - 1) {
                temp2.add(nums[i]);
            }
        }

        int first = solve(temp1);
        int second = solve(temp2);

        return Math.max(first, second);
    }

    // This is the corrected dynamic programming solution for House Robber I
    private int solve(ArrayList<Integer> arr) {
        int n = arr.size();
        if (n == 0) {
            return 0;
        }

        int prev = 0;    // Represents max money robbed up to i-1
        int prev2 = 0;   // Represents max money robbed up to i-2

        for (int i = 0; i < n; i++) {
            int current = Math.max(arr.get(i) + prev2, prev);
            prev2 = prev;
            prev = current;
        }

        return prev;
    }
}
