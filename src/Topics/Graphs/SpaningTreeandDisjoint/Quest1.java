package Topics.Graphs.SpaningTreeandDisjoint;
import java.util.*;
//https://www.geeksforgeeks.org/problems/minimum-spanning-tree/1
class Pair {
    int node;
    int distance;
    public Pair(int distance, int node) {
        this.node = node;
        this.distance = distance;
    }
}
public class Quest1 {
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        int[][] edges =  {{0, 1, 2}, {0, 2, 1}, {1, 2, 1}, {2, 3, 2}, {3, 4, 1}, {4, 2, 2}};

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }

        for (int i = 0; i < 6; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int w = edges[i][2];

            ArrayList<Integer> tmp1 = new ArrayList<Integer>();
            ArrayList<Integer> tmp2 = new ArrayList<Integer>();
            tmp1.add(v);
            tmp1.add(w);

            tmp2.add(u);
            tmp2.add(w);

            adj.get(u).add(tmp1);
            adj.get(v).add(tmp2);
        }


        int sum = spanningTree(V, adj);
        System.out.println("The sum of all the edge weights: " + sum);
    }
    static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        PriorityQueue<Pair> pq =
                new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] vis = new int[V];
        // {wt, node}
        pq.add(new Pair(0, 0));
        int sum = 0;
        while (!pq.isEmpty()) {
            int wt = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            if (vis[node] == 1) continue;
            // add it to the mst
            vis[node] = 1;
            sum += wt;

            for (int i = 0; i < adj.get(node).size(); i++) {
                int edW = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if (vis[adjNode] == 0) {
                    pq.add(new Pair(edW, adjNode));
                }
            }
        }
        return sum;
    }
}
/*
static class Edge {
    int node1, node2, weight;

    Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }
}

static int spanningTreeWithEdges(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

    int[] vis = new int[V];
    List<Edge> mstEdges = new ArrayList<>();
    pq.add(new Pair(0, 0, -1)); // {wt, node, parent}
    int sum = 0;

    while (!pq.isEmpty()) {
        int wt = pq.peek().distance;
        int node = pq.peek().node;
        int parent = pq.peek().parent;
        pq.remove();

        if (vis[node] == 1) continue;
        vis[node] = 1;
        sum += wt;

        // Add the edge to the list (if it's not the starting node)
        if (parent != -1) {
            mstEdges.add(new Edge(parent, node, wt));
        }

        for (int i = 0; i < adj.get(node).size(); i++) {
            int adjNode = adj.get(node).get(i).get(0);
            int edW = adj.get(node).get(i).get(1);

            if (vis[adjNode] == 0) {
                pq.add(new Pair(edW, adjNode, node));
            }
        }
    }

    // Print or utilize the MST edges
    for (Edge edge : mstEdges) {
        System.out.println("Edge: " + edge.node1 + " - " + edge.node2 + " | Weight: " + edge.weight);
    }

    return sum;
}

static class Pair {
    int distance, node, parent;

    Pair(int distance, int node, int parent) {
        this.distance = distance;
        this.node = node;
        this.parent = parent;
    }
}
 */