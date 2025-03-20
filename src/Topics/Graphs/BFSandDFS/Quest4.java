package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://leetcode.com/problems/rotting-oranges/
class Pair1 {
    int row;
    int col;
    int tm;

    Pair1(int _row, int _col, int _tm) {
        this.row = _row;
        this.col = _col;
        this.tm = _tm;
    }
}
public class Quest4 {
    // Function to find the minimum time required to rot all oranges
    public static int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair1> q = new LinkedList<>();
        int[][] vis = new int[n][m];
        int cntFresh = 0;

        // Traverse the grid to initialize the queue and count fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) { // Rotten orange
                    q.add(new Pair1(i, j, 0));
                    vis[i][j] = 2; // Mark as visited
                } else {
                    vis[i][j] = 0; // Mark as unvisited
                }
                if (grid[i][j] == 1) cntFresh++; // Count fresh oranges
            }
        }

        int tm = 0; // Time counter
        int[] drow = {-1, 0, +1, 0}; // Row direction for 4 neighbors
        int[] dcol = {0, +1, 0, -1}; // Column direction for 4 neighbors
        int cnt = 0; // Count of oranges that have rotted

        // BFS traversal
        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            q.remove();
            tm = Math.max(tm, t);

            // Check for all 4 neighbors
            for (int i = 0; i < 4; i++) {
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                // If the neighboring cell is valid and contains a fresh orange
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
                        vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
                    q.add(new Pair1(nrow, ncol, t + 1));
                    vis[nrow][ncol] = 2; // Mark as visited
                    cnt++;
                }
            }
        }

        // If all fresh oranges have rotted, return the time. Otherwise, return -1.
        return (cnt == cntFresh) ? tm : -1;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println(orangesRotting(grid)); // Output: 4
    }
}



