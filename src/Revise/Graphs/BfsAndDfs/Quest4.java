package Revise.Graphs.BfsAndDfs;

import java.util.LinkedList;
import java.util.Queue;

class Pair1{
    int row;
    int col;
    int tm;
    Pair1(int row,int col,int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
public class Quest4 {
    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid)); // Output: 4
    }
    public static int  orangesRotting(int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair1> q = new LinkedList<>();
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        int tm = 0;
        int cnt = 0;
        int cntFresh = 0;
        for(int i = 0 ;i < n;i++){
            for(int j =0 ; j < m;j++){
                if(grid[i][j]== 2){
                    q.add(new Pair1(i,j,0));
                    vis[i][j] = true;
                }else{
                    vis[i][j] = false;
                }
                if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int t = q.peek().tm;
            q.poll();
            tm = Math.max(t,tm);
            for(int i = 0 ; i < 4;i++){
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if(nrow >=0  && nrow < n && ncol >=0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = true;
                    q.add(new Pair1(nrow,ncol,t+1));
                    cnt++;
                }
            }

        }
        if(cnt == cntFresh){
            return tm;
        }else{
            return -1;
        }
    }
}
