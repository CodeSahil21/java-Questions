package Revise.Strings.Easy;

import java.util.Arrays;

public class Quest4 {

    public static void main(String[] args) {
        String[][] testCases = {
                {"flower", "flow", "flight"},
                {"dog", "racecar", "car"},
                {"interspecies", "interstellar", "interstate"},
                {"a"},
                {"", "b"},
                {"prefix", "prefixes", "prefetch"},
                {"apple", "apple", "apple"}
        };

        for (String[] test : testCases) {
            System.out.println("Input: " + String.join(", ", test));
            System.out.println("Brute:   " + longestCommonPrefixBrute(test));
            System.out.println("Better:  " + longestCommonPrefix(test));
            System.out.println("----");
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        StringBuilder result = new StringBuilder();
        Arrays.sort(strs);
        char[] first = strs[0].toCharArray();
        char[]  last = strs[strs.length-1].toCharArray();
        int minLength = Math.min(first.length, last.length);
        for (int i = 0; i < minLength; i++) {
            if(first[i] != last[i]){
                break;
            }
            result.append(first[i]);
        }
        return result.toString();
    }
    public static String longestCommonPrefixBrute(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return prefix.toString();
                }
            }
            prefix.append(c);
        }
        return prefix.toString();
    }

}
