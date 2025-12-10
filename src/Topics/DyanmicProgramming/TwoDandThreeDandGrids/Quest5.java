package Topics.DyanmicProgramming.TwoDandThreeDandGrids;
import java.util.*;
//https://leetcode.com/problems/triangle/
public class Quest5 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        int result = minimumTotal(triangle);
        System.out.println("The minimum path sum is (Recursive): " + result);
    }
    public static int minimumTotal(List<List<Integer>> triangle) {
       int n = triangle.size();
       return minimumTotalRecursive(triangle,0,0,n);
    }
    private static int minimumTotalRecursive(List<List<Integer>> triangle,int i , int j,int n){
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        int down = triangle.get(i).get(j) + minimumTotalRecursive(triangle,i+1,j,n);
        int diagonal = triangle.get(i).get(j) + minimumTotalRecursive(triangle,i+1,j+1,n);
        return Math.min(down,diagonal);
    }

    public static int minimumTotalMemo(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return minimumTotalMemo(triangle,0,0,n,dp);
    }
    private static int minimumTotalMemo(List<List<Integer>> triangle,int i , int j,int n,int[][] dp){
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if(i == n-1){
            return triangle.get(n-1).get(j);
        }
        int down = triangle.get(i).get(j) + minimumTotalMemo(triangle,i+1,j,n,dp);
        int diagonal = triangle.get(i).get(j) + minimumTotalMemo(triangle,i+1,j+1,n,dp);
        return dp[i][j] =  Math.min(down,diagonal);
    }
//

    public int minimumTotalTab(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Create a 2D array to store intermediate results
        int[][] dp = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle.get(n - 1).get(j);
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle.get(i).get(j) + dp[i + 1][j];
                int diagonal = triangle.get(i).get(j) + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The result is stored at the top of dp array
        return dp[0][0];
    }
    //
    public int minimumTotalTabSpace(List<List<Integer>> triangle) {
        int n = triangle.size();

        // Create a 2D array to store intermediate results
        int[] cur = new int[n];
        int[] front = new int[n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            front[j] = triangle.get(n - 1).get(j);
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle.get(i).get(j) + front[j];
                int diagonal = triangle.get(i).get(j) + front[j + 1];

                // Store the minimum of the two paths in dp
                cur[j] = Math.min(down, diagonal);
            }
            front = cur.clone();
        }

        // The result is stored at the top of dp array
        return front[0];
    }
}
