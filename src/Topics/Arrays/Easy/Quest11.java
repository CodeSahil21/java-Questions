package Topics.Arrays.Easy;

import java.util.Arrays;
///
public class Quest11 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
    public static void moveZeroes(int[] nums) {
         int j = -1;
        for (int i = 0; i< nums.length; i++) {
            if(nums[i] == 0){
                 j = i;
                break;
            }
        }
        for (int i = j+1; i < nums.length; i++) {
            if(nums[i] != 0){
                swap(nums,i,j);
                j++;
            }
        }
    }

    static void swap(int[] nums,int a, int b){
        int temp = nums[a];
        nums[a]= nums[b];
        nums[b] = temp;
    }
}
