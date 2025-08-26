package Revise.Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class Quest12 {
    public static void main(String[] args) {
        int[] arr = {2, 2, 1, 1, 1, 2, 2};
        int ans = majorityElement(arr);
        System.out.println("The majority element is: " + ans);
    }
    static int majorityElement(int[] arr){
        int count = 0;
        int element = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(count == 0 ){
                element =  arr[i];
                count++;
            }else if(arr[i]  == element){
                count++;
            }else if(arr[i] != element){
                count--;
            }
        }
        int c2 = 0;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] == element){
                c2++;
            }
        }
        if(c2 > arr.length/2){
            return element;
        }
        return -1;
    }
    public static int majorityElement2(int []v) {
        //size of the given array:
        int n = v.length;

        //declaring a map:
        HashMap<Integer, Integer> mpp = new HashMap<>();

        //storing the elements with its occurnce:
        for (int i = 0; i < n; i++) {
            int value = mpp.getOrDefault(v[i], 0);
            mpp.put(v[i], value + 1);
        }

        //searching for the majority element:
        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (n / 2)) {
                return it.getKey();
            }
        }

        return -1;
    }
}
