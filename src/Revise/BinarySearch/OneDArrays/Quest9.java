package Revise.BinarySearch.OneDArrays;

public class Quest9 {
    public static void main(String[] args) {

    }
    static boolean search(int[] nums, int target){
        if (nums.length == 1) {
            return nums[0] == target;
        }
        int pivot = findpivot(nums);
        //if there is no pivot means array is sorted
        if(pivot == -1){
            return binarySearch(nums,target,0,nums.length-1);
        }
        //if pivot element is target
        if(nums[pivot] == target){
            return true;
        }
        //case 2
        if(target >= nums[0]){
            return binarySearch(nums,target,0,pivot-1);
        }else{
            return binarySearch(nums,target,pivot+1,nums.length-1);
        }
    }
    static int findpivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Case 1: found the pivot
            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }
            // Case 2: found the pivot
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // Handle duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // Skip duplicates from start
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;
                // Skip duplicates from end
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // If left side is sorted, go to right side
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            }
            // If right side is sorted, go to left side
            else {
                end = mid - 1;
            }
        }
        return -1;
    }


    static boolean binarySearch(int[] arr,int target,int start,int end){
        while(start<= end){
            int mid = start +(end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }else if(target > arr[mid]){
                start = mid+1;
            }else if(arr[mid] == target ){
                return true;
            }
        }
        return false;
    }
}
