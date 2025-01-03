package Topics.Arrays.Hard;
//https://leetcode.com/problems/3sum/description/
import java.util.*;
public class Quest3 {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum( arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();

    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
       Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if( i!=0  && nums[i] == nums[i-1]){
                continue;
            }
            //moving two pointers
            int j = i+1;
            int k = nums.length-1;
            while(j < k){
                int sum = nums[i] +nums[j]+nums[k];
                if(sum < 0){
                    j++;
                } else if (sum > 0) {
                    k--;
                }else{
                    List<Integer> temp = Arrays.asList(nums[i],nums[j],nums[k]);
                    ans.add(temp);
                    j++;
                    k--;
                     while(j < k && nums[j] == nums[j-1]){
                         j++;
                     }
                     while(j < k && nums[k] == nums[k+1]){
                         k--;
                     }

                }
            }
        }
    return  ans;
    }
}
