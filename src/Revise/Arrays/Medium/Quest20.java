package Revise.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Quest20 {
    public static void main(String[] args) {
        int[] arr = {3, 4, 7, -2, 2, 1, 4, 2};
        int   k = 7;
        int ans = subArrayWithSumK(arr,7);
        System.out.println(ans);
    }
    static int subArrayWithSumK(int[] arr,int k){
        int count = 0;
        int preSum = 0;
        Map<Integer,Integer> mpp = new HashMap<>();
        mpp.put(0,1);
        int n = arr.length;
        for(int i = 0 ; i < n;i++){
            preSum  += arr[i];
            int remove =  preSum - k;
            count += mpp.getOrDefault(remove,0);
            mpp.put(preSum,mpp.getOrDefault(preSum,0)+1);
        }
        return count;
    }
}
