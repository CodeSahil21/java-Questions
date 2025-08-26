package Revise.greedyalgo.medium;

import java.util.ArrayList;
import java.util.List;

public class Quest7 {
    public static void main(String[] args) {

    }
     public static int[][] insert(int[][] interval,int[] newinterval){
        int i = 0;
        int n = interval.length;
        List<int[]> ans = new ArrayList<>();
        while( i < n && interval[i][1] <  newinterval[0]){
            ans.add(interval[i]);
            i++;
        }
        while( i < n && interval[i][0] <= newinterval[1]){
            newinterval[0] = Math.min(newinterval[0],interval[i][0]);
            newinterval[1] = Math.max(newinterval[1],interval[i][1]);
            i++;
        }
        ans.add(newinterval);
        while(i < n ){
            ans.add(interval[i]);
            i++;
        }
        return ans.toArray(new int[ans.size()][]);

     }
}
