package Topics.DyanmicProgramming.TwoDandThreeDandGrids;

public class Quest2 {
    public static void main(String[] args) {
        int m1 = 3;
        int n1 = 7;
        int paths1 = uniquePaths(m1, n1);
        System.out.println("Recursive : " + paths1);
        System.out.println("Memoization : " + uniquePathsMemo(m1,n1));
        System.out.println("Tabulation : " + uniquePathsTab(m1,n1));
        System.out.println("Tabulation Space Optimized : " + uniquePathsTabSpace(m1,n1));
    }
    //2^m*n
    public static int uniquePaths(int m, int n) {
        return uniquePathsRecursive(m - 1, n - 1);
    }
    private static  int uniquePathsRecursive(int i , int j ){
        if( i == 0 && j ==0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        int up = uniquePathsRecursive(i-1,j);
        int left = uniquePathsRecursive(i,j-1);
        return up + left;
    }
    //mxn
    public static int uniquePathsMemo(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return uniquePathsMemo(m - 1, n - 1,dp);
    }
    private static  int uniquePathsMemo(int i , int j,int[][] dp){
        if( i == 0 && j ==0){
            return 1;
        }
        if(i < 0 || j < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int up = uniquePathsMemo(i-1,j,dp);
        int left = uniquePathsMemo(i,j-1,dp);
        return  dp[i][j] = up + left;
    }

    public static  int uniquePathsTab(int m , int n){
        int[][] dp = new int[m][n];
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
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

    public static  int uniquePathsTabSpace(int m , int n){
        int[]  prev = new int[n];
        for (int i = 0; i < m ; i++) {
            int[] temp = new int[n];
            for (int j = 0; j < n; j++) {
                if(i == 0 && j == 0){
                    temp[j] = 1;
                    continue;
                }else  {
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
            }
            prev = temp;
        }
        return prev[n-1];
    }

}
