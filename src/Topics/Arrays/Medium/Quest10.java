package Topics.Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
//https://leetcode.com/problems/two-sum/description/
//two sum
public class Quest10 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8,11};
        int target = 14;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        System.out.println(twoSum1(nums,target));
    }
    public static boolean twoSum1(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        Arrays.sort(nums);
        while(left < right){
            int sum = nums[left] + nums[right];
            if(sum == target){
                return true;
            }
            if(sum < target){
                left++;
            }
            if(sum > target){
                right--;
            }
        }
        return false;

    }
    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< nums.length;i++){
            int element = nums[i];
            int moreneeded = target - element;
            if(map.containsKey(moreneeded)){
                return new int[]{map.get(moreneeded),i};
            }
            map.put(element,i);
        }
        return new int[] {-1,1};
    }
}
