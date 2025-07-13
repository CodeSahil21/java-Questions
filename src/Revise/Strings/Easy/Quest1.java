package Revise.Strings.Easy;

public class Quest1 {
    public static void main(String[] args) {
        String input = "(()())(())";
        String output = removeOuterParentheses(input);
        System.out.println("Output: " + output);
    }

    static String removeOuterParentheses(String input){
        int count = 0;
        StringBuilder result = new StringBuilder();
        for(int i = 0 ;  i < input.length();i++){
            if(input.charAt(i) == ')'){
                count--;
            }
            if(count != 0 ){
                result.append(input.charAt(i));
            }
            if(input.charAt(i) == '('){
                count++;
            }
        }
        return result.toString();
    }
}
