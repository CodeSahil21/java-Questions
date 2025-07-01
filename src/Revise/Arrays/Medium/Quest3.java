package Revise.Arrays.Medium;

import java.util.Arrays;

public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {3,1,2,5,3};
        System.out.println(Arrays.toString(repeatedNumber(arr)));
    }
    static int[] repeatedNumber(int[] arr){
        Arrays.sort(arr);
        for (int i = 0 ; i < arr.length;i++){
            if(arr[i] != i+1){
                return new int[] {arr[i],i+1};
            }
        }
        return new int[] {-1,-1};
    }
}
