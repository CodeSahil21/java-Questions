package Revise.BinarySearch.OneDArrays;

public class Quest7 {
    public static void main(String[] args) {
        int[] arr =  {2, 4, 6, 8, 8, 8,8,8, 11,11, 13};
        int  x = 11;
        int ans = countOccurneces(arr,  x);
        System.out.println("The number of occurrences is: " + ans);
    }
    static int countOccurneces(int[] nums,int target){
        int start = lowerBound(nums,target);
        int end = upperBound(nums,target);
        int count = (end-1) - start + 1;
        return count;
    }
    static int lowerBound(int[] nums,int target){
        int start = 0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end){
            int mid = start+(end-start)/2;
            if(nums[mid] >=  target){
                ans = mid;
                //search for smallest index which has 8
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
    static int upperBound(int[] nums,int target){
        int start =0;
        int end = nums.length-1;
        int ans = nums.length;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(nums[mid] > target){
                ans = mid;
                //search for smallest number greater than target
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
