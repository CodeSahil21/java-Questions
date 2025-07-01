package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://takeuforward.org/data-structure/dijkstras-algorithm-using-set-g-33/
public class Quest6 {
    public static void main(String[] args) {
        int V = 3; // Number of vertices
        int S = 2; // Source node

        // Adjacency list to represent the graph
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the adjacency list
        adj.get(0).add(new int[]{1, 1});
        adj.get(0).add(new int[]{2, 6});
        adj.get(1).add(new int[]{2, 3});
        adj.get(1).add(new int[]{0, 1});
        adj.get(2).add(new int[]{1, 3});
        adj.get(2).add(new int[]{0, 6});

        // Instantiate Solution class and run the Dijkstra algorithm

        int[] result = dijkstra(V, adj, S);

        // Print the shortest distances from the source to all the nodes
        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < V; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
    // Function to find the shortest distance of all the vertices from the source vertex S
    public static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj, int S) {
        // Create a TreeSet (used as a sorted set) for storing the nodes as pairs {dist, node},
        // where dist is the distance from the source to the node.
        TreeSet<int[]> set = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        // Initialize the distance array with a large number (infinity).
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);

        // Add the source node to the set with distance 0
        set.add(new int[]{0, S});
        dist[S] = 0;

        // Process the nodes in the TreeSet
        while (!set.isEmpty()) {
            // Extract the element with the smallest distance
            int[] curr = set.pollFirst();
            int node = curr[1];
            int dis = curr[0];

            // Traverse all adjacent nodes of the current node
            for (int[] edge : adj.get(node)) {
                int adjNode = edge[0];
                int edgeWeight = edge[1];

                // Check if the current path is shorter
                if (dis + edgeWeight < dist[adjNode]) {
                    // Remove the previous entry from the set if it exists
                    if (dist[adjNode] != Integer.MAX_VALUE) {
                        set.remove(new int[]{dist[adjNode], adjNode});
                    }

                    // Update the distance and add the new pair to the set
                    dist[adjNode] = dis + edgeWeight;
                    set.add(new int[]{dist[adjNode], adjNode});
                }
            }
        }

        // Return the array containing the shortest distances
        return dist;
    }
}

