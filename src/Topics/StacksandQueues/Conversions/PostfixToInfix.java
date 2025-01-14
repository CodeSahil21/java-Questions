package Topics.StacksandQueues.Conversions;
import java.util.*;
public class PostfixToInfix {
    // Method to check if a character is an operator
    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    // Method to convert postfix expression to infix expression
    public static String convert(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char c : postfix.toCharArray()) {
            if (!isOperator(c)) {
                // Push operand to stack
                stack.push(c + "");
            } else {
                // Pop two operands and combine with operator
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = "(" + operand1 + c + operand2 + ")";
                stack.push(expression);
            }
        }

        // Final infix expression
        return stack.pop();
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        String infix = convert(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Infix: " + infix);
    }
}

