package Topics.Graphs.TOPO;
import java.util.*;
//https://leetcode.com/problems/find-eventual-safe-states/
public class Quest1 {
    public static void main(String[] args) {
        // Example adjacency matrix input
        int[][] matrix = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };

        // Call the eventualSafeNodes function
        List<Integer> safeNodes = eventualSafeNodes(matrix);

        // Print the safe nodes
        System.out.println("Eventual Safe Nodes: " + safeNodes);
    }
    public static List<Integer> eventualSafeNodes(int[][] matrix) {
        int V = matrix.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                adj.get(i).add(matrix[i][j]);
            }
        }

        int[] vis = new int[V];
        int[] pathVis = new int[V];
        int[] check = new int[V];

        for (int i = 0; i < V; i++) {
            if (vis[i] == 0) {
                dfsCheck(i, adj, vis, pathVis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }

    private static boolean dfsCheck(int node, List<List<Integer>> adj, int[] vis, int[] pathVis, int[] check) {
        if (check[node] == 1) return false; // Already determined as safe

        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;

        for (int it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfsCheck(it, adj, vis, pathVis, check)) {
                    return true;
                }
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        check[node] = 1; // Mark as safe
        return false;
    }
/*
 public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        List<List<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            // i -> it
            // it -> i
            for (int it : adj.get(i)) {
                adjRev.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for (int it : adjRev.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
 */
}
