package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
class  Pair4{
    int first;
    int second;
    public Pair4(int first, int second){
        this.first = first;
        this.second = second;
    }
}
public class Quest7 {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int m = 6; // Number of edges
        int[][] edges = {
                {0, 1, 2},
                {0, 2, 4},
                {1, 2, 1},
                {1, 3, 7},
                {2, 4, 3},
                {3, 4, 1}
        };

        int src = 0; // Source node
        int dest = 4; // Destination node

        List<Integer> shortestPath = PrintShortestPath(n, m, edges, src, dest);
        System.out.println("Shortest Path from " + src + " to " + dest + ": " + shortestPath);
    }
    public static List<Integer> PrintShortestPath(int n, int m, int[][] edges,int src,int dest) {
      ArrayList<ArrayList<Pair4>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
             adj.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            adj.get(edges[i][0]).add(new Pair4(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair4(edges[i][0], edges[i][2]));
        }
        PriorityQueue<Pair4> pq = new PriorityQueue<>((x,y)->x.first-y.first);
        int[] dist = new int[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }
        dist[src] = 0;
        pq.add(new Pair4(0,src));
        while(!pq.isEmpty()){
            Pair4 it = pq.peek();
            int node = it.second;
            int dis = it.first;
            pq.remove();
            for(Pair4 iter : adj.get(node)){
                int adjNode = iter.first;
                int  edwt = iter.second;
                if(dis + edwt < dist[adjNode]){
                    dist[adjNode] = dis + edwt;
                    pq.add(new Pair4(dist[adjNode],adjNode));
                    parent[adjNode] = node;
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[dest] == 1e9){
            path.add(-1);
            return path;
        }
        int node = dest;
        while(parent[node] != node){
            path.add(node);
            node = parent[node];
        }
        path.add(src);
        Collections.reverse(path);
        return path;
    }

}
