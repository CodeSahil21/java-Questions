package Revise.Graphs.BfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

class Pair3 {
    int first;
    int second;
    int third;
    Pair3(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class Quest7 {
    public static void main(String[] args) {
        int[][] grid = {
                {0,1,1,0},
                {1,1,0,0},
                {0,0,0,0}
        };
        int[][] ans = updateMatrix(grid);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
    public static int[][] updateMatrix(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        int[][] dis = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair3> q = new LinkedList<>();
        for(int i = 0 ;i < n;i++){
            for(int j =0 ;j < m;j++){
                if(grid[i][j] == 1){
                    vis[i][j] = true;
                    q.add(new Pair3(i,j,0));
                }
            }
        }
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.poll();
            dis[row][col] = steps;
            for(int i =0 ;i < 4;i++){
                int nrow = row +delrow[i];
                int ncol = col + delcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol]){
                    vis[nrow][ncol] = true;
                    q.add(new Pair3(nrow,ncol,steps+1));
                }
            }
        }
        return dis;
    }
}
