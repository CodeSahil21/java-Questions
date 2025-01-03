package Topics.Arrays.Medium;
import java.util.*;
//238:Product of array  except self
//https://leetcode.com/problems/product-of-array-except-self/description/
public class Quest6 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        int[] result= productExceptSelf(nums);
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Product array: " + Arrays.toString(result));

    }

    public static int[] productExceptSelf(int[] nums) {
        //create two auxilary array
        int[] left = new int[nums.length];
        int[]  right  = new int[nums.length];

        //store left multiplication
        left[0] = 1;//we assign left[0] one because there is no number on left of  left[0]
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i-1] * nums[i-1];
        }

        //store right multiplication
        right[nums.length-1] = 1;//we assign  right[nums.length-1] one because there is no number on  right of  right[nums.length-1]
        for(int i = nums.length-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }

        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = left[i]*right[i];
        }
          return ans;
    }
}
/*
arr   =  2    1    3   4
left  =  1    2    2   6
right =  12   12   4   1
ans   =   12   24   8  6
 */