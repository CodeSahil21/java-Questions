package Revise.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Pair4{
    int distance;
    int node;
    Pair4(int distance,int node){
        this.distance = distance;
        this.node = node;
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

    public static  List<Integer> PrintShortestPath(int n , int m,int[][] edges,int src, int dest){
        ArrayList<ArrayList<Pair4>> adj = new ArrayList<>();
        for(int i =0 ; i <n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < m;i++){
            adj.get(edges[i][0]).add(new Pair4(edges[i][2],edges[i][1]));
            adj.get(edges[i][1]).add(new Pair4(edges[i][2],edges[i][0]));
        }
        PriorityQueue<Pair4> pq = new PriorityQueue<>((a,b)->a.distance - b.distance);
        int[] dist = new int[n];
        int[]  parent = new int[n];
        for(int i =0 ; i < n;i++){
            dist[i] =  (int)(1e9);
            parent[i] = i;
        }
        pq.add(new Pair4(0,src));
        dist[src] = 0;
        while(!pq.isEmpty()){
            Pair4 curr = pq.remove();
            int node =  curr.node;
            int dis = curr.distance;
            for(Pair4 it :adj.get(node)){
                int adjNode = it.node;
                int edgeWeight = it.distance;
                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
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
