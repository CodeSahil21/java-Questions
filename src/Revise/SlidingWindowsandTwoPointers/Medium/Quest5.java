package Revise.SlidingWindowsandTwoPointers.Medium;
import java.util.*;

public class Quest5 {


    public static int countSubstrings(String s) {
        int count = 0;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(s.charAt(j));
                if (seen.contains('a') && seen.contains('b') && seen.contains('c')) {
                    count++; // valid substring found
                }
            }
        }

        return count;
    }
}
