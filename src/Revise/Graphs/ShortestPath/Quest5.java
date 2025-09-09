package Revise.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Pair3{
    int node;
    int distance;
    public Pair3(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}
public class Quest5 {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int S = 0; // Source node

        // Adjacency list to represent the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initializing the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        // Edge format: {destination, weight}
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 4)));

        // Call the dijkstra function
        int[] result = dijkstra(V, adj, S);

        // Print the shortest distances from the source to all nodes
        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + " : " + result[i]);
        }
    }
    public static  int[] dijkstra(int V,ArrayList<ArrayList<ArrayList<Integer>>> adj,int S){
        PriorityQueue<Pair3>  pq = new PriorityQueue<>((x,y)->x.distance -y.distance);
        int[] dist = new int[V];
        Arrays.fill(dist,(int)(1e9));
        pq.add(new Pair3(0,S));
        dist[S] = 0;
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int dis = pq.peek().distance;
            pq.poll();
            for(int i = 0 ; i < adj.get(node).size();i++){
                int edgeweight = adj.get(node).get(i).get(1);
                int adjnode = adj.get(node).get(i).get(0);

                if(dis + edgeweight <  dist[adjnode]){
                    dist[adjnode] = dis + edgeweight;
                    pq.add(new Pair3(dist[adjnode],adjnode));
                }
            }

        }
        return dist;
    }
}
