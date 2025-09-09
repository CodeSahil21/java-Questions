package Revise.Graphs.BfsAndDfs;

import java.util.ArrayList;
import java.util.HashSet;

public class Quest10 {
    public static void main(String[] args) {

    }
    private void dfs(int row, int col, int[][] vis, int[][] grid, ArrayList<String> list, int row0, int col0) {
        vis[row][col] = 1;
        list.add(toString(row - row0, col - col0));
        int n = grid.length;
        int m = grid[0].length;
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        for(int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                dfs(nrow, ncol, vis, grid, list, row0, col0);
            }
        }
    }

    private String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    int countDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(vis[i][j] == 0 && grid[i][j] == 1) {
                    ArrayList<String> vec = new ArrayList<>();
                    dfs(i, j, vis, grid, vec, i, j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
}
