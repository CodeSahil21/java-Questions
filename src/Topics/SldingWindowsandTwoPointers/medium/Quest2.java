package Topics.SldingWindowsandTwoPointers.medium;
import java.util.*;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
public class Quest2 {
    public static void main(String args[]) {
        String str = "takeUforward";
        System.out.println("The length of the longest substring without repeating characters is " + lengthOfLongestSubstring(str));
    }
    public static  int lengthOfLongestSubstring(String s) {
        HashMap < Character, Integer > mpp = new HashMap < Character, Integer > ();

        int left = 0, right = 0;
        int n = s.length();
        int len = 0;
        while (right < n) {
            if (mpp.containsKey(s.charAt(right))){
                left = Math.max(mpp.get(s.charAt(right)) + 1, left);
            }

            mpp.put(s.charAt(right), right);

            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }
}
/*
public static int lengthOfLongestSubstringBrute(String s) {
    int N = s.length();
    int maxLength = 0;

    for (int i = 0; i < N; i++) { // Start index
        for (int j = i; j < N; j++) { // End index
            // Check uniqueness of s[i...j]
            if (areCharactersUnique(s, i, j)) {
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
    }
    return maxLength;
}

// Helper function: O(N) check
private static boolean areCharactersUnique(String s, int start, int end) {
    HashSet<Character> set = new HashSet<>();
    for (int i = start; i <= end; i++) {
        if (set.contains(s.charAt(i))) {
            return false;
        }
        set.add(s.charAt(i));
    }
    return true;
}
 */