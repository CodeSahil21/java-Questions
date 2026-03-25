package Topics.Arrays.Easy;

import java.util.*;

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
    public static boolean containsDuplicate1(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // duplicate found
            }
            seen.add(num);
        }
        return false; // no duplicates
    }
    public static boolean containsDuplicateBrute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true; // duplicate found
                }
            }
        }
        return false; // no duplicates
    }
}
