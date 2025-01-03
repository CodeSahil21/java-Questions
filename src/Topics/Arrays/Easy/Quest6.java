package Topics.Arrays.Easy;

import org.w3c.dom.ls.LSOutput;

//search in Rotated Arrays
//leetcode:https://leetcode.com/problems/search-in-rotated-sorted-array/description/
public class Quest6 {
    public static void main(String[] args) {
         int[] arr = {4,5,6,7,0,1,2,3};
         int target = 2;
         int result = search(arr,target);
        System.out.println(result);
    }
    //steps to solve it
    /*this problem is solved using binary search
    1) find pivot element such  that arr = {4,5,6,7,0,1,2} ex 7 is pivot element  were 7 and 0 are in descending order
    2)use binary search  in two part of array ie from 4 to 7 and  0 to 2
     */

    static int search(int[] nums, int target){
        int pivot = findpivot(nums);
        //if there is no pivot means array is sorted
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        //if pivot element is equal to  target
        if(nums[pivot] == target){
            return pivot;
        }
        //case 2
        if(target >= nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }else{
            return binarySearch(nums,target,pivot+1,nums.length-1);
        }
    }
        static int findpivot(int[] arr){
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            //4 cases
            //case 1:arr = {4,5,6,7,0,1,2} ex mid = 7 and mid+1 =0
            if(mid < end && arr[mid]>arr[mid+1]){
                return mid;
            }
           //case 2: {4,5,6,7,0,1,2,3} ex mid = 0 and mid-1 =7
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid -1;
            }
            if(arr[mid] <= arr[start]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return  -1;
        }

        static int binarySearch(int[] arr,int target,int start,int end){
            while(start<= end){
                int mid = start +(end-start)/2;
                if(target<arr[mid]){
                    end = mid-1;
                }else if(target > arr[mid]){
                    start = mid+1;
                }else if(arr[mid] == target ){
                    return mid;
                }
            }
            return -1;
        }
}
