package Topics.Strings.Medium;

public class Quest6 {
        /**
         * Main method to test the Longest Palindromic Substring solution.
         */
        public static void main(String[] args) {


            // --- Test Cases ---

            // Example 1: Input: "babad" -> Output: "bab" or "aba"
            String s1 = "babad";
            String result1 = longestPalindrome(s1);
            System.out.println("Input: \"" + s1 + "\", Output: \"" + result1 + "\" (Expected: \"bab\" or \"aba\")");

            // Example 2: Input: "cbbd" -> Output: "bb"
            String s2 = "cbbd";
            String result2 = longestPalindrome(s2);
            System.out.println("Input: \"" + s2 + "\", Output: \"" + result2 + "\" (Expected: \"bb\")");

            // Example 3: Longest Odd Palindrome
            String s3 = "forgeeksskeegfor";
            String result3 = longestPalindrome(s3);
            System.out.println("Input: \"" + s3 + "\", Output: \"" + result3 + "\" (Expected: \"geeksskeeg\")");

            // Example 4: Longest Even Palindrome
            String s4 = "aabbaa";
            String result4 = longestPalindrome(s4);
            System.out.println("Input: \"" + s4 + "\", Output: \"" + result4 + "\" (Expected: \"aabbaa\")");

            // Example 5: Single Character
            String s5 = "z";
            String result5 = longestPalindrome(s5);
            System.out.println("Input: \"" + s5 + "\", Output: \"" + result5 + "\" (Expected: \"z\")");
        }

        public static String longestPalindrome(String s) {
            // Edge case: if string is 0 or 1 character, it's a palindrome itself.
            if (s == null || s.length() < 2) {
                return s;
            }

            // 'start' and 'end' will track the indices of the *current longest* palindrome found.
            int start = 0, end = 0;

            // Loop through every possible center index
            for (int center = 0; center < s.length(); center++) {

                // Check 1: Odd Length Palindrome (center = 'a' in "bab")
                int lenOdd = expandFromCenter(s, center, center);

                // Check 2: Even Length Palindrome (center = space between 'b' and 'b' in "cbbd")
                int lenEven = expandFromCenter(s, center, center + 1);

                // Find the maximum length found from *this* specific center
                int maxLen = Math.max(lenOdd, lenEven);

                // Check if this maxLen is greater than the length of the current longest palindrome
                // Current longest length is (end - start + 1)
                if (maxLen > end - start + 1) {

                    // --- Index Calculation Logic ---

                    // Calculate the new 'start' index:
                    // Start = center - (distance from center to start)
                    // Distance is (maxLen - 1) / 2 using integer division
                    start = center - (maxLen - 1) / 2;

                    // Calculate the new 'end' index:
                    // End = center + (distance from center to end)
                    // Distance is maxLen / 2 using integer division
                    end = center + maxLen / 2;
                }
            }

            // Return the final longest substring using the recorded 'start' and 'end' indices.
            // String.substring(beginIndex, endIndex) in Java is EXCLUSIVE of the endIndex.
            // Therefore, we use start and end + 1.
            return s.substring(start, end + 1);
        }

        /**
         * Helper function: Returns the length of the palindrome found by expanding
         * outwards from the initial 'left' and 'right' indices.
         */
        private static int expandFromCenter(String str, int left, int right) {
            // Keep expanding as long as three conditions are true:
            // 1. left is not out-of-bounds (>= 0)
            // 2. right is not out-of-bounds (< str.length())
            // 3. Characters at left and right indices match
            while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
                left--;  // Move left pointer one step to the left
                right++; // Move right pointer one step to the right
            }

            // Length = (Final right index) - (Final left index) - 1
            return right - left - 1;
        }

}
