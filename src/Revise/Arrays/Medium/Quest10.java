package Revise.Arrays.Medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Quest10 {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8,11};
        int target = 14;
        int[] result = twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
        System.out.println(twoSum1(nums,target));
    }
    static boolean twoSum1(int[] arr,int target){
        int start = 0;
        int end = arr.length-1;
        Arrays.sort(arr);
        while(start <= end){
            int sum = arr[start] + arr[end];
            if(sum == target){
                return true;
            }else if(sum > target){
                end--;
            } else if (sum < target) {
                start++;
            }
        }
        return false;
    }
    static int[] twoSum(int[] arr,int target){
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0 ; i < arr.length; i++ ){
            int element = arr[i];
            int moreNeeded = target - element;
            if(mpp.containsKey(moreNeeded)){
                return new int[] {mpp.get(moreNeeded),i};
            }
            mpp.put(element,i);
        }
        return new int[]{-1,-1};
    }
}
