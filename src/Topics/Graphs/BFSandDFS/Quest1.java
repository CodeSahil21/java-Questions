package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://leetcode.com/problems/number-of-provinces/description/
public class Quest1 {
    public int findCircleNum(int[][] isConnected) {
        // Initialize adjacency list
        ArrayList<ArrayList<Integer>> adjs = new ArrayList<>();
        for (int i = 0; i < isConnected.length; i++) {
            adjs.add(new ArrayList<Integer>());
        }

        // Convert adjacency matrix to adjacency list
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                // If there is a direct connection between i and j
                if (isConnected[i][j] == 1 && i != j) {
                    adjs.get(i).add(j); // Add j to i's adjacency list
                    adjs.get(j).add(i); // Add i to j's adjacency list (for undirected graph)
                }
            }
        }

        // Visited array
        int[] vis = new int[isConnected.length];
        int provinceCount = 0;

        // Iterate through all nodes (cities)
        for (int i = 0; i < isConnected.length; i++) {
            if (vis[i] == 0) { // If the city hasn't been visited
                provinceCount++; // Increment province count
                dfs(i, adjs, vis); // Explore all connected cities
            }
        }

        return provinceCount;
    }

    // DFS to traverse connected components
    private static void dfs(int node, ArrayList<ArrayList<Integer>> adjs, int[] vis) {
        vis[node] = 1; // Mark the current node as visited
        for (Integer it : adjs.get(node)) { // Iterate through neighbors
            if (vis[it] == 0) { // If the neighbor is not visited
                dfs(it, adjs, vis); // Recursive DFS call
            }
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };

    }
}
/*
private static void dfs(int node, int[][] adj, int[] vis, int V) {
    vis[node] = 1;
    for (int j = 0; j < V; j++) {
        if (adj[node][j] == 1 && vis[j] == 0) { // Check for unvisited neighbors
            dfs(j, adj, vis, V);
        }
    }
}

static int numProvinces(int[][] adj, int V) {
    int[] vis = new int[V]; // Visited array
    int cnt = 0;

    // Traverse all nodes
    for (int i = 0; i < V; i++) {
        if (vis[i] == 0) { // If the node is not visited
            cnt++; // Increment province count
            dfs(i, adj, vis, V);
        }
    }
    return cnt;
}

 */