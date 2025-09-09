package Revise.Graphs.BfsAndDfs;

import java.util.ArrayList;

public class Quest6 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        boolean ans = isCycle(4, adj);
        if (ans)
            System.out.println("1");
        else
            System.out.println("0");
    }
    //O(V + 2E) + O(N)
    public static boolean isCycle(int V,ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V;i++){
            if(!vis[i]){
                if(dfs(i,-1,adj,vis,V)){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean dfs(int node, int parent , ArrayList<ArrayList<Integer>> adj , boolean[] vis,int V){
        vis[node] = true;
        for(int adjacentNode : adj.get(node)){
            if(!vis[adjacentNode]){
                if(dfs(adjacentNode,node,adj,vis,V)){
                    return true;
                }
            } else if (parent != adjacentNode) {
                return true;
            }
        }
        return false;
    }
}
