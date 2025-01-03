package Topics.Strings.Easy;
//https://leetcode.com/problems/remove-outermost-parentheses/description/
import java.util.*;
public class Quest1 {
    public static void main(String[] args) {
        String input = "(()())(())";
        String output = removeOuterParentheses(input);
        System.out.println("Output: " + output);
    }
    public static String removeOuterParentheses(String s) {
     int count = 0;
     StringBuilder ans = new StringBuilder();
     for(int i = 0 ; i < s.length();i++){
         if(s.charAt(i) == ')'){
             count--;
         }
         if(count != 0){
             ans.append(s.charAt(i));
         }
         if(s.charAt(i) == '('){
             count++;
         }
     }
     return ans.toString();
    }

}
