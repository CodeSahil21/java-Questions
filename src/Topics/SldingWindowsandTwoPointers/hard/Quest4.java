package Topics.SldingWindowsandTwoPointers.hard;

public class Quest4 {
    public static void main(String[] args) {

    }
    private boolean isSubsequence(String sub, String t) {
        int i = 0; // pointer for sub
        int j = 0; // pointer for t

        while (i < sub.length() && j < t.length()) {
            if (sub.charAt(i) == t.charAt(j)) {
                j++; // Match found, move to next char in t
            }
            i++; // Always move to next char in sub
        }
        return j == t.length(); // True if all characters of t were matched
    }

    public String minWindowSubsequenceBruteForce(String S, String T) {
        int N = S.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        // i is the starting index of the substring
        for (int i = 0; i < N; i++) {
            // j is the ending index of the substring
            for (int j = i; j < N; j++) {
                String sub = S.substring(i, j + 1);

                if (isSubsequence(sub, T)) {
                    if (sub.length() < minLen) {
                        minLen = sub.length();
                        result = sub;
                    }
                    // Since we are looking for the minimum length,
                    // we can break the inner loop once a match is found
                    // for the current starting index i.
                    break;
                }
            }
        }

        return result;
    }
    public String minWindowSubsequenceTwoPointerSimplified(String S, String T) {
        int N = S.length();
        int M = T.length();

        int minLen = N + 1;
        int minStart = -1;

        int start_of_new_search = 0; // The left boundary to start the next Forward Scan

        while (start_of_new_search < N) {
            int t_ptr = 0;
            int end_of_match = start_of_new_search;

            // 1. Forward Scan (Expansion) - Find a full subsequence 'T' ending at end_of_match
            while (end_of_match < N) {
                if (S.charAt(end_of_match) == T.charAt(t_ptr)) {
                    t_ptr++;
                }
                if (t_ptr == M) {
                    break; // Full subsequence found
                }
                end_of_match++;
            }

            // If T was not fully matched by reaching the end of S
            if (t_ptr < M) {
                break; // No more matches possible
            }

            // 2. Backward Scan (Contraction) - Find the minimal start index
            int current_start = end_of_match; // Start shrinking from the end of the match
            t_ptr = M - 1; // Start matching T from its last character

            while (t_ptr >= 0) {
                if (S.charAt(current_start) == T.charAt(t_ptr)) {
                    t_ptr--; // Found a character of T needed for the subsequence
                }
                current_start--; // Always move left
            }

            // current_start is now one index before the actual minimal start
            current_start++;

            // 3. Update Minimum and Slide
            int currentLen = end_of_match - current_start + 1;
            if (currentLen < minLen) {
                minLen = currentLen;
                minStart = current_start;
            }

            // Slide the search window forward: the next search must begin
            // after the start of the current minimal window (current_start + 1).
            start_of_new_search = current_start + 1;
        }

        return (minStart == -1) ? "" : S.substring(minStart, minStart + minLen);
    }
    public String minWindowSubsequenceDP(String S, String T) {
        int N = S.length();
        int M = T.length();

        // dp[i][j] stores the starting index in S of the shortest window
        // ending at S[i-1] that contains T[0..j-1] as a subsequence.
        // Size: (N+1) x (M+1)
        int[][] dp = new int[N + 1][M + 1];

        // Initialize DP table. Use a large number (like -1) for "not found".
        // dp[i][0] is for matching an empty T, which is always found
        // and starts at index i (1-indexed for convenience in calculation).
        for (int i = 0; i <= N; i++) {
            dp[i][0] = i;
        }

        // Fill the DP table
        for (int j = 1; j <= M; j++) {
            for (int i = 1; i <= N; i++) {
                if (S.charAt(i - 1) == T.charAt(j - 1)) {
                    // Match found: We extend the shortest subsequence T[0..j-2]
                    // that ended at S[i-2]. The start index is inherited.
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // No match: The shortest subsequence T[0..j-1] ending at S[i-1]
                    // must be the same as the shortest one ending at S[i-2].
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        // Find the overall minimum length window
        int minLen = Integer.MAX_VALUE;
        int minStart = -1;

        // We only care about the last column (j=M), which means T is fully matched.
        for (int i = 1; i <= N; i++) {
            int start = dp[i][M];

            // Check if a valid start index was found (start > 0, since we used 1-based indexing)
            if (start > 0) {
                // Window length: Current end index (i) - Start index (start) + 1
                int currentLen = i - start + 1;

                if (currentLen < minLen) {
                    minLen = currentLen;
                    minStart = start - 1; // Convert back to 0-indexed start for substring()
                }
            }
        }

        return (minStart == -1) ? "" : S.substring(minStart, minStart + minLen);
    }
}
