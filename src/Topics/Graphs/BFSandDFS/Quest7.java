package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://leetcode.com/problems/01-matrix/description/
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
                {0,0,1,1}
        };
        int[][] ans = updateMatrix(grid);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        // visited and distance matrix
        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        // <coordinates, steps>
        Queue<Pair3> q = new LinkedList<>();
        // traverse the matrix
        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                // start BFS if cell contains 1
                if(grid[i][j] == 1) {
                    q.add(new Pair3(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }



        int[] delrow = {-1, 0, +1, 0};
        int[] delcol = {0, +1, 0, -1};


        // n x m x 4
        // traverse till queue becomes empty
        while(!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            // for all 4 neighbours
            for(int i = 0;i<4;i++) {
                int nrow = row + delrow[i];
                int ncol = col + delcol[i];
                // check for valid unvisited cell
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0)  {
                    vis[nrow][ncol] = 1;
                    q.add(new Pair3(nrow, ncol, steps+1));
                }
            }
        }

        // return distance matrix
        return dist;
    }
}
/*
public static int[][] updateMatrix(int[][] grid) {
    int n = grid.length; // Number of rows
    int m = grid[0].length; // Number of columns

    // Initialize visited and distance matrices
    int[][] vis = new int[n][m];
    int[][] dist = new int[n][m];
    Queue<Pair3> q = new LinkedList<>();

    // Traverse the matrix to add all '0' cells to the queue
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (grid[i][j] == 0) {
                // Add cells with '0' to the queue
                q.add(new Pair3(i, j, 0));
                vis[i][j] = 1; // Mark as visited
                dist[i][j] = 0; // Distance to itself is 0
            } else {
                // Initialize other cells as unvisited
                vis[i][j] = 0;
            }
        }
    }

    // Define directions for movement (up, right, down, left)
    int[] delrow = {-1, 0, +1, 0};
    int[] delcol = {0, +1, 0, -1};

    // Perform BFS to calculate distances
    while (!q.isEmpty()) {
        int row = q.peek().first;
        int col = q.peek().second;
        int steps = q.peek().third;
        q.remove();

        // Traverse all 4 neighbors
        for (int i = 0; i < 4; i++) {
            int nrow = row + delrow[i];
            int ncol = col + delcol[i];

            // Check if the neighboring cell is valid and unvisited
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                vis[nrow][ncol] = 1; // Mark the cell as visited
                dist[nrow][ncol] = steps + 1; // Update the distance
                q.add(new Pair3(nrow, ncol, steps + 1)); // Add the cell to the queue
            }
        }
    }

    // Return the updated distance matrix
    return dist;
}
  public int[][] updateMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] dist = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m;j++){
                if(grid[i][j]==0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 1;
                }
            }
        }
        int[]  drow = {-1,0,1,0};
        int[]  dcol = {0,1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for(int i = 0 ; i < 4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,steps+1));
                    vis[nrow][ncol]=1;
                }
            }
        }
        return dist;
    }
 */
