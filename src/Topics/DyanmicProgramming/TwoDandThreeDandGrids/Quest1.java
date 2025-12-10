package Topics.DyanmicProgramming.TwoDandThreeDandGrids;

import java.util.Arrays;

//https://takeuforward.org/data-structure/dynamic-programming-ninjas-training-dp-7/
public class Quest1 {
    public static void main(String[] args) {
        int[][] points = {
                {10, 40, 70},
                {20, 50, 80},
                {30, 60, 90}
        };


        System.out.println("Maximum merit points (Recursive solution): " + ninjaTrainingR(points.length, points));
        System.out.println("Maximum merit points (Memoization solution): " + ninjaTrainingMemo(points.length, points));
        System.out.println("Maximum merit points (Tabulation solution): " + ninjaTrainingTabulation(points.length, points));
        System.out.println("Maximum merit points (Tabulation solution): " + ninjaTrainingTabulationSpace(points.length, points));
    }
    static  int ninjaTrainingR(int n ,int[][] points){
        return ninjaTrainingR(n-1,points,3);//3 signify none of the task is performed
    }
    private static  int ninjaTrainingR(int day ,int[][] points,int last){
        if(day == 0){
            int maxPoints = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxPoints = Math.max(maxPoints, points[0][i]);
                }
            }
            return  maxPoints;
        }
        int maxTotalPoints  =0 ;
        for(int i = 0 ; i < 3;i++){
            if(i != last){
                int currPoints = points[day][i] + ninjaTrainingR(day-1,points,i);
                maxTotalPoints = Math.max(maxTotalPoints,currPoints);
            }
        }
        return maxTotalPoints;
    }
    static  int ninjaTrainingMemo(int n ,int[][] points){
        int[][] dp = new int[n][4];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return ninjaTrainingMemo(n-1,points,3,dp);//3 signify none of the task is performed
    }
    private static  int ninjaTrainingMemo(int day ,int[][] points,int last,int[][] dp){
        if(day == 0){
            int maxPoints = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    maxPoints = Math.max(maxPoints, points[0][i]);
                }
            }
            return  maxPoints;
        }
        if(dp[day][last] != -1){
            return  dp[day][last];
        }
        int maxTotalPoints  =0 ;
        for(int i = 0 ; i < 3;i++){
            if(i != last){
                int currPoints = points[day][i] + ninjaTrainingMemo(day-1,points,i,dp);
                maxTotalPoints = Math.max(maxTotalPoints,currPoints);
            }
        }
        return dp[day][last] = maxTotalPoints;
    }
    static  int ninjaTrainingTabulation(int n ,int[][] points){
        int[][] dp = new int[n][4];
        dp[0][0] = Math.max(points[0][1],points[0][2]);
        dp[0][1] = Math.max(points[0][0],points[0][2]);
        dp[0][2] = Math.max(points[0][1],points[0][0]);
        dp[0][3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for (int day = 1; day < n; day++) {
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if(task != last){
                        int point = points[day][task] + dp[day-1][task];
                        dp[day][last] = Math.max(dp[day][last],point);
                    }
                }
            }
        }
        return dp[n-1][3];
    }
    static  int ninjaTrainingTabulationSpace(int n ,int[][] points){
        int[] prev= new int[4];
        prev[0] = Math.max(points[0][1],points[0][2]);
        prev[1] = Math.max(points[0][0],points[0][2]);
        prev[2] = Math.max(points[0][1],points[0][0]);
        prev[3] = Math.max(points[0][0],Math.max(points[0][1],points[0][2]));

        for (int day = 1; day < n; day++) {
            int[] temp = new int[4];
            for (int last = 0; last < 4; last++) {
                for (int task = 0; task < 3; task++) {
                    if(task != last){
                        temp[last] = Math.max(temp[last], points[day][task] + prev[task]);
                    }
                }
            }
            prev = temp;
        }
        return prev[3];
    }
}
