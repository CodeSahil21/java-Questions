package Topics.Arrays.Extra;
import java.util.*;
//https://leetcode.com/problems/squares-of-a-sorted-array/
public class Quest3 {

    public int[] sortedSquares(int[] nums) {
        // Step 1: Square each element
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // Step 2: Sort the array
        Arrays.sort(nums);

        return nums;
    }

    public int[] sortedSquaresON(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // We fill the result array from the end (highest index) to the start
        for (int i = n - 1; i >= 0; i--) {
            int val1 = nums[left];
            int val2 = nums[right];

            // Compare absolute values to see which square will be larger
            if (Math.abs(val1) > Math.abs(val2)) {
                result[i] = val1 * val1;
                left++;
            } else {
                result[i] = val2 * val2;
                right--;
            }
        }

        return result;
    }
}
