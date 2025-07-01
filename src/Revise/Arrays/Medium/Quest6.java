package Revise.Arrays.Medium;

import java.util.Arrays;

public class Quest6 {
    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 4};
        int[] result= productExceptSelf(nums);
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Product array: " + Arrays.toString(result));
    }

    static int[] productExceptSelf(int[] arr){
        int[] right = new int[arr.length];
        int[] left = new int[arr.length];
        left[0] = 1;
        for(int i = 1 ; i < arr.length;i++){
            left[i] = left[i-1] * arr[i-1];
        }
        right[arr.length-1] = 1;
        for(int i = arr.length-2 ;  i >= 0; i--){
            right[i] = right[i+1] * arr[i+1];
        }
        int[] result  = new int[arr.length];
        for(int i = 0; i < arr.length; i++ ){
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
