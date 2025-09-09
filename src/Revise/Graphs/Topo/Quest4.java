package Revise.Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Quest4 {
    public static void main(String[] args) {
        int V = 4; // Number of vertices
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(1); // This edge creates a cycle

        if (isCyclic(V, adj)) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }
    static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Calculate in-degrees for all nodes
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 2: Add all nodes with in-degree 0 to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 3: Perform BFS to generate the topological sort
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll(); // Remove a node from the queue
            topo.add(node); // Add node to topological sort list

            // Reduce in-degree of all adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it); // If in-degree becomes 0, add to the queue
                }
            }
        }

        // Step 4: Check if all nodes are included in the topological sort
        // If topo.size() < V, a cycle exists
        return topo.size() != V;
    }
}
