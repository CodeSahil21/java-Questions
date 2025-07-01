package Topics.Graphs.ShortestPathAlgo;

import java.util.*;

//https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=shortest-path-in-undirected-graph
class  Pair{
    int first;
    int second;
    public Pair(int first, int second){
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
    public  static int[] shortestPath(int N, int M, int[][] edges) {
        ArrayList<ArrayList<Pair>>  adj = new ArrayList<>();
        for(int i = 0; i < N;i++){
            ArrayList<Pair>  temp = new ArrayList<>();
            adj.add(temp);
        }
        //first we create a graph based on adjacency List
        for (int i = 0; i < M; i++) {
             int u =  edges[i][0];
             int v =  edges[i][1];
             int wt = edges[i][2];
             adj.get(u).add(new Pair(v,wt));
        }
        int[] vis = new int[N];
        //Step 2: now we perform topo sort
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < N; i++) {
            if(vis[i] == 0){
                topoSort(i,adj,vis,st);
            }
        }
        //Further, we declare a vector ‘dist’ in which we update the value of the nodes’
        //distance from the source vertex after relaxation of a particular node
        int[] dist = new int[N];
        Arrays.fill(dist, (int) (1e9));
        dist[0] = 0;
        while (!st.isEmpty()){
            int node = st.peek();
            st.pop();
            for (int i = 0; i < adj.get(node).size(); i++) {
             int v = adj.get(node).get(i).first;
             int wt = adj.get(node).get(i).second;
             if(dist[node] + wt  < dist[v]){
                 dist[v] = wt + dist[node];
             }
            }
        }
        for (int i = 0; i < N; i++) {
            if (dist[i] == 1e9) dist[i] = -1;
        }
        return dist;
    }
    private static void  topoSort(int node ,ArrayList<ArrayList<Pair>> adj ,int[] vis,Stack<Integer> st){
        vis[node] = 1;
        for (int i = 0; i < adj.get(node).size(); i++) {
            int v = adj.get(node).get(i).first;
            if(vis[v] == 0){
                topoSort(v,adj,vis,st);
            }
        }
        st.add(node);
    }
}
