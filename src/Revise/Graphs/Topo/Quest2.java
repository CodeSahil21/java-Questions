package Revise.Graphs.Topo;

import java.util.ArrayList;
import java.util.Stack;

public class Quest2 {
    public static void main(String[] args) {
        int V = 6;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(2).add(3);
        adj.get(3).add(1);
        adj.get(4).add(0);
        adj.get(4).add(1);
        adj.get(5).add(0);
        adj.get(5).add(2);

        int[] ans = topoSort(V, adj);
        for (int node : ans) {
            System.out.print(node + " ");
        }
        System.out.println("");
    }
    static  int[] topoSort(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < V;i++){
            if(!vis[i]){
                dfs(i,adj,vis,st);
            }
        }
        int[] ans =  new int[V];
        int i = 0;
        while(!st.isEmpty()&& i < V){
            ans[i] = st.pop();
            i++;
        }
        return ans;
    }
    public static void dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] vis,Stack<Integer> st){
        vis[node] = true;
        for(int no: adj.get(node)){
            if(!vis[no]){
                dfs(no,adj,vis,st);
            }
        }
        st.push(node);
    }
}
