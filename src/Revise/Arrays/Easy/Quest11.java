package Revise.Arrays.Easy;

import java.util.Arrays;

public class Quest11 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    static void moveZeroes(int[] arr){
        int j = 0;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] == 0){
                j = i;
                break;
            }
        }

        for(int i = j; i < arr.length; i++ ){
            if(arr[i] != 0){
                swap(arr,i,j);
                j++;
            }
        }
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
         arr[a] = arr[b];
         arr[b] = temp;
    }
}
