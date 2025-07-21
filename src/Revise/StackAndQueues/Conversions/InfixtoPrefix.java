package Revise.StackAndQueues.Conversions;
import java.util.Arrays;
import java.util.Stack;

public class InfixtoPrefix {
    public static void main(String[] args) {
        String s = ("(p+q)*(c-d)");
        System.out.println("Infix expression: " + s);
        System.out.print("Prefix expression: ");
        System.out.print(infixToPrefix(s));
    }
    static int precedance(char ch) {
        switch (ch) {
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

    static String reverse(char[] str,int start,int end){
        char temp;
        while(start < end){
            temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            start++;
            end--;
        }
        return String.valueOf(str);
    }
    static String infixToPostfix(String infix1){
        String exp = '(' + String.valueOf(infix1) + ')';
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
    static String infixToPrefix(String exp){

        int length = exp.length();

        String infix1 = reverse(exp.toCharArray(),0,length-1);
        char[] infix = infix1.toCharArray();
        for(int i = 0 ; i < length;i++){
            if(infix[i]== '('){
                infix[i] = ')';
            }else if(infix[i] == ')'){
                infix[i] = '(';
            }
        }
        String infixtoPostfix = infixToPostfix(String.valueOf(infix));

         String infixToprefix =  reverse(infixtoPostfix.toCharArray(),0,infixtoPostfix.length()-1);
         return infixToprefix;
    }
}
