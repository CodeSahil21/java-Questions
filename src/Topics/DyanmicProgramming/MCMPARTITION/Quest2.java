package Topics.DyanmicProgramming.MCMPARTITION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/minimum-cost-to-cut-a-stick/
public class Quest2 {
    public static void main(String[] args) {
        int[] cuts = {3, 5, 1, 4};
        int n = 7;
        System.out.println("The minimum cost incurred is: " + minimumCost(cuts,n));
    }

    static  int minimumCost(int[] arr,int c){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int cut :arr){
            list.add(cut);
        }
        list.add(c);
        Collections.sort(list);
        return  minimumCost(1, list.size()-2,list);
    }
    static int minimumCost(int i,int j, List<Integer> cuts){
        if(i > j){
            return 0;
        }
        int mini= Integer.MAX_VALUE;
        for (int k = i; k <= j ; k++) {
            int cost = cuts.get(j+1) - cuts.get(i-1) + minimumCost(i,k-1,cuts) +  minimumCost(k+1,j,cuts);
            mini = Math.min(mini,cost);
        }
        return mini;
    }
    static  int minimumCostMemo(int[] arr,int c){
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int cut :arr){
            list.add(cut);
        }
        list.add( c);
        Collections.sort(list);
        int M = list.size()-2;
        int[][] dp = new int[M+2][M+2];
        for (int [] a:dp) {
            Arrays.fill(a,-1);
        }
        return  minimumCostMemo(1, M,list,dp);
    }
    static int minimumCostMemo(int i,int j, List<Integer> cuts,int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int mini= Integer.MAX_VALUE;
        for (int k = i; k <= j ; k++) {
            int cost = cuts.get(j+1) - cuts.get(i-1) + minimumCostMemo(i,k-1,cuts,dp) +  minimumCostMemo(k+1,j,cuts,dp);
            mini = Math.min(mini,cost);
        }
        return dp[i][j] = mini;
    }
    static int minimumCostTab(int[] arr, int n) {
        List<Integer> cuts = new ArrayList<>();
        cuts.add(0);
        for (int cut : arr) {
            cuts.add(cut);
        }
        cuts.add(n);
        Collections.sort(cuts);

        int M = cuts.size();
        int c = arr.length;

        int[][] dp = new int[M][M];

        for (int i = c; i >= 1; i--) {
            for (int j = 1; j <= c; j++) {

                if (i >= j || j - i == 1) {
                    continue;
                }

                int mini = Integer.MAX_VALUE;

                for (int k = i + 1; k < j; k++) {

                    int currentSegmentCost = cuts.get(j) - cuts.get(i);

                    int totalCost = currentSegmentCost + dp[i][k] + dp[k][j];

                    mini = Math.min(mini, totalCost);
                }

                dp[i][j] = mini;
            }
        }

        return dp[0][M - 1];
    }
}
