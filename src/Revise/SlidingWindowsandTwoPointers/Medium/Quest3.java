package Revise.SlidingWindowsandTwoPointers.Medium;

public class Quest3 {
    public static void main(String[] args) {
        int[] arr ={1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnesOptimal(arr,2));
    }
    static int longestOnesOptimal(int[] arr,int k){
        int left  = 0;
        int right = 0;
        int n = arr.length;
        int zeroes = 0;
        int maxLen = 0;
        while(right < n){
            if(arr[right] == 0){
                zeroes++;
            }
            if(zeroes > k){
                if(arr[left] == 0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes <= k){
                int len = right -left + 1;
                maxLen = Math.max(len,maxLen);
            }
            right++;
        }
        return maxLen;
    }
    static int longestOnesBetter(int[] arr,int k){
        int left  = 0;
        int right = 0;
        int n = arr.length;
        int zeroes = 0;
        int maxLen = 0;
        while(right < n){
            if(arr[right] == 0){
                zeroes++;
            }
            while(zeroes > k){
                if(arr[left] == 0){
                    zeroes--;
                }
                left++;
            }
            if(zeroes <= k){
                int len = right -left + 1;
                maxLen = Math.max(len,maxLen);
            }
            right++;
        }
        return maxLen;
    }


        public static int longestOnesBruteForce(int[] nums, int k) {
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            int zeroCount = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0) zeroCount++;
                if (zeroCount > k) break; // Too many flips, abandon this subarray

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }
}
