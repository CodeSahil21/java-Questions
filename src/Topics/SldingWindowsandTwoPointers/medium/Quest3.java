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
/*
public static int longestOnesBrute(int[] nums, int k) {
    int N = nums.length;
    int maxLen = 0;

    for (int i = 0; i < N; i++) { // Start index
        int zeros = 0;
        for (int j = i; j < N; j++) { // End index
            if (nums[j] == 0) {
                zeros++;
            }
            // Check the constraint for the current window [i...j]
            if (zeros <= k) {
                maxLen = Math.max(maxLen, j - i + 1);
            } else {
                // No need to continue expanding this window, as adding more elements will only increase zeros
                break;
            }
        }
    }
    return maxLen;
}
 */
