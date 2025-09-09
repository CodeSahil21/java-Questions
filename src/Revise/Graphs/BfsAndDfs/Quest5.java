package Revise.Graphs.BfsAndDfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Pair2{
    int first;
    int second;
    Pair2(int first,int second){
       this.first = first;
       this.second = second;
    }
}
public class Quest5 {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList<>());
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
    //N + 2E
    public static boolean detectCycle(int src,ArrayList<ArrayList<Integer>> adj,boolean[] vis,int V){
        vis[src] = true;
        Queue<Pair2> q = new LinkedList<>();
        q.offer(new Pair2(src,-1));
        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.poll();
            for(int adjacentNode:adj.get(node)){
                if(!vis[adjacentNode]){
                    q.add(new Pair2(adjacentNode,node));
                    vis[adjacentNode] = true;
                }else if(parent != adjacentNode){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj){
        boolean[] vis = new boolean[V];
        for(int i = 0; i < V;i++){
            if(!vis[i]){
                if(detectCycle(i,adj,vis,V)){
                    return true;
                }

            }
        }
        return false;
    }
}
