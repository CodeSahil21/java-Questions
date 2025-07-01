package Revise.Arrays.Easy;

import java.util.Arrays;

public class Quest10 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(arr,k);
        System.out.println(Arrays.toString(arr));
        leftRotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] arr,int k){
        k = k  % arr.length;
        reverse(arr,0, arr.length-1);
        reverse(arr,0,k-1);
        reverse(arr,k, arr.length-1);
    }
    static void leftRotate(int[] arr,int k){
        k = k  % arr.length;
        reverse(arr,0,k-1);
        reverse(arr,k, arr.length-1);
        reverse(arr,0, arr.length-1);
    }
    static void reverse(int[] arr,int start ,int end){
        while(start <= end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
