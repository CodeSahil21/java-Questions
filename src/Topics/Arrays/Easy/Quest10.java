package Topics.Arrays.Easy;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-array/description/
//rotate the array
public class Quest10 {
    public static void main(String[] args) {
      int[] arr = {1,2,3,4,5,6,7};
      int k = 3;
      rotate(arr,k);
        System.out.println(Arrays.toString(arr));
    }

    //no of rotation will always be r = r % N  where N = arr.length ex if N = 7 and r = 8;no of rotation = 1 because after every
    //N rotation it will return to being its original array and only one rotation needed for 8 rotation
    //this of right rotate
    public static void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    public static void leftRotate(int[] nums, int k) {
        k = k % nums.length;
        // Ensure k is within the bounds of the array's length
        // Reverse the first k elements
        reverse(nums, 0, k - 1);
        // Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
        // Reverse the entire array
        reverse(nums, 0, nums.length - 1);
    }

    static void reverse(int[] arr,int start,int end){
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
    //{1,2,3,4,5,} d = 2
    /*
  first we reverse arr[0] to arr[d] ={2,1,3,4,5}
  then we reverse arr[d+1] to arr[arr.length-1] ={2,1,5,4,3}
  // reverse entire array  : 3,4,5,1,2
     */
    //to rotate the array by one place
    //left rotate by one
    public static void leftOne(int[] arr){//o(n):time space:o(1)
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
             arr[i-1] = arr[i];
        }

        arr[arr.length-1] = temp;
    }
    //right rotate by one
    public static void rightOne(int[] arr){
        int temp = arr[arr.length-1];
        for (int i = arr.length-1; i > 0; i--) {
            arr[i] = arr[i-1];
        }

        arr[0] = temp;
    }

}
