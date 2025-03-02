package Topics.SldingWindowsandTwoPointers.medium;
//https://leetcode.com/problems/max-consecutive-ones-iii/description/
public class Quest3 {
    public static void main(String[] args) {
   int[] arr ={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(arr,2));
    }
    public  static int longestOnes(int[] nums, int k) {
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int zeroes = 0;
        while(right < nums.length){
            if(nums[right]==0){
                zeroes++;
            }
           if(zeroes > k){
                if(nums[left]==0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes <= k){
                int len = right - left + 1;
                maxLen = Math.max(maxLen,len);
            }
            right++;
        }
        return maxLen;
    }
}
