package Topics.SldingWindowsandTwoPointers;

import java.util.*;
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Prac {


}

 class BinaryTree {
     public BinaryTree() {
    }

    public int[][] Quest(int[][] image,int sr,int sc,int newcolor){
     int iniColor = image[sr][sc];
     boolean[][] vis = new boolean[image.length][image[0].length];
     int[][] ans = image;
     int[] delrow = {-1,0,1,0};
     int[] delcol = {0,1,0,-1};
     dfs(sr,sc,vis,image,ans,delcol,delcol,iniColor,newcolor);
     return  ans;
    }
    public static void dfs(int sr, int sc,boolean[][] vis,int[][] image,int[][] ans,int[] delrow,int[] delcol,int iniColor,int newColor){
         vis[sr][sc] = true;
         ans[sr][sc] = newColor;
         int n = image.length;;
         int m = image[0].length;
        for (int i = 0; i < 4; i++) {
            int nrow = sr + delrow[i];
            int ncol = sc + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && image[nrow][ncol] == iniColor && ans[nrow][ncol] != newColor && !vis[nrow][ncol]){
                dfs(nrow,ncol,vis,image,ans,delrow,delcol,iniColor,newColor);
            }
        }
    }

   public static void bfs(int row, int col,boolean[][] vis, char[][] grid){
         vis[row][col] = true;
         Queue<Pair> q = new LinkedList<>();
         q.add(new Pair(row,col));
         int n = grid.length;
         int m = grid[0].length;
         while(!q.isEmpty()){
             int ro = q.peek().first;
             int co = q.peek().second;
             q.remove();
             for (int delrow = -1; delrow <= 1 ; delrow++) {
                 for (int delcol = -1; delcol <=1 ; delcol++) {
                     int nrow = row + delrow;
                     int ncol = col +delcol;
                     if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && ! vis[nrow][ncol] && grid[nrow][ncol] =='1'){
                         q.add(new Pair(nrow,ncol));
                         vis[nrow][ncol] = true;
                     }
                 }
             }
         }
   }
}