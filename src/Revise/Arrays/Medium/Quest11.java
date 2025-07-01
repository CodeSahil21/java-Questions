package Revise.Arrays.Medium;

import java.util.Arrays;

public class Quest11 {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 2, 0, 1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    static  void sortColors(int[] arr){
        int low = 0;
        int mid = 0;
        int high = arr.length-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr,mid,low);
                low++;
                mid++;
            }else if(arr[mid] == 1){
                mid++;
            }else if(arr[mid] == 2){
                swap(arr,mid,high);
                high--;
            }
        }
    }
    static void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b]=temp;
    }
}
