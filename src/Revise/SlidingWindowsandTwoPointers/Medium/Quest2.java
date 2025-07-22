package Revise.SlidingWindowsandTwoPointers.Medium;

import java.util.HashMap;
import java.util.Map;

public class Quest2 {
    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + lengthOfLongestSubstring(str));
    }

    static int lengthOfLongestSubstring(String input){
        HashMap<Character,Integer> mpp = new HashMap<>();
        int left =0;
        int right = 0;
        int len = 0;
        int  n = input.length();
        while(right < n){
            if(mpp.containsKey(input.charAt(right))){
                left = Math.max(left,mpp.get(input.charAt(right)) + 1);
            }

            mpp.put(input.charAt(right),right);
            len = Math.max(len,right-left+1);
            right++;
        }
        return len;
    }
    public static int lengthOfLongestSubstringBrute(String s) {
        int maxLength = 0;

            for (int i = 0; i < s.length(); i++) {
                int[] freq = new int[256]; // ASCII range
                for (int j = i; j < s.length(); j++) {
                    char ch = s.charAt(j);
                    if (freq[ch] > 0) {
                        break; // Duplicate found, break early
                    }
                    freq[ch]++;
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }

            return maxLength;
    }
}
