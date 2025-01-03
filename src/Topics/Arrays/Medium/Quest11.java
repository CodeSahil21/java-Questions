package Topics.Arrays.Medium;

import java.util.Arrays;

//https://leetcode.com/problems/sort-colors/description/
//
public class Quest11 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void sortColors(int[] nums) {
           int low = 0;
           int mid = 0;
           int high = nums.length-1;
           while(mid <= high){
               if(nums[mid]==0){
                   swap(nums,low,mid);
                   low++;
                   mid++;
               }else if(nums[mid] == 1){
                   mid++;
               }else if(nums[mid] == 2){
                   swap(nums,mid,high);
                   high--;
               }
           }
    }
    static void swap(int[] nums,int a,int b){
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
