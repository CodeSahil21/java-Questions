package Topics.Arrays.Medium;

public class Quest13 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maxsubarray :" + maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int maxi = Integer.MIN_VALUE; // maximum sum
        int sum = 0;
    int start = 0;
    int ansStart = -1;
    int ansEnd = -1;
        for (int i = 0; i < arr.length; i++) {
               if(sum == 0){
                    start = i;
               }
            sum += arr[i];

            if (sum > maxi) {
                maxi = sum;
                 ansStart = start;
                ansEnd  = i;
            }

            // If sum < 0: discard the sum calculated
            if (sum < 0) {
                sum = 0;
            }
        }
        // To consider the sum of the empty subarray
        // uncomment the following check:

        if (maxi < 0) {
            maxi = 0;
        }
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.print("]n");


        return maxi;
    }
        //o(n) complexity
//    public static int maxSubArray(int[] nums) {
//        if(nums.length ==  0){
//            return -1;
//        }
//        // Initialize max_current and max_global with the first element of the array
//        int max_current = nums[0];
//        int max_global = nums[0];
//
//        // Iterate through the array starting from the second element
//        for (int i = 1; i < nums.length; i++) {
//            // Update max_current to the maximum of the current element alone or the current element plus the previous max_current
//            max_current = Math.max(nums[i], max_current + nums[i]);
//
//            // Update max_global to the maximum of max_global and max_current
//
//            max_global = Math.max(max_global,max_current);
//        }
//
//        // Return the maximum sum found
//        return max_global;
//    }
    }
