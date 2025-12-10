package Topics.DyanmicProgramming.Strings;

import java.util.Arrays;

public class Quest9 {
    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";

        System.out.println("The minimum number of operations required is: " +
                editDistanceRecursion(s1, s2));
    }
    static int editDistanceRecursion(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
     return editDistanceRecursion(n-1,m-1,s1,s2);
    }
    static int editDistanceRecursion(int ind1 ,int ind2,String s1,String s2){
        if(ind1 < 0){
            return ind2 +1;
        }
        if(ind2 < 0){
           return ind1 + 1;
        }

        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return editDistanceRecursion(ind1-1,ind2-1,s1,s2);
        }else{
           int insert = 1 + editDistanceRecursion(ind1,ind2-1,s1,s2);
           int delete = 1+ editDistanceRecursion(ind1-1,ind2,s1,s2);
           int replace = 1 + editDistanceRecursion(ind1-1,ind2-1,s1,s2);
           return Math.min(Math.min(insert,delete),replace);
        }
    }

    static int editDistanceMemo(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return editDistanceMemo(n-1,m-1,s1,s2,dp);
    }
    static int editDistanceMemo(int ind1 ,int ind2,String s1,String s2,int[][] dp){
        if(ind1 < 0){
            return ind2 +1;
        }
        if(ind2 < 0){
            return ind1 + 1;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1) == s2.charAt(ind2)){
            return dp[ind1][ind2] = editDistanceMemo(ind1-1,ind2-1,s1,s2,dp);
        }else{
            int insert = 1 + editDistanceMemo(ind1,ind2-1,s1,s2,dp);
            int delete = 1+ editDistanceMemo(ind1-1,ind2,s1,s2,dp);
            int replace = 1 + editDistanceMemo(ind1-1,ind2-1,s1,s2,dp);
            return dp[ind1][ind2] = Math.min(Math.min(insert,delete),replace);
        }
    }
    /*
        static int editDistanceMemo(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return editDistanceMemo(n,m,s1,s2,dp);
    }
    static int editDistanceMemo(int ind1 ,int ind2,String s1,String s2,int[][] dp){
        if(ind1 == 0){
            return ind2 +1;
        }
        if(ind2 == 0){
            return ind1 + 1;
        }
        if(dp[ind1][ind2] != -1){
            return dp[ind1][ind2];
        }
        if(s1.charAt(ind1-1) == s2.charAt(ind2-1)){
            return dp[ind1][ind2] = editDistanceMemo(ind1-1,ind2-1,s1,s2,dp);
        }else{
            int insert = 1 + editDistanceMemo(ind1,ind2-1,s1,s2,dp);
            int delete = 1+ editDistanceMemo(ind1-1,ind2,s1,s2,dp);
            int replace = 1 + editDistanceMemo(ind1-1,ind2-1,s1,s2,dp);
            return dp[ind1][ind2] = Math.min(Math.min(insert,delete),replace);
        }
    }
     */


    static int editDistanceTab(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for(int j = 0; j <= m ;j++){
            dp[0][j] = j;
        }
        for(int i = 0 ; i <= n;i++){
            dp[i][0] = i;
        }
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=m; j++) {
               if(s1.charAt(i-1)==s2.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1];
               }else{
                   int insert = 1 + dp[i][j-1];
                   int delete = 1 + dp[i-1][j];
                   int replace = 1 + dp[i-1][j-1];
                   dp[i][j] = Math.min(Math.min(insert,delete),replace);
               }
            }
        }
     return dp[n][m];
   }
    static int editDistanceTabSpace(String s1, String s2){
        int n = s1.length();
        int m = s2.length();
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        for(int j = 0; j <= m ;j++){
            prev[j] = j;
        }

        for (int i = 1; i <= n ; i++) {
            curr[0] = i;
            for (int j = 1; j <=m; j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    int insert = 1 + curr[j-1];
                    int delete = 1 + prev[j];
                    int replace = 1 + prev[j-1];
                    curr[j] = Math.min(Math.min(insert,delete),replace);
                }
            }
            prev = curr.clone();
        }
        return prev[m];
    }
}
