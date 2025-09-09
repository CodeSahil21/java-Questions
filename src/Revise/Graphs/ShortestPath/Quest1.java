package Revise.Graphs.ShortestPath;

import java.util.*;
class Pair{
    int first;
    int second;
    Pair(int first,int second){
        this.first = first;
        this.second = second;
    }
}
public class Quest1 {
    public static void main(String[] args) {
        int n = 6, m = 7;
        int[][] edge = {{0,1,2},{0,4,1},{4,5,4},{4,2,2},{1,2,3},{2,3,6},{5,3,1}};
        int[] res = shortestPath(n, m, edge);
        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
        System.out.println();
    }

    public static int[] shortestPath(int n,int m ,int[][] edge){
       ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
       for (int i = 0 ; i < n;i++){
           ArrayList<Pair> temp  = new ArrayList<>();
           adj.add(temp);
       }
       for(int i = 0 ; i < m;i++){
           int first = edge[i][0];
           int second = edge[i][1];
           int third = edge[i][2];
           adj.get(first).add(new Pair(second,third));
       }
       boolean[] vis = new boolean[n];
       Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if(!vis[i]){
                topoSort(i,adj,vis,st);
            }
        }
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while(!st.isEmpty()){
            int node = st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
                int first = adj.get(node).get(i).first;
                int second = adj.get(node).get(i).second;
                if(dist[node] + second < dist[first]){
                    dist[first] = dist[node] + second;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }

    public static void topoSort(int node, ArrayList<ArrayList<Pair>> adj,boolean[] vis,Stack<Integer> st){
        vis[node] = true;
        for(int i =0 ; i < adj.get(node).size();i++){
            int v = adj.get(node).get(i).first;
            if(!vis[v]){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
}
