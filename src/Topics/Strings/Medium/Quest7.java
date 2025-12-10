package Topics.Strings.Medium;
//https://leetcode.com/problems/sum-of-beauty-of-all-substrings/description/
public class Quest7 {
    public static void main(String[] args) {

    }
    public int beautySum(String s) {
        int n = s.length();
        int sum = 0;

        // Outer loop (i): Fixes the start index of the substring (s[i...])
        for (int i = 0; i < n; i++) {

            // Frequency array for the current substring s[i...j].
            // Index 0='a', Index 1='b', ..., Index 25='z'.
            int[] freq = new int[26];

            // Inner loop (j): Extends the substring to the right (s[i...j])
            for (int j = i; j < n; j++) {

                // 1. Update Frequency: Increment count for the character s.charAt(j)
                // s.charAt(j) - 'a' gives the index (0-25)
                freq[s.charAt(j) - 'a']++;

                // 2. Find Max and Min Non-Zero Frequency
                int maxi = Integer.MIN_VALUE;
                int mini = Integer.MAX_VALUE;

                // Iterate over the fixed-size frequency array (O(A) = O(26))
                for (int count : freq) {
                    if (count > 0) {
                        // Only consider characters that actually appear (count > 0)
                        mini = Math.min(mini, count);
                        maxi = Math.max(maxi, count);
                    }
                }

                // 3. Calculate and Add Beauty:
                // If a substring is empty or has only one distinct character,
                // mini and maxi will be equal, resulting in 0, which is correct.
                // If mini is still MAX_VALUE, it means the substring was empty (not possible here)
                // or had zero distinct characters (also not possible here since we incremented freq).
                sum += (maxi - mini);
            }
        }

        return sum;
    }
}
