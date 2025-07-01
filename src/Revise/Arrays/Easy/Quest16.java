package Revise.Arrays.Easy;

public class Quest16 {
    public static void main(String[] args) {
        int[] a = {2, 3, 5, 1, 9};
        int k = 10;
        int len = getLongestSubarray(a, k);
        System.out.println("The length of the longest subarray is: " + len);
    }
    static int getLongestSubarray(int[] arr,int k){
        int n = arr.length;
        int left = 0;
        int right = 0;
        int sum = arr[0];
        int maxLen = 0;
        int i = 0;
        while(right < n){
            while(left <= right && sum > k){
                 sum = sum - arr[left];
                 left++;
            }
            if(sum == k){
                maxLen = Math.max(maxLen,right-left+1);
            }

            right++;
            if(right < n){
                sum = sum + arr[right];
            }
        }
        return maxLen;
    }
}
