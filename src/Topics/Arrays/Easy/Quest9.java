package Topics.Arrays.Easy;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
//remove-duplicates from sorted array
public class Quest9 {
    public static void main(String[] args) {
    int[] arr = {0,0,1,1,1,2,2,3,3,4};
    int result = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    System.out.println(result);

    }

    public static int removeDuplicates(int[] nums) {
       int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if(nums[i] != nums[j]){
                nums[i+1] = nums[j];
                i++;
            }
        }
        return  i+1;
    }
}
