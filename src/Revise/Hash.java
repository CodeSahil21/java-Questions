package Revise;

import java.util.HashMap;
import java.util.Map;


public class Hash {
    public static void main(String[] args) {
        Map<Integer,Integer> mpp = new HashMap<>();
        int[] arr = {1,2,3,4,5,6};
        for (int i = 0; i < arr.length; i++) {
            mpp.put(i,arr[i]);
        }
        int a = mpp.get(2);
        System.out.println(a);
    }
}
