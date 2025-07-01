package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://www.geeksforgeeks.org/problems/distance-from-the-source-bellman-ford-algorithm/1
public class Quest13 {
    public static void main(String[] args) {
        int V = 6;
        int S = 0;
        int[][] edgeMatrix = {
                {3, 2, 6},
                {5, 3, 1},
                {0, 1, 5},
                {1, 5, -3},
                {1, 2, -2},
                {3, 4, -2},
                {2, 4, 3}
        };

        // Convert matrix into an ArrayList<ArrayList<Integer>>
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        for (int[] edge : edgeMatrix) {
            ArrayList<Integer> edgeList = new ArrayList<>(Arrays.asList(edge[0], edge[1], edge[2]));
            edges.add(edgeList);
        }

        // Call bellman_ford and print distances
        int[] dist = bellman_ford(V, edges, S);
        for (int d : dist) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e8));
        dist[S] = 0;
        // V x E
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);
                if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }
        // Nth relaxation to check negative cycle
        for (ArrayList<Integer> it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);
            if (dist[u] != 1e8 && dist[u] + wt < dist[v]) {
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
        return dist;
    }
}
