package Revise.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

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
   public static int[] dijkstra(int V, ArrayList<ArrayList<int[]>> adj ,int S){
       TreeSet<int[]> t = new TreeSet<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
       int[] dist = new int[V];
       Arrays.fill(dist,(int) (1e9));
       t.add(new int[]{0,S});
       dist[S] = 0;
       while(!t.isEmpty()){
           int[] pair = t.pollFirst();
           int dis =  pair[0];
           int node = pair[1];
           for(int[] edge :adj.get(node)){
               int edgeweight = edge[1];
               int adjNode = edge[0];
               if(dis + edgeweight < dist[adjNode]){
                   if(dist[adjNode] != 1e9){
                       t.remove(new int[] {dist[adjNode],adjNode});
                   }
                   dist[adjNode] = dis + edgeweight;
                   t.add(new int[] {dist[adjNode] ,adjNode});

               }
           }
       }
       return dist;
   }
}
