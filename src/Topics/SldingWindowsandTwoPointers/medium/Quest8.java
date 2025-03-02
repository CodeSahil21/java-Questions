package Topics.SldingWindowsandTwoPointers.medium;
//https://leetcode.com/problems/count-number-of-nice-subarrays/description/
public class Quest8 {
    public static void main(String[] args) {

    }

    public static  int numberOfSubarrays(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }

        return atMost(nums, k) - atMost(nums, k - 1);
    }
    private static int atMost(int[] nums, int goal) {
        if (goal < 0) return 0;

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += (nums[right] % 2);//1 | 0

            while (sum > goal) {
                sum -= (nums[left]%2);
                left++;
            }

            count += right - left + 1;
            right++;
        }

        return count;
    }
}
