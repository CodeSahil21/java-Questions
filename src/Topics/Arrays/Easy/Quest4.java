package Topics.Arrays.Easy;

import java.util.Arrays;

//
//contain duplicate
public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1,3,2,1};
        System.out.println(containsDuplicate(arr));
    }
    public static boolean containsDuplicate(int[] nums) {
        //for this problem we sort the array
        Arrays.sort(nums);
//we check if nums[i] == nums[i-1] return true if it's there
        for (int i = 1; i < nums.length; i++) {
            //1,1,2,3
            if(nums[i]==nums[i-1]){
                return true;
            }
        }
        return false;
    }
}
