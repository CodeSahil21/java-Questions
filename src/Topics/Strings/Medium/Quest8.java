package Topics.Strings.Medium;
//https://leetcode.com/problems/reverse-words-in-a-string/
public class Quest8 {
    public  String reverseWords(String s) {
        int i  = s.length()-1;
        StringBuilder ans = new StringBuilder();
        while(i >= 0){
            while(i >= 0 && s.charAt(i) == ' '){
                i--;
            }
            int j = i;
            if( i < 0 ){
                break;
            }
            while(i >= 0 && s.charAt(i) != ' '){
                i--;
            }
            if(!ans.isEmpty()){
                ans.append(' ');
            }
            ans.append(s, i + 1, j + 1);
        }
        return ans.toString();
    }
}
