package Topics.Arrays.Extra;

public class Quest2 {


    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int minLen = Integer.MAX_VALUE;

        // Iterate over every starting point
        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            // Iterate over every ending point
            for (int j = i; j < n; j++) {
                currentSum += nums[j];

                // Once we hit the target, record length and break
                // (no need to make this subarray longer)
                if (currentSum >= target) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

    public int minSubArrayLenON(int target, int[] nums) {
        int left = 0;
        int currentSum = 0;
        int minLen = Integer.MAX_VALUE;

        // 'right' is our fast pointer exploring new elements
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];

            // While the window is valid, try to make it smaller
            while (currentSum >= target) {
                // Check if this is the new smallest length
                minLen = Math.min(minLen, right - left + 1);

                // Shrink the window from the left
                currentSum -= nums[left];
                left++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }

}
