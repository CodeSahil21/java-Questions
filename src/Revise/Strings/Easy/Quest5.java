package Revise.Strings.Easy;

import java.util.HashMap;
import java.util.Map;

public class Quest5 {

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
