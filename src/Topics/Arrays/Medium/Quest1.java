package Topics.Arrays.Medium;

import java.util.Arrays;
//leetcode next permutation
public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {3,2,1};
          nextPermutation(arr);
        System.out.println(Arrays.toString(arr));

    }
    public static void nextPermutation(int[] nums) {
        int index = -1;
       /*
       If we start at nums.length - 1, there would be no nums[i + 1] to compare to,
        as nums[i + 1] would be out of bounds of the array.
        *///{2,1,5,4,3,0,0}
        for(int i = nums.length-2;i>= 0;i--){//o(n)
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        //case: if we don't find index then  we just reverse the array ex : arr = {5,4,3,2,1} because it's next permutation will be 1,2,3,4,5
        if(index == -1){
            reverse(nums,0,nums.length-1);//(0(n)
            return;//put return so once this case execute it return  to calling function
        }

        for(int i = nums.length-1;i>index;i--){
            if(nums[i] > nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;//o(n)
                break;
            }
        }

        reverse(nums,index+1, nums.length-1);//o(n)
    }
//time complexity o(3(n))
      static void reverse(int[] arr, int start,int end){
        while(start < end){
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
            start++;
            end--;
        }
      }

}
   //Steps to solve the problem
    /*
    1)Find longer prefix ie  arr[i] < arr[i+1] : ex arr = {2,1,5,4,3,0,0} here if we traverse from n-1 we 5 and 1 we see arr[i] < arr[i+1] = 1
    2)now we find number which is greater than but in sorted order ie here after 1 , 3 is next greater number than 1 and less to 4
    3)swap 3 and 1 and reverse the array from index of(3) + 1 to n-1;
     */



