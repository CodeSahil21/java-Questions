package Topics.Strings.Easy;
//https://leetcode.com/problems/isomorphic-strings/description/
import java.util.*;
public class Quest5 {
    public static void main(String[] args) {
// Example 1: Isomorphic (true)
        String s1 = "egg";
        String t1 = "add";
        System.out.println("\"" + s1 + "\" and \"" + t1 + "\" are isomorphic: " + isIsomorphic(s1, t1));

        // Example 2: Not Isomorphic (false) - 'o' maps to 'a' and 'r'
        String s2 = "foo";
        String t2 = "bar";
        System.out.println("\"" + s2 + "\" and \"" + t2 + "\" are isomorphic: " + isIsomorphic(s2, t2));

        // Example 3: Isomorphic (true)
        String s3 = "paper";
        String t3 = "title";
        System.out.println("\"" + s3 + "\" and \"" + t3 + "\" are isomorphic: " + isIsomorphic(s3, t3));

        // Example 4: Not Isomorphic (false) - 'a' and 'b' both map to 'c'
        String s4 = "ab";
        String t4 = "cc";
        System.out.println("\"" + s4 + "\" and \"" + t4 + "\" are isomorphic: " + isIsomorphic(s4, t4));

        // Example 5: Not Isomorphic (false) - different lengths
        String s5 = "a";
        String t5 = "ab";
        System.out.println("\"" + s5 + "\" and \"" + t5 + "\" are isomorphic: " + isIsomorphic(s5, t5));
    }
    public static boolean isIsomorphic(String s, String t) {
          if(s.length() != t.length()){
              return false;
          }
          Map<Character,Character> Result= new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);
            if(!Result.containsKey(original)){
                if(!Result.containsValue(replacement)){
                    Result.put(original,replacement);
                }else{
                    return false;
                }
            }else{
                char Mappedcharacter = Result.get(original);
                if(Mappedcharacter != replacement){
                    return false;
                }
            }
        }
        return true;
    }
}
