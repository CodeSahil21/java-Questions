package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://leetcode.com/problems/number-of-enclaves/description/
class Pair4 {
    int first;
    int second;
    public Pair4(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Quest9 {
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0, 0},
                {1, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 0, 0, 0}};


        int ans = numEnclaves(grid);
        System.out.println(ans);
     }

    public static  int numEnclaves(int[][] grid) {
      Queue<Pair4> q = new LinkedList<>();
      int n = grid.length;
      int m = grid[0].length;
      int[][] vis = new int[n][m];

      //traverse boundary elements
        for(int i = 0; i < n;i++){
            for (int j = 0; j < m; j++) {
                if(i == 0 ||  i == n-1 || j == 0 || j == m-1 ){
                    if(grid[i][j]==1){
                        q.add(new Pair4(i,j));
                        vis[i][j] = 1;
                    }
                }
            }
        }
        //perform bfs for it neighbour
        int[] delrow  = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        while (!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int i = 0; i < 4; i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                if( nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
                    q.add(new Pair4(nrow,ncol));
                    vis[nrow][ncol] = 1;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(grid[i][j]==1 && vis[i][j]==0 ) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}


