package Revise.Graphs.Topo;

import java.util.ArrayList;
import java.util.List;

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
    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] pathvis = new boolean[n];
        int[] check = new int[n]; // 1 = safe, 0 = unsafe

        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, graph, pathvis, vis, check);
            }
        }

        List<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (check[i] == 1) safeNodes.add(i);
        }
        return safeNodes;
    }

    public static boolean dfs(int node, int[][] graph, boolean[] pathvis, boolean[] vis, int[] check) {
        vis[node] = true;
        pathvis[node] = true;
        check[node] = 0;

        for (int neighbor : graph[node]) {
            if (!vis[neighbor]) {
                if (dfs(neighbor, graph, pathvis, vis, check)) {
                    return true;
                }
            } else if (pathvis[neighbor]) {
                return true;
            }
        }

        pathvis[node] = false;
        check[node] = 1;
        return false;
    }
//    public List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
//        List<List<Integer>> adjRev = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            adjRev.add(new ArrayList<>());
//        }
//        int indegree[] = new int[V];
//        for (int i = 0; i < V; i++) {
//            // i -> it
//            // it -> i
//            for (int it : adj.get(i)) {
//                adjRev.get(it).add(i);
//                indegree[i]++;
//            }
//        }
//        Queue<Integer> q = new LinkedList<>();
//        List<Integer> safeNodes = new ArrayList<>();
//        for (int i = 0; i < V; i++) {
//            if (indegree[i] == 0) {
//                q.add(i);
//            }
//        }
//
//        while (!q.isEmpty()) {
//            int node = q.peek();
//            q.remove();
//            safeNodes.add(node);
//            for (int it : adjRev.get(node)) {
//                indegree[it]--;
//                if (indegree[it] == 0) q.add(it);
//            }
//        }
//        Collections.sort(safeNodes);
//        return safeNodes;
//    }
}
