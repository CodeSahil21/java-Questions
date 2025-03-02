package Topics.StacksandQueues.Quest;
//https://leetcode.com/problems/remove-k-digits/description/
import java.util.*;
public class Quest10 {




    public String removeKDigits(String input, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            while (!st.isEmpty() && k > 0 && (st.peek() - '0') > (ch - '0')) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // Remove remaining digits if k > 0
        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) {
            return "0";
        }

        // Build the result in the correct order
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        // Remove trailing zeros (from the end of the string)
        int i = result.length() - 1;
        while (i >= 0 && result.charAt(i) == '0') {
            i--;
        }

        // Extract the valid number portion
        String trimmed = result.substring(0, i + 1);

        // If the trimmed string is empty, return "0"
        return trimmed.isEmpty() ? "0" : new StringBuilder(trimmed).reverse().toString();
    }


}
