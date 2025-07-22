package Topics.SldingWindowsandTwoPointers.medium;


//https://leetcode.com/problems/longest-repeating-character-replacement/description/
public class Quest6 {
    public static void main(String[] args) {

    }
    public static int characterReplacementBrute(String s, int k) {
        int maxLen = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                freq[ch - 'A']++;

                maxFreq = Math.max(maxFreq, freq[ch - 'A']);
                int windowLen = j - i + 1;

                // Can we make all characters same with <= k replacements?
                if (windowLen - maxFreq <= k) {
                    maxLen = Math.max(maxLen, windowLen);
                }
            }
        }

        return maxLen;
    }
    public static int characterReplacement(String s, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int maxFreq = 0;
        int[] hash = new int[26];
        while(right < s.length()){
            hash[s.charAt(right)-'A']++;
            maxFreq = Math.max(maxFreq,hash[s.charAt(right)-'A']);
            if((right-left+1) - maxFreq > k){
                hash[s.charAt(left)-'A']--;
                left++;
            }
            if((right-left+1)-maxFreq <= k){
                maxLen = Math.max(maxLen,right-left+1);
            }
            right++;
        }
        return maxLen;
    }
}
