package Revise.StackAndQueues.Conversions;

import java.util.Stack;

public class PostfixToPrefix {
    public static void main(String[] args) {
        String postfix = "AB-DE+F*/";
        String prefix = convert(postfix);
        System.out.println("Postfix: " + postfix);
        System.out.println("Prefix: " + prefix);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    static  String convert(String exp){
        Stack<String> st = new Stack<>();
        for(int i  = 0  ; i < exp.length();i++){
            char c = exp.charAt(i);
            if(!isOperator(c)){
                st.push(c + "");
            }else{
                String operand2  = st.pop();
                String operand1 = st.pop();
                String expression = c + operand1 + operand2;
                st.push(expression);
            }
        }
        return st.pop();
    }
}
