package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/description/
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
    public static  int countPaths(int n, int[][] roads) {
        // Creating an adjacency list for the given graph.
        ArrayList<ArrayList<Pair7>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int m = roads.length;
        for (int i = 0; i < m; i++) {
            adj.get(roads[i][0]).add(new Pair7(roads[i][1], roads[i][2]));
            adj.get(roads[i][1]).add(new Pair7(roads[i][0], roads[i][2]));
        }

        // Defining a priority queue (min heap).
        PriorityQueue<Pair7> pq = new PriorityQueue<>((x, y) -> x.first - y.first);

        // Initializing the dist array and the ways array
        // along with their first indices.
        int[] dist = new int[n];
        int[] ways = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
            ways[i] = 0;
        }
        dist[0] = 0;
        ways[0] = 1;
        pq.add(new Pair7(0, 0));

        // Define modulo value
        int mod = (int)(1e9 + 7);

        // Iterate through the graph with the help of priority queue
        // just as we do in Dijkstra's Algorithm.
        while (!pq.isEmpty()) {
            int dis = pq.peek().first;
            int node = pq.peek().second;
            pq.remove();

            for (Pair7 it : adj.get(node)) {
                int adjNode = it.first;
                int edW = it.second;

                // This ‘if’ condition signifies that this is the first
                // time we’re coming with this short distance, so we push
                // in PQ and keep the number of ways the same.
                if (dis + edW < dist[adjNode]) {
                    dist[adjNode] = dis + edW;
                    pq.add(new Pair7(dis + edW, adjNode));
                    ways[adjNode] = ways[node];
                }

                // If we again encounter a node with the same short distance
                // as before, we simply increment the number of ways.
                else if (dis + edW == dist[ adjNode]) {
                    ways[adjNode] = (ways[adjNode] + ways[node]) % mod;
                }
            }
        }
        // Finally, we return the number of ways to reach
        // (n-1)th node modulo 10^9+7.
        return ways[n - 1] % mod;
    }

}
/*
import java.util.*;

class Pair {
    int first; // Node
    long second; // Distance or weight

    Pair(int first, long second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public int countPaths(int n, int[][] roads) {
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
                    pq.add(new Pair(adjNode, dist[adjNode]));
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

 */