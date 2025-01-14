package Topics.StacksandQueues.Conversions;
import java.util.*;
public class PrefixToPostfix {
    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Method to convert prefix expression to postfix expression
    public static String convert(String prefix) {
        Stack<String> stack = new Stack<>();

        for (int i = prefix.length() - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (!isOperator(c)) {
                // Push operand to stack
                stack.push(c + "");
            } else {
                // Pop two operands and combine with operator in postfix format
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String expression = operand1 + operand2 + c;
                stack.push(expression);
            }
        }

        // Final postfix expression
        return stack.pop();
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        String prefix = "/-AB*+DEF";
        String postfix = convert(prefix);
        System.out.println("Prefix: " + prefix);
        System.out.println("Postfix: " + postfix);
    }
}

