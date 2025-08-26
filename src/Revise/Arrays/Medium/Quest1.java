package Revise.Arrays.Medium;

import java.util.Arrays;

public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {3,5,2,1,4};
        nextPermutation(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void nextPermutation(int[] arr){
        int index = -1;
        for(int i = arr.length-2 ; i>=0;i--){
            if(arr[i] < arr[i+1]){
                index = i;
                break;
            }
        }

        if(index == -1){
            reverse(arr,0, arr.length-1);
            return ;
        }

        for (int i = arr.length-1; i > index ; i--) {
            if(arr[i] > arr[index]){
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                break;
            }
        }
        reverse(arr,index+1,arr.length-1);

    }

    static void reverse(int[] arr, int start , int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end]=temp;
            start++;
            end--;
        }
    }


}
