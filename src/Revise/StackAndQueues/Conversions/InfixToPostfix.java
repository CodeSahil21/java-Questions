package Revise.StackAndQueues.Conversions;

import java.util.Stack;

public class InfixToPostfix {
    // Driver method
    public static void main(String[] args) {
        String exp = "(p+q)*(m-n)";
        System.out.println("Infix expression: " + exp);
        System.out.println("Prefix expression: " + infixToPostfix(exp));
    }

    static int precedance(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    static String infixToPostfix(String exp){

        StringBuilder ans = new StringBuilder();
        Stack<Character> st  = new Stack<>();
        for(int i = 0 ; i < exp.length();i++){
            char c = exp.charAt(i);
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }else if(c == '('){
                st.push(c);
            }else if(c ==')'){
                while(!st.isEmpty() && st.peek() != '('){
                    ans.append(st.pop());
                }
                st.pop();
            }else{
                while(!st.isEmpty() && precedance(c) <= precedance(st.peek())){
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }
        while(!st.isEmpty()){
            if(st.peek() == '('){
                return "Invalid Expression";
            }
            ans.append(st.pop());
        }

        return ans.toString();
    }
}
