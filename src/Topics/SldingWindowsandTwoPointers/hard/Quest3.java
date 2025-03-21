package Topics.SldingWindowsandTwoPointers.hard;
//https://leetcode.com/problems/minimum-window-substring/description/
public class Quest3 {
    public static void main(String[] args) {

    }
    public static  String minWindow(String s, String t) {
            int left = 0;
            int right = 0;
            int[] hash = new int[256];
            int minLen = Integer.MAX_VALUE;
            int sIndex = -1;
            int count = 0;
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }
        while(right< s.length()){
            if(hash[s.charAt(right)]>0){
                count ++;
            }
            hash[s.charAt(right)]--;
            while(count == t.length()){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                    sIndex = left;
                }
                hash[s.charAt(left)]++;
                if(hash[s.charAt(left)] > 0){
                    count--;
                }
                left++;
            }
            right += 1;
        }
        return  sIndex == -1 ? "":s.substring(sIndex,sIndex+minLen);
    }
}
