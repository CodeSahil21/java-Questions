package Topics.BinarySearch.oneDarray;
//https://leetcode.com/problems/binary-search/submissions/1480283293/
public class Quest1 {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
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
        return -1;
    }
}
