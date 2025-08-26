package Revise.greedyalgo.easy;

import java.util.Arrays;

public class Quest1 {
    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};
        System.out.println(findContentChildren(g, s)); // Output: 1
    }
    static int findContentChildren(int[] g,int[] s){
        Arrays.sort(g);
        Arrays.sort(s);

        int left = 0;
        int right = 0;
        while(left < g.length && right < s.length){
            if(s[right] >= g[left]){
                left++;
            }
            right++;
        }
        return left;
    }
}
