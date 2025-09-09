package Revise.Graphs.BfsAndDfs;

import java.util.LinkedList;
import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class Quest2 {

    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'},
                {'1', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid)); // Output: 3
    }

    public static int numIslands(char[][] grid){
        int n = grid.length;;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;
        for(int i  = 0 ; i < n;i++){
            for(int j = 0 ;j < m;j++){
                if(vis[i][j] == 0 && grid[i][j] == '1' ){
                    count++;
                    bfs(i,j,vis,grid);
                }
            }
        }
        return count;
    }
    public static void  bfs(int row, int col, int[][] vis, char[][] grid){
         vis[row][col] = 1;
         Queue<Pair> q = new LinkedList<>();
         int n = grid.length;
         int m = grid[0].length;
         q.add(new Pair(row,col));
         while(!q.isEmpty()){
             int ro  =  q.peek().first;
             int co = q.peek().second;
             q.poll();
             for(int delrow = -1; delrow <= 1; delrow++)
                for(int delcol = -1; delcol <= 1;delcol++){
                    int nrow = ro+delrow;
                    int ncol = co + delcol ;
                    if(nrow >= 0 && nrow<n && ncol>=0 && ncol<m &&vis[nrow][ncol] == 0 && grid[nrow][ncol] == '1'){
                        vis[nrow][ncol] = 1;
                        q.add(new Pair(nrow,ncol));
                    }
                }
         }
    }
}
