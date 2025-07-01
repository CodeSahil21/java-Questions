package Revise.Arrays.Easy;
import java.util.Arrays;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        System.out.println("Original Array:"+ Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reversed Array:"+ Arrays.toString(arr));
    }
    static void reverse(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}

