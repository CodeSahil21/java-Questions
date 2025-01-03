package Topics.Strings.Medium;
import java.util.*;
//https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/description/
public class Quest2 {
    public static void main(String[] args) {

    }
    public static int maxDepth(String s) {
        int maxOpen = Integer.MIN_VALUE;
        int  countBracket = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '('){
                countBracket++;
            }else if(c == ')'){
                countBracket--;
            }
            maxOpen = Math.max(maxOpen,countBracket);
        }
        return maxOpen;
    }
}
