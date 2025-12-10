package Revise.Graphs.SpanningandDisjoint;

import java.util.ArrayList;
import java.util.PriorityQueue;

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
  public static int spanningTree(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj){
      PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)-> x.distance-y.distance);
      boolean[] vis = new boolean[V];
      pq.add(new Pair(0,0));
      int sum = 0;
      while(!pq.isEmpty()){
          int node = pq.peek().node;
          int dist = pq.peek().distance;
          pq.remove();
          if(vis[node]){
              continue;
          }
          vis[node] = true;
          sum += dist;
          for(int i =0 ;i < adj.get(node).size();i++) {
              int edw = adj.get(node).get(i).get(1);
              int adjnode = adj.get(node).get(i).get(0);
              if (!vis[adjnode]) {
                  pq.add(new Pair(edw, adjnode));
              }
          }
      }
      return sum;
  }
}
