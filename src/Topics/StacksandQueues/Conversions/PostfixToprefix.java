package Topics.StacksandQueues.Conversions;
import java.util.*;
public class PostfixToprefix {
    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Method to convert postfix expression to prefix expression
    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (!isOperator(c)) {
                // Push operand to stack
                stack.push(c + "");
            } else {
                // Pop two operands and combine with operator in prefix format
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = c + operand1 + operand2;
                stack.push(expression);
            }
        }

        // Final prefix expression
        return stack.pop();
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        String prefix = convert(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }
}

