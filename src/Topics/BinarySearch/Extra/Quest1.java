package Topics.BinarySearch.Extra;

public class Quest1 {





        public int minimizeArrayValue(int[] nums) {
            // Range for binary search
            // Low: 0, High: Max possible value in array (roughly 10^9)
            long left = 0, right = 0;
            for (int n : nums) {
                right = Math.max(right,n);
            }
            long ans = right;

            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (isPossible(nums, mid)) {
                    ans = mid;      // mid is feasible, try smaller
                    right = mid - 1;
                } else {
                    left = mid + 1; // mid is too small, try larger
                }
            }
            return (int) ans;
        }

        // Helper function to check if we can make all elements <= maxVal
        private boolean isPossible(int[] nums, long maxVal) {
            long[] arr = new long[nums.length];

            // Copy to avoid modifying original array
            for(int i=0; i<nums.length; i++) arr[i] = nums[i];

            // Process from right to left
            for (int i = arr.length - 1; i > 0; i--) {
                if (arr[i] > maxVal) {
                    long excess = arr[i] - maxVal;
                    arr[i-1] += excess; // Move excess to the left neighbor
                }
            }
            // If index 0 is still within limit, it's possible
            return arr[0] <= maxVal;
        }

    public int minimizeArrayValueON(int[] nums) {
        long sum = 0;
        long result = 0;

        for (int i = 0; i < nums.length; i++) {
            // Add current number to running sum
            sum += nums[i];

            // Calculate the ceiling average of the prefix sum:
            // average = ceil(sum / (i + 1))
            // Formula for integer ceil(a/b) is (a + b - 1) / b
            long average = (sum + i) / (i + 1);

            // Update the global maximum required
            result = Math.max(result, average);
        }

        return (int) result;
    }

}
