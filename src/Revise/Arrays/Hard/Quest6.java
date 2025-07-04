package Revise.Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class Quest6 {
    public static void main(String[] args) {
        int[] a = {4, 2, 2, 6, 4};
        int k = 6;
        int ans = subarraysWithXorK(a, k);
        System.out.println("The number of subarrays with XOR k is: " + ans);
    }

    static int subarraysWithXorK(int[] arr,int k){
        Map<Integer,Integer> mpp = new HashMap<>();
        int xr = 0;
        mpp.put(xr,1);
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            xr = xr ^ arr[i];
            int x = xr ^ k;
            if(mpp.containsKey(x)){
                cnt += mpp.get(x);
            }
            if(mpp.containsKey(xr)){
                mpp.put(xr,mpp.get(xr) +1);
            }else{
                mpp.put(xr,1);
            }
        }
        return cnt;
    }

}
