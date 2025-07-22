package Revise.SlidingWindowsandTwoPointers.Hard;
import java.util.*;

public class Quest1 {
    public static void main(String[] args) {
        String sol = "eceba"; // Example string
        int k = 2; // Maximum distinct characters
        System.out.println(longestSubstringWithK(sol, k)); // Output: 3 (ece)
    }
    public static int longestSubstringWithK(String sol, int k){
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Character,Integer> mpp = new HashMap<>();
        while(right < sol.length()){
            mpp.put(sol.charAt(right),mpp.getOrDefault(sol.charAt(right),0)+1);
            if (mpp.size() > k) {
                mpp.put(sol.charAt(left), mpp.get(sol.charAt(left)) - 1);
                if (mpp.get(sol.charAt(left)) == 0) {
                    mpp.remove(sol.charAt(left));
                }
                left++;
            }
            if (mpp.size() <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }
        return  maxLen;
    }
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Map<Character, Integer> freqMap = new HashMap<>();
            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);

                if (freqMap.size() > k) break; // more than k distinct, stop this window

                maxLen = Math.max(maxLen, j - i + 1);
            }
        }

        return maxLen;
    }

}
