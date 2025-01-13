package Topics.Arrays.Easy;
//https://leetcode.com/problems/maximum-subarray/description/
//53 Maximum Subarray: Kadane's Algorithm
public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maxsubarray :" + maxSubArray(arr));
    }
    //o(n) complexity
    public static int maxSubArray(int[] nums) {
        if(nums.length ==  0){
            return -1;
        }
        // Initialize max_current and max_global with the first element of the array
        int max_current = nums[0];
        int max_global = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update max_current to the maximum of the current element alone or the current element plus the previous max_current
            max_current = Math.max(nums[i], max_current + nums[i]);
            // Update max_global to the maximum of max_global and max_current
            max_global = Math.max(max_global,max_current);
        }
        // Return the maximum sum found
        return max_global;
    }
//    public static int maxSubArray(int[] nums) {
//        int result = nums[0];
//
//        for (int i = 0; i < nums.length; i++) {
//            int currsum = 0;
//
//            for (int j = i; j <nums.length ; j++) {
//                currsum = currsum + nums[j];
//
//                result = Math.max(result,currsum);
//            }
//        }
//        return result;
//    }
//}
}
//this is for large array number using o(n) complexity


