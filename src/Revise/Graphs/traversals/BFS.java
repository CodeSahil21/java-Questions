package Revise.Graphs.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BFS {
    public static void main(String[] args) {
        ArrayList <ArrayList< Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 5; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(0).add(4);
        adj.get(4).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(1).add(3);
        adj.get(3).add(1);
        List<Integer> ans = bfsOfGraph(5,adj);
        for (int i = 0; i < ans.size(); i++) {
            System.out.println(ans.get(i)+ " ");
        }
    }
    public static List<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj){
        List<Integer> res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q =  new LinkedList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int node = q.poll();
            res.add(node);

            for(int neighbour : adj.get(node)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                    vis[neighbour] = true;
                }
            }
        }


      return res;
    }
}
