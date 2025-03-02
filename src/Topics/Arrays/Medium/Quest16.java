package Topics.Arrays.Medium;

import java.util.*;

//https://leetcode.com/problems/longest-consecutive-sequence/editorial/
//longest-consecutive-sequence
public class Quest16 {
    public static void main(String[] args) {
        int[] a = {100, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
    public static int longestConsecutive(int[] a) {
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        Set<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;
    }
    public static int longestSuccessiveElements(int[] nums) {
          if(nums.length == 0){
              return -1;
          }
        Arrays.sort(nums);
          int  lastSmaller = Integer.MIN_VALUE;
          int cnt = 0;
          int longest = 1;
          for(int i = 0; i< nums.length;i++){
              if(nums[i] -1 == lastSmaller){
                  cnt += 1;
                  lastSmaller = nums[i];
              }else if(nums[i] != lastSmaller){
                  cnt = 1;
                  lastSmaller = nums[i];
              }
              longest = Math.max(longest,cnt);
          }
          return longest;
    }
}
