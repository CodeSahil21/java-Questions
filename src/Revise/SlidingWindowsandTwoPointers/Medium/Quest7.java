package Revise.SlidingWindowsandTwoPointers.Medium;

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

    public int subarraySum(int[] nums, int k) {
        // A null or empty array has no subarrays.
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int count = 0;
        int n = nums.length;

        // 1. The outer loop picks the starting index 'i' of a subarray.
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // 2. The inner loop picks the ending index 'j' of a subarray.
            for (int j = i; j < n; j++) {
                // 3. Add the current element to the sum for the subarray [i...j].
                currentSum += nums[j];

                // 4. If the sum equals k, we found a valid subarray.
                if (currentSum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
