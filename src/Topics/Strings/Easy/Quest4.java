package Topics.Strings.Easy;
//https://leetcode.com/problems/longest-common-prefix/description/
import java.util.*;
public class Quest4 {
    public static void main(String[] args) {

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
}
