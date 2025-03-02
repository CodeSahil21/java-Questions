package Topics.SldingWindowsandTwoPointers.medium;
//https://leetcode.com/problems/binary-subarrays-with-sum/description/
public class Quest7 {
    public static void main(String[] args) {

    }
    public static int numSubarraysWithSum(int[] nums, int goal) {
        if (goal < 0) {
            return 0;
        }

        return atMost(nums, goal) - atMost(nums, goal - 1);
    }

    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }

}
