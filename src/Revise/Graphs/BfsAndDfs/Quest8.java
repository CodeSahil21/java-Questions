package Revise.Graphs.BfsAndDfs;

public class Quest8 {
    public static void main(String[] args) {
        char[][] mat = {
                {'X', 'X', 'X', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'O'}};
        char[][] ans = fill(mat);
        for(int i = 0;i < 5;i++) {
            for(int j = 0;j < 4;j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] fill(char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        char[][] ans = grid;
        boolean[][] vis = new boolean[n][m];
        int[] delrow = {-1,0,1,0};
        int[] delcol = {0,1,0,-1};
        for(int i = 0 ; i < m;i++){
            if(!vis[0][i] &&grid[0][i] == 'O'){
                dfs(0,i,vis,grid,delrow,delcol);
            }
            if(!vis[n-1][i] && grid[n-1][i] =='O'){
                dfs(n-1,i,vis,grid,delrow,delcol);
            }
        }
        for(int i = 0 ; i < n;i++){
            if(!vis[i][0] &&grid[i][0] == 'O'){
                dfs(i,0,vis,grid,delrow,delcol);
            }
            if(!vis[i][m-1] && grid[i][m-1] =='O'){
                dfs(i,m-1,vis,grid,delrow,delcol);
            }
        }

        for(int i =0 ; i < n;i++){
            for(int j =0; j < m;j++){
                if(!vis[i][j] && grid[i][j] == 'O'){
                    ans[i][j] = 'X';
                }
            }
        }
        return ans;
    }

    public static  void dfs(int row,int col,boolean[][] vis,char[][] grid,int[] delrow,int[] delcol){
        vis[row][col] = true;
        int n = grid.length;
        int m = grid[0].length;
        for(int i =0 ; i < 4;i++){
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == '0'){
                dfs(nrow,ncol,vis,grid,delrow,delcol);
            }
        }
    }
}
