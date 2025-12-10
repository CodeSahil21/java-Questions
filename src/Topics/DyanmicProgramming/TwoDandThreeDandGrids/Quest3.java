package Topics.DyanmicProgramming.TwoDandThreeDandGrids;

public class Quest3 {
    public static void main(String[] args) {
        // Sample grid with an obstacle
        int[][] obstacleGrid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Recursive : " + uniquePathsWithObstacles(obstacleGrid1));
        System.out.println("Memoization : " + uniquePathsWithObstaclesMemo(obstacleGrid1));
    }
    public  static  int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return uniquePathsWithObstaclesRecursive(m - 1, n - 1,obstacleGrid);
    }
    private static  int uniquePathsWithObstaclesRecursive(int i , int j,int[][] obstacleGrid ){
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        if( i == 0 && j ==0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        int up = uniquePathsWithObstaclesRecursive(i-1,j,obstacleGrid);
        int left = uniquePathsWithObstaclesRecursive(i,j-1,obstacleGrid);
        return up + left;
    }
    public  static  int uniquePathsWithObstaclesMemo(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1){
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return uniquePathsWithObstaclesMemo(m - 1, n - 1,obstacleGrid,dp);
    }
    private static  int uniquePathsWithObstaclesMemo(int i , int j,int[][] obstacleGrid,int[][] dp ){
        if(i >= 0 && j >= 0 && obstacleGrid[i][j] == 1){
            return 0;
        }
        if( i == 0 && j == 0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = uniquePathsWithObstaclesMemo(i-1,j,obstacleGrid,dp);
        int left = uniquePathsWithObstaclesMemo(i,j-1,obstacleGrid,dp);
        return dp[i][j] = up + left;
    }
    public static  int uniquePathsWithObstaclesTab(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else if(i == 0 && j == 0){
                    dp[i][j] = 1;
                }else  {
                    int up = 0;
                    int left  = 0;
                    if(i > 0) {
                        up = dp[i - 1][j];
                    }
                    if(j > 0) {
                        left = dp[i][j - 1];
                    }
                    dp[i][j] = up + left;
                }

            }
        }
        return dp[m-1][n-1];
    }

    public static  int uniquePathsWithObstaclesTabSpace(int[][] obstacleGrid){
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[]  prev = new int[m];
        for (int i = 0; i < m ; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    temp[j] = 0; // If there's an obstacle, no paths can go through here.
                    continue;
                }
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }

                    int up = 0;
                    int left  = 0;
                    if(i > 0) {
                        //previous row
                        up = prev[j];
                    }
                    if(j > 0) {
                        //current row
                        left = temp[j - 1];
                    }
                    temp[j] = up + left;

            }
            prev = temp;
        }
        return prev[n-1];
    }
}
