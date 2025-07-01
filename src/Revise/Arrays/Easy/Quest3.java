package Revise.Arrays.Easy;
import java.util.*;
//https://leetcode.com/problems/maximum-subarray/description/
public class Quest3 {
    public static void main(String[] args){
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maxsubarray : O(N)^2 " + maxSubArrayON2(arr));
        System.out.println("Maxsubarray : O(N) " + maxSubArrayON(arr));
    }
    //Maximum subarray with complexity of O(N^2)
    static int maxSubArrayON2(int[] nums){
        int result = nums[0];
        for(int i = 0; i < nums.length;i++){
            int currSum = 0;
            for(int j = i ; j < nums.length;j++){
                currSum =currSum + nums[j];
                result = Math.max(currSum,result);
            }
        }
        return result;
    }

    //Maximum subarray with complexity ON
    public static  int maxSubArrayON(int[] arr){
        if(arr.length == 0){
            return -1;
        }
       int maxCurrent = arr[0];
        int  maxGlobal = arr[0];
        for (int i = 1; i < arr.length ; i++) {
            maxCurrent = Math.max(arr[i],maxCurrent+ arr[i]);
            maxGlobal = Math.max(maxCurrent,maxGlobal);
        }

        return maxGlobal;
    }
}
