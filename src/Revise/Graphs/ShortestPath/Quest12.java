package Revise.Graphs.ShortestPath;
import java.util.*;
class Pair7 {
    int first; // Distance or weight
    int second; // Node

    Pair7(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Quest12 {
    public static void main(String[] args) {
// Example input
        int n = 4; // Number of nodes
        int[][] roads = {
                {0, 1, 4},
                {0, 2, 3},
                {1, 2, 1},
                {1, 3, 2},
                {2, 3, 4}
        };

        int result = countPaths(n, roads);

        // Output the result
        System.out.println("The number of ways to reach the destination is: " + result);
    }
    public static int countPaths(int n, int[][] roads) {
        // Creating an adjacency list for the given graph.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0], roads[i][2]));
        }

        // Defining a priority queue (min heap).
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Long.compare(x.second, y.second));

        // Initializing the dist array and the ways array
        long[] dist = new long[n];
        int[] ways = new int[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        Arrays.fill(ways, 0);

        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair(0, 0));

        int mod = (int)(1e9 + 7);

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            long dis = curr.second;
            int node = curr.first;

            for (Pair neighbor : adj.get(node)) {
                int adjNode = neighbor.first;
                long edgeWeight = neighbor.second;

                // Update distance if a shorter path is found
                if (dis + edgeWeight < dist[adjNode]) {
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(adjNode, (int) dist[adjNode]));
                    ways[adjNode] = ways[node];
                } else if (dis + edgeWeight == dist[adjNode]) {
                    // Add number of ways for equal distance paths
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }

        return ways[n - 1] % mod;
    }
}
