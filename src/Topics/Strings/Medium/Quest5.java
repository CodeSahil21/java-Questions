package Topics.Strings.Medium;
import java.util.*;
public class Quest5 {
    public static void main(String[] args) {

        // Example 1: s = "pqpqs", k = 2 -> Output: 7
        String s1 = "pqpqs";
        int k1 = 2;
        System.out.println("Input: s=\"" + s1 + "\", k=" + k1 + " | Count: " + countSubstrings(s1, k1));

        // Example 2: s = "abcbaa", k = 3 -> Output: 5
        String s2 = "abcbaa";
        int k2 = 3;
        System.out.println("Input: s=\"" + s2 + "\", k=" + k2 + " | Count: " + countSubstrings(s2, k2));
    }

    public  static int countSubstrings(String s, int k) {
        // Edge case check: k must be positive for a valid solution (since k-1 is used).
        if (k <= 0) {
            return 0;
        }

        // Exactly k = AtMost(k) - AtMost(k-1)
        // If k=1, we return atMostKDistinct(s, 1) - atMostKDistinct(s, 0).
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    /**
     * Helper function: Counts the number of substrings with at most 'k' distinct characters.
     * This uses the Sliding Window technique.
     */
    private static int atMostKDistinct(String s, int k) {
        // If k is 0, no distinct characters are allowed, so the count is 0.
        // This also handles the k-1 = 0 case from the main function call.
        if (k == 0) {
            return 0;
        }

        int left = 0; // Left pointer (start of the window)
        int result = 0; // Accumulator for the total count of valid substrings

        // HashMap to store the frequency of characters in the current window.
        // The map's size (map.size()) gives the count of distinct characters.
        Map<Character, Integer> freq = new HashMap<>();

        // 1. Expand the window with the right pointer
        for (int right = 0; right < s.length(); right++) {
            char charRight = s.charAt(right);

            // Add or increment the character count
            freq.put(charRight, freq.getOrDefault(charRight, 0) + 1);

            // 2. Contract the window if the distinct character count exceeds k
            // The map size (freq.size()) represents the number of distinct characters
            while (freq.size() > k) {
                char charLeft = s.charAt(left);

                // Decrement the count of the character at the left of the window
                freq.put(charLeft, freq.get(charLeft) - 1);

                // If the count drops to 0, this character is no longer in the window,
                // so we remove it to correctly update the distinct character count (freq.size())
                if (freq.get(charLeft) == 0) {
                    freq.remove(charLeft);
                }

                // Move the left boundary of the window
                left++;
            }

            // 3. Count all valid substrings ending at 'right'
            // Since the window [left...right] is valid, all (right - left + 1) substrings
            // ending at 'right' and starting at or after 'left' are valid.
            result += (right - left + 1);
        }

        return result;
    }
}
