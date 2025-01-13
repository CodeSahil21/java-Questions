package Topics.BitManipulation.sub2;
//https://leetcode.com/problems/subsets/
import java.util.*;
public class Quest2 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subsets = generateSubsets(nums);
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
    public static List<List<Integer>> generateSubsets(int[] nums) {
        int subsets = 1 << nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < subsets; num++) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if ((num & (1 << i)) != 0) {
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}


