package Topics.SldingWindowsandTwoPointers.hard;

import java.util.HashMap;

//https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/description/
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
}
