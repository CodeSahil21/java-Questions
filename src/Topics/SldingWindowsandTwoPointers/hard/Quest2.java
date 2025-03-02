package Topics.SldingWindowsandTwoPointers.hard;
import java.util.*;
//https://leetcode.com/problems/subarrays-with-k-different-integers/description/
public class Quest2 {

        public static int subarraysWithKDistinct(int[] nums, int k) {
            return atMost(nums, k) - atMost(nums, k - 1);
        }

        private static int atMost(int[] nums, int k) {
            if (k == 0) return 0;

            Map<Integer, Integer> countMap = new HashMap<>();
            int left = 0;
            int right = 0;
            int count = 0;

            while (right < nums.length) {
                countMap.put(nums[right], countMap.getOrDefault(nums[right], 0) + 1);

                while (countMap.size() > k) {
                    countMap.put(nums[left], countMap.get(nums[left]) - 1);
                    if (countMap.get(nums[left]) == 0) {
                        countMap.remove(nums[left]);
                    }
                    left++;
                }

                count += right - left + 1;
                right++;
            }

            return count;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 1, 2, 3};
            int k = 2;
            System.out.println(subarraysWithKDistinct(nums, k)); // Output: 7
        }
    }

