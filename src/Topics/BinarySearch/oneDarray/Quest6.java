package Topics.BinarySearch.oneDarray;

public class Quest6 {
    public static void main(String[] args) {

    }
    public int[] searchRange(int[] nums, int target){
        int start = lowerBound(nums,target);
        if(start == nums.length|| nums[start] != target){
            return new int[] {-1,-1};
        }
        int end = upperBound(nums, target);
        return new int[] {start ,end-1};
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
