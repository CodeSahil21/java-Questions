package Topics.BinarySearch.oneDarray;
//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class Quest10 {
    public static void main(String[] args) {

    }
    public  int findMin(int[] nums) {
        int pivot = findpivot(nums);
        // If there is no pivot, the array is not rotated
        if (pivot == -1) {
            return nums[0]; // The array is already sorted in ascending order
        }
        // Minimum value will be the smallest between the start of the array and the element just after the pivot
        return  nums[pivot + 1];
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

}
