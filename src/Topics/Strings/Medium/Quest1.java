package Topics.Strings.Medium;
import java.util.*;
//https://leetcode.com/problems/sort-characters-by-frequency/description/
public class Quest1 {
    public static void main(String[] args) {

    }
    public static String frequencySort(String s) {
       Map<Character,Integer> map = new HashMap<>();
       for(int i = 0; i< s.length();i++){
           char c = s.charAt(i);
           if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
           }else{
               map.put(c,1);
           }
       }
       List<Character> list = new ArrayList<>(map.keySet());
       Collections.sort(list,(a,b)->map.get(b)- map.get(a));
       StringBuilder ans = new StringBuilder();
       for (Character ch: list){
           for (int i = 0; i < map.get(ch); i++) {
               ans.append(ch);
           }
       }
       return ans.toString();
    }
}
