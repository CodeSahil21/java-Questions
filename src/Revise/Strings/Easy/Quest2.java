package Revise.Strings.Easy;

public class Quest2 {
    public static void main(String[] args) {
        String str = "Hello, World! How are you?";
        String reversedWordsStr = reverseWords(str);
        System.out.println("Original String: " + str);
        System.out.println("Reversed Words String: "+ reversedWordsStr);
    }

    static String reverseWords(String input){
        int i = input.length() - 1;
        StringBuilder ans = new StringBuilder();
        while(i >= 0){
            while(i >=0 && input.charAt(i) == ' '){
                i--;
            }
            int j= i;
            if(i < 0){
                break;
            }
            while(i >= 0 && input.charAt(i) != ' '){
                i--;
            }
            if(!ans.isEmpty()){
                ans.append(' ');
            }
            ans.append(input,i+1,j+1);
        }
        return  ans.toString();
    }
}
