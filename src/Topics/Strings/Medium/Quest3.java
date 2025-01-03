package Topics.Strings.Medium;

import java.util.HashMap;

//https://leetcode.com/problems/roman-to-integer/description/
public class Quest3 {
    public static void main(String[] args) {

    }
    public static int romanToInt(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        hm.put('I',1);
        hm.put('V',5);
        hm.put('X',10);
        hm.put('L',50);
        hm.put('C',100);
        hm.put('D',500);
        hm.put('M',1000);
        int ans =  hm.get(s.charAt(s.length()-1));
        for (int i = s.length()-2; i >= 0 ; i--) {
            if(hm.get(s.charAt(i)) < hm.get(s.charAt(i+1))){
                ans = ans - hm.get(s.charAt(i));
            }else{
                ans =ans+ hm.get(s.charAt(i));
            }
        }
        return ans;
    }
}
