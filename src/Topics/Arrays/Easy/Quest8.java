package Topics.Arrays.Easy;
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/
//Check if the array is sorted and rotated
public class Quest8 {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        int[] nums2 = {2, 1, 3, 4};
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(check(nums1));// Output: true
        System.out.println(check(nums2));//Output: false
        System.out.println(check(nums3)); // Output: true

    }
    public static boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        } // If more than one rotation point is found //return false
         if (count > 1) {
             return false;
         }
    return true;
    }
}
