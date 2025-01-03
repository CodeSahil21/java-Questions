package Topics.BinarySearch.oneDarray;
//https://www.naukri.com/code360/problems/ceiling-in-a-sorted-array_1825401
public class Quest5 {
    public static void main(String[] args) {

    }
    public static int Ceil(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        if(target > nums[nums.length-1]){
            return -1;
        }
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target){
                end =mid-1;
            }
        }
        //whenever start crosses end or vice versa
        return start;//since it points to next greater element
    }
    public static int floor(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(nums[mid] < target){
                start = mid+1;
            }else if(nums[mid] > target){
                end =mid-1;
            }
        }
        //whenever start crosses end or vice versa
        return end;//since it points to  greatest element smaller than target
    }
}
