package Topics.Arrays.Easy;

import java.util.Arrays;

//https://www.geeksforgeeks.org/program-to-reverse-an-array/
//Array Reverse
public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {7,6,5,4,3,2,1};
        System.out.println("Original Array:"+ Arrays.toString(arr));
        reverse(arr);
        System.out.println("Reversed Array:"+ Arrays.toString(arr));
    }

//here time complexity will be o(n)
    static void reverse(int[] arr){
        int first = 0;
        int last = arr.length-1;
        while(first < last){
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;
            first++;
            last--;
        }
    }
}
