package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://leetcode.com/problems/shortest-path-in-binary-matrix/
class tuple {
    int first, second, third;
    tuple(int _first, int _second, int _third) {
        this.first = _first;
        this.second = _second;
        this.third = _third;
    }
}
public class Quest8 {
    public static void main(String[] args) {

    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        // Edge Case: If the start or end cells are blocked.
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }

        // Queue for BFS traversal: {distance, row, column}.
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); // Start with distance = 1 at top-left cell.

        // Direction arrays for 8-directional movement.
        int[] dr = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] dc = {-1, 0, 1, 1, 1, 0, -1, -1};

        // Create a visited array (vis) to track visited cells.
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true; // Mark the start cell as visited.

        // BFS Loop.
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int dist = cell[0], row = cell[1], col = cell[2];

            // If the bottom-right cell is reached, return the distance.
            if (row == n - 1 && col == n - 1) {
                return dist;
            }

            // Explore all 8 possible directions.
            for (int i = 0; i < 8; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Check cell validity and if it's clear (value 0) and not visited.
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && grid[newRow][newCol] == 0 && !vis[newRow][newCol]) {
                    q.add(new int[]{dist + 1, newRow, newCol});
                    vis[newRow][newCol] = true; // Mark as visited in vis array.
                }
            }
        }

        // No path exists.
        return -1;
    }



}
/*
int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Edge Case: if the source is only the destination.
        if(source[0] == destination[0] &&
                source[1] == destination[1]) return 0;

        // Create a queue for storing cells with their distances from source
        // in the form {dist,{cell coordinates pair}}.
        Queue<tuple> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        // Create a distance matrix with initially all the cells marked as
        // unvisited and the source cell as 0.
        int[][] dist = new int[n][m];
        for(int i = 0;i<n;i++) {
            for(int j =0;j<m;j++) {
                dist[i][j] = (int)(1e9);
            }
        }
        dist[source[0]][source[1]] = 0;
        q.add(new tuple(0, source[0], source[1]));

        // The following delta rows and delts columns array are created such that
        // each index represents each adjacent node that a cell may have
        // in a direction.
        int dr[] = {-1, 0, 1, 0};
        int dc[] = {0, 1, 0, -1};

        // Iterate through the maze by popping the elements out of the queue
        // and pushing whenever a shorter distance to a cell is found.
        while(!q.isEmpty()) {
            tuple it = q.peek();
            q.remove();
            int dis = it.first;
            int r = it.second;
            int c = it.third;

            // Through this loop, we check the 4 direction adjacent nodes
            // for a shorter path to destination.
            for(int i = 0;i<4;i++) {
                int newr = r + dr[i];
                int newc = c + dc[i];

                // Checking the validity of the cell and updating if dist is shorter.
                if(newr >= 0 && newr < n && newc >= 0 && newc < m && grid[newr][newc] == 1 && dis + 1 < dist[newr][newc]) {
                    dist[newr][newc] = 1 + dis;

                    // Return the distance until the point when
                    // we encounter the destination cell.
                    if(newr == destination[0] && newc == destination[1]) return dis + 1;
                    q.add(new tuple(1+dis, newr, newc));
                }
            }
        }
        // If no path is found from source to destination.
        return -1;
    }
 */
