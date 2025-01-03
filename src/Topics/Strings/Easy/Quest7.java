package Topics.Strings.Easy;

import java.util.*;

//https://leetcode.com/problems/valid-anagram/description/
public class Quest7 {
    public static void main(String[] args) {

    }
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }             s = s.toLowerCase();
             t = t.toLowerCase();
             s=s.replace(" ","");
             t=t.replace(" ","");
             int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)-'a']--;
        }
        for (int i = 0; i < count.length; i++) {
            if(count[i] != 0){
                return false;
            }
        }
        return true;
    }
}
