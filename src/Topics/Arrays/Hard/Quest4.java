package Topics.Arrays.Hard;
import java.util.*;
//https://leetcode.com/problems/4sum/
public class Quest4 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    public static  List<List<Integer>> fourSum(int[] nums, int target) {
             List<List<Integer>> list = new ArrayList<>();
             Arrays.sort(nums);
             for(int i = 0; i< nums.length;i++){
                 if(i > 0 && nums[i] == nums[i-1]){
                     continue;
                 }
                 for (int j = i+1; j <nums.length ; j++) {
                     if(j > i+1 && nums[j] == nums[j-1]){
                         continue;
                     }
                     int k = j+1;
                     int l = nums.length-1;
                     while(k < l){
                         long sum = nums[i];
                         sum += nums[j];
                         sum += nums[k];
                         sum += nums[l];
                         if( sum == target){
                             List<Integer> temp =new ArrayList<>();
                             temp.add(nums[i]);
                             temp.add(nums[j]);
                             temp.add(nums[k]);
                             temp.add(nums[l]);
                             list.add(temp);
                             k++;
                             l--;
                             while( k < l && nums[k] == nums[k-1]){
                                 k++;
                             }
                             while( k < l && nums[l] == nums[l+1]){
                                 l--;
                             }
                         }else if(sum < target){
                               k++;
                         }else if(sum > target){
                               l--;
                         }
                     }
                 }
             }
             return list;
    }
}
