package Revise.Strings.Easy;
import java.util.*;
public class Quest7 {

    public static boolean isAnagramOptimal(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26]; // assuming only lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int val : count) {
            if (val != 0) return false;
        }

        return true;
    }

    public static boolean isAnagramBrute(String s, String t) {
        if (s.length() != t.length()) return false;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

}
