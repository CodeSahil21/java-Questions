package Topics.DyanmicProgramming.TwoDandThreeDandGrids;
import java.util.*;
//https://leetcode.com/problems/minimum-falling-path-sum/description/
public class Quest6 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 10, 4},
                {100, 3, 2, 1},
                {1, 1, 20, 2},
                {1, 2, 2, 1}};

        // Call the getMaxPathSum function and print the result
        System.out.println(getMaxPathSumTabSpace(matrix));

    }
    static int getMaxPathSumRecursion(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxOverallSum = Integer.MIN_VALUE;

        // Start the recursive process for each cell in the last row
        // The result will be the max path sum from the first row to each cell in the last row
        for (int j = 0; j < cols; j++) {
            maxOverallSum = Math.max(maxOverallSum, getMaxPathSumRecursion(matrix, rows - 1, j));
        }

        return maxOverallSum;
    }
    private static int getMaxPathSumRecursion(int[][] matrix,int i, int j){
        if(j < 0 || j >= matrix[0].length){
            return Integer.MIN_VALUE;
        }
        if(i == 0 ){
            return matrix[0][j];
        }
        int left =  getMaxPathSumRecursion(matrix,i-1,j-1);
        int straight =  getMaxPathSumRecursion(matrix,i-1,j);
        int right = getMaxPathSumRecursion(matrix,i-1,j+1);

        return matrix[i][j] +Math.max(left, Math.max(straight, right));

    }
    static int getMaxPathSumMemo(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int maxOverallSum = Integer.MIN_VALUE;
        int[][] dp = new int[rows][cols];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        // Start the recursive process for each cell in the last row
        // The result will be the max path sum from the first row to each cell in the last row
        for (int j = 0; j < cols; j++) {
            maxOverallSum = Math.max(maxOverallSum, getMaxPathSumMemo(matrix, dp,rows - 1, j));
        }

        return maxOverallSum;
    }
    private static int getMaxPathSumMemo(int[][] matrix,int[][] dp,int i, int j){
        if(j < 0 || j >= matrix[0].length){
            return Integer.MIN_VALUE;
        }
        if(i == 0 ){
            return matrix[0][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int left = getMaxPathSumMemo(matrix,dp,i-1,j-1);
        int straight =  getMaxPathSumMemo(matrix,dp,i-1,j);
        int right = getMaxPathSumMemo(matrix,dp,i-1,j+1);

        return dp[i][j] = matrix[i][j] +Math.max(left, Math.max(straight, right));
    }
    static int getMaxPathSumTab(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] dp = new int[rows][cols];
        for (int j = 0; j < cols; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < rows ; i++) {
            for (int j = 0; j < cols; j++) {
                int up = matrix[i][j] + dp[i-1][j];
                int left = matrix[i][j];
                if(j-1>= 0){
                    left += dp[i-1][j-1];
                }
                int right = matrix[i][j];
                if(j+1 < cols){
                    right += dp[i-1][j+1];
                }
                dp[i][j] = Math.max(left,Math.max(right,up));
            }
        }
        int maxi = dp[rows-1][0];
        for (int i = 1; i < cols ; i++) {
            maxi = Math.max(maxi, dp[rows-1][i]);
        }
        return maxi;
    }
    static int getMaxPathSumTabSpace(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] dp = new int[cols];
        for (int j = 0; j < cols; j++) {
            dp[j] = matrix[0][j];
        }
        for (int i = 1; i < rows ; i++) {
            int[] temp = new int[cols];
            for (int j = 0; j < cols; j++) {
                int up = matrix[i][j] + dp[j];
                int left = matrix[i][j];
                if(j-1>= 0){
                    left += dp[j-1];
                }else{
                    left += (int) -1e9;
                }
                int right = matrix[i][j];
                if(j+1 < cols){
                    right += dp[j+1];
                }else{
                    right += (int) -1e9;
                }
                temp[j] = Math.max(left,Math.max(right,up));
            }
            dp = temp;
        }
        int maxi = dp[0];
        for (int i = 1; i < cols ; i++) {
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
    /*
    import java.util.Arrays;

static int getMinPathSum(int[][] matrix) {
    int n = matrix.length;
    int m = matrix[0].length;

    int dp[][] = new int[n][m];

    // Initializing the first row - base condition
    for (int j = 0; j < m; j++) {
        dp[0][j] = matrix[0][j];
    }

    // Calculate the minimum path sum for each cell in the matrix
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            // Path from the cell directly above
            int up = matrix[i][j] + dp[i - 1][j];

            // Path from the top-left diagonal cell
            int leftDiagonal = matrix[i][j];
            if (j - 1 >= 0) {
                leftDiagonal += dp[i - 1][j - 1];
            } else {
                // If the path is not possible, set to a very large value to ignore it
                leftDiagonal += (int) Math.pow(10, 9);
            }

            // Path from the top-right diagonal cell
            int rightDiagonal = matrix[i][j];
            if (j + 1 < m) {
                rightDiagonal += dp[i - 1][j + 1];
            } else {
                // If the path is not possible, set to a very large value to ignore it
                rightDiagonal += (int) Math.pow(10, 9);
            }

            // Store the minimum of the three paths in dp
            dp[i][j] = Math.min(up, Math.min(leftDiagonal, rightDiagonal));
        }
    }

    // Find the minimum value in the last row of dp
    int mini = Integer.MAX_VALUE;
    for (int j = 0; j < m; j++) {
        mini = Math.min(mini, dp[n - 1][j]);
    }

    return mini;
}
     */
    //

}
