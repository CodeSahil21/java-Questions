package Topics.Graphs.ShortestPathAlgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph-having-unit-distance
public class Quest2 {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {
                {0, 1},
                {0, 2},
                {1, 2},
                {1, 3},
                {2, 4},
                {3, 4}
        };
        int src = 0; // Source node

        // Create an instance of the class and call the shortestPath method
        int[] result = shortestPath(edges, n, m, src);

        // Print the result
        System.out.println("Shortest distances from node " + src + " to all other nodes:");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + ": " + result[i]);
        }
    }
    public static int[] shortestPath(int[][] edges,int n,int m ,int src) {
        //Create an adjacency list of size N for storing the undirected graph.
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        //A dist array of size N initialised with a large number to
        //indicate that initially all the nodes are untraversed.
        int dist[] = new int[n];
        Arrays.fill(dist, (int) 1e9);
        dist[src] = 0;

        // BFS Implementation
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while(!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            for(int it : adj.get(node)) {
                if(dist[node] + 1 < dist[it]) {
                    dist[it] = 1 + dist[node];
                    q.add(it);
                }
            }
        }
        // Updated shortest distances are stored in the resultant array ‘ans’.
        // Unreachable nodes are marked as -1.
        for(int i = 0;i<n;i++) {
            if(dist[i] == 1e9) {
                dist[i] = -1;
            }
        }
        return dist;
    }
}
