package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
public class Quest12 {
    public static void main(String[] args) {
        int V = 11;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(3).add(7);
        adj.get(4).add(5);
        adj.get(5).add(6);
        adj.get(7).add(5);
        adj.get(8).add(9);
        adj.get(9).add(10);
        adj.get(10).add(8);

        boolean ans = isCyclic(V, adj);
        if (ans)
            System.out.println("True");
        else
            System.out.println("False");
    }
    private static boolean dfsCheck(int node, ArrayList<ArrayList<Integer>> adj, int[] color,int col) {
        color[node] = col;

        // traverse for adjacent nodes
        for(int it : adj.get(node)) {
            // when the node is not visited
            if(color[it] == -1) {
                if(dfsCheck(it, adj, color,1 - col))
                    return false;
            }
            // if the node has been previously visited
            // but it has to be visited on the same path
            else if(color[it] == col) {
                return false;
            }
        }

        return true;
    }

    // Function to detect cycle in a directed graph.
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i = 0;i<V;i++) {
            if(color[i] == 0) {
                if(dfsCheck(i, adj,color,1)) return true;
            }
        }
        return false;
    }
}

