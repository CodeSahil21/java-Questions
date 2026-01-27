package Revise;

import java.util.Arrays;
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
    static int quest(int[] arr,int m){
        int largest = Integer.MIN_VALUE;
        int secLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
             if(arr[i] > largest){
                 secLargest = largest;
                 largest = arr[i];
             }else if(arr[i] > secLargest && arr[i] != largest){
                 secLargest = arr[i];
             }
        }
        if(secLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secLargest;
    }
}
