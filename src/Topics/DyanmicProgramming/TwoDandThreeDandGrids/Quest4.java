package Topics.DyanmicProgramming.TwoDandThreeDandGrids;
import java.util.*;
//https://leetcode.com/problems/minimum-path-sum/description/
public class Quest4 {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println("The minimum path sum is (Recursive): " + minPathSum(grid));
    }
    public  static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
      return minPathSumRecursive(m-1,n-1,grid);
    }
    private static int minPathSumRecursive(int i, int j,int[][] grid){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        if(i < 0 || j < 0){
            //we will return  bigger value because 0 will be considered min
            return Integer.MAX_VALUE;
        }
        int up = grid[i][j] + minPathSumRecursive(i-1,j,grid);
        int left = grid[i][j] + minPathSumRecursive(i,j-1,grid);
        return Math.min(up,left);
    }
    //since there are overLapping subProblem hence Memoization
    public  static int minPathSumMemo(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n ; j++) {
                dp[i][j] = -1;
            }
        }
        return minPathSumMemo(m-1,n-1,grid,dp);
    }
    private static int minPathSumMemo(int i, int j,int[][] grid,int[][] dp){
        if(i == 0 && j == 0){
            return grid[0][0];
        }
        if(i < 0 || j < 0){
            //we will return  bigger value because 0 will be considered min
            return Integer.MAX_VALUE;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = grid[i][j] + minPathSumMemo(i-1,j,grid,dp);
        int left = grid[i][j] + minPathSumMemo(i,j-1,grid,dp);
        return dp[i][j] = Math.min(up,left);
    }
    //tabulation
    public static int minPathSumTab(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    dp[i][j] = grid[i][j];
                }else {
                    int up =  grid[i][j];

                    if(i > 0){
                        up += dp[i-1][j];
                    }else{
                        up += (int) Math.pow(10,9);
                    }
                    int  left = grid[i][j];

                    if(j > 0){
                        left += dp[i][j-1];
                    }else{
                        left += (int) Math.pow(10,9);
                    }
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[m-1][n-1];
    }

    public static int minPathSumTabSpace(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    temp[j] = grid[i][j];
                }else {
                    int up =  grid[i][j];

                    if(i > 0){
                        up += prev[j];
                    }else{
                        up += (int) Math.pow(10,9);
                    }
                    int  left = grid[i][j];

                    if(j > 0){
                        left += temp[j-1];
                    }else{
                        left += (int) Math.pow(10,9);
                    }
                    temp[j] = Math.min(up,left);
                }
            }
            prev = temp;
        }
        return prev[n-1];
    }
}
