package Topics.SldingWindowsandTwoPointers.medium;
//https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class Quest5 {
    public static void main(String[] args) {

    }

    public static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();
        int left = 0;
        int[] freq = new int[3]; // index 0 → 'a', 1 → 'b', 2 → 'c'

        for (int right = 0; right < n; right++) {
            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                count += (n - right); // all substrings from left to end are valid
                freq[s.charAt(left) - 'a']--;
                left++;
            }
        }

        return count;
    }
    public static  int numberOfSubstrings(String s) {
      int[] lastSeen = {-1,-1,-1};
      int count = 0;
        for (int i = 0; i < s.length(); i++) {
            lastSeen[s.charAt(i)-'a'] = i;
            if ((lastSeen[0] != -1) && (lastSeen[1] != -1) && (lastSeen[2] != -1)) {
                count += (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }
        return count;
    }
}
/*
public static int countSubstringsBrute(String s) {
    int N = s.length();
    int totalCount = 0;

    for (int i = 0; i < N; i++) { // Start index
        int[] freq = new int[3]; // Reset frequency for each starting position
        for (int j = i; j < N; j++) { // End index

            // Track frequency
            freq[s.charAt(j) - 'a']++;

            // Check if all three are present
            if (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                totalCount++;
            }
        }
    }
    return totalCount;
}
 */