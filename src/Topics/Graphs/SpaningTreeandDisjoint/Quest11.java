package Topics.Graphs.SpaningTreeandDisjoint;
import java.util.*;
//https://leetcode.com/problems/swim-in-rising-water/description/
public class Quest11 {
        public static void main(String[] args) {
            // Example 1: Input: [[0,2],[1,3]] -> Output: 3
            int[][] grid1 = {
                    {0, 2},
                    {1, 3}
            };
            System.out.println("Test 1: Input [[0,2],[1,3]] -> Output: " + swimInWater(grid1) + " (Expected: 3)");

            // Example 2: Input: large grid -> Output: 16
            int[][] grid2 = {
                    {0, 1, 2, 3, 4},
                    {24, 23, 22, 21, 5},
                    {12, 13, 14, 15, 16},
                    {11, 17, 18, 19, 20},
                    {10, 9, 8, 7, 6}
            };
            System.out.println("Test 2: Large Grid -> Output: " + swimInWater(grid2) + " (Expected: 16)");

            // Additional Test Case: Simple 3x3
            int[][] grid3 = {
                    {0, 5, 6},
                    {1, 4, 7},
                    {2, 3, 8}
            };
            // Path 0->1->2->3->8. Max elevation is 8.
            System.out.println("Test 3: Input 3x3 -> Output: " + swimInWater(grid3) + " (Expected: 8)");
        }

    // Minimum time to reach bottom right cell
    public static int swimInWater(int[][] grid) {
        // Get grid size
        int n = grid.length;

        // Create min-heap for cells, prioritized by the maximum elevation encountered (a[0])
        // Stores: {max_elevation_so_far, row, col}
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Visited matrix to prevent cycles and redundant work
        boolean[][] visited = new boolean[n][n];

        // Push starting cell (0, 0) to heap. The initial elevation ceiling is grid[0][0].
        minHeap.add(new int[]{grid[0][0], 0, 0});
        visited[0][0] = true;

        // Direction vectors: right, down, left, up
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

        // Process heap (Modified Dijkstra's Algorithm)
        while (!minHeap.isEmpty()) {
            // Get cell with lowest maximum elevation encountered so far
            int[] curr = minHeap.poll();
            int elevation = curr[0]; // The time 't' required to reach this cell
            int r = curr[1], c = curr[2];

            // If destination reached, this is the minimum possible time
            if (r == n - 1 && c == n - 1) return elevation;

            // Check all 4-directional neighbors
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];

                // Check bounds and visited status
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !visited[nr][nc]) {

                    visited[nr][nc] = true;

                    // The new elevation ceiling is the maximum of the current path's ceiling
                    // and the neighbor's elevation.
                    int newElevation = Math.max(elevation, grid[nr][nc]);

                    // Add the new state to the heap
                    minHeap.add(new int[]{newElevation, nr, nc});
                }
            }
        }
        // Should not be reached if a path exists
        return -1;
    }
}
