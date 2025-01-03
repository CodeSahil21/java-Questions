package Topics.Strings.Easy;
//https://leetcode.com/problems/rotate-string/
public class Quest6 {
    public static void main(String[] args) {

    }
    public static boolean rotateString(String s, String goal) {
       String whole = s+s;
       if(s.length() != goal.length()){
           return  false;
       }
       if(!whole.contains(goal)){
           return false;
       }else{
           return  true;
       }
    }
}
