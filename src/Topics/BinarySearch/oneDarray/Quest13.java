package Topics.BinarySearch.oneDarray;
//https://leetcode.com/problems/single-element-in-a-sorted-array/description/
public class Quest13 {
    public static void main(String[] args) {
   int[] arr = {1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6};
   int ans = singleNonDuplicate(arr);
        System.out.println(ans);
    }
    public static  int singleNonDuplicate(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        if(nums[0] != nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1] != nums[nums.length-2]){
            return nums[nums.length-1];
        }
        int start = 1;
        int end = nums.length-2;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] != nums[mid+1] && nums[mid] != nums[mid-1]){
                return nums[mid];
            }
            //left side of single element (even odd):case
            if((mid % 2 == 1 && nums[mid] == nums[mid-1])||(mid % 2==0  && nums[mid] ==nums[mid+1]) ){
                start =mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}
