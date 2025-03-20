package Topics.Graphs.TOPO;
import java.util.*;
//https://leetcode.com/problems/course-schedule/description/
public class Quest5 {
    public static void main(String[] args) {
        int V = 4; // Number of courses
        int[][] prerequisites = {
                {1, 0}, // To take course 1, you must complete course 0
                {2, 1}, // To take course 2, you must complete course 1
                {3, 2}, // To take course 3, you must complete course 2
                {0, 3}  // To take course 0, you must complete course 3 (creates a cycle)
        };

        // Call the isPossible function
        if (isPossible(V, prerequisites)) {
            System.out.println("All courses can be completed.");
        } else {
            System.out.println("It is not possible to complete all courses.");
        }
    }
    public static boolean isPossible(int V, int[][] prerequisites) {
        // Step 1: Form a graph using adjacency lists
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        // Step 2: Calculate in-degrees for all nodes
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 3: Add all nodes with in-degree 0 to the queue
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Step 4: Perform BFS to generate the topological order
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            // Reduce in-degree of all adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        // Step 5: Check if all nodes are included in the topological order
        return topo.size() == V;
    }
}
