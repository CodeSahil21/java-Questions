package Topics.Graphs.BFSandDFS;
import java.util.*;
//https://leetcode.com/problems/is-graph-bipartite/description/   BFS
public class Quest11 {
    public static void main(String[] args) {
// Example adjacency matrix
        int[][] matrix = {
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };

        // Convert adjacency matrix to ArrayList of ArrayLists
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    neighbors.add(j);
                }
            }
            /*
              // Convert the matrix to an adjacency list
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j < matrix[i].length; j++) {
                neighbors.add(matrix[i][j]);
            }
            adjList.add(neighbors);
        }
            */
            adjList.add(neighbors);

            // Check if the graph is bipartite
            boolean isBipartite = isBipartite(matrix.length, adjList);
            System.out.println("Is the graph bipartite? " + isBipartite);
        }
    }
    private static boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                if (color[it] == -1) { // If not yet colored
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) { // Same color detected
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isBipartite(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[V];
        Arrays.fill(color, -1);

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, V, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
/*
public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int m = graph[0].length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         for (int i = 0; i < n; i++) {
            ArrayList<Integer> neighbors = new ArrayList<>();
            for (int j = 0; j <graph[i].length; j++) {
                neighbors.add(graph[i][j]);
            }
            adj.add(neighbors);
        }
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!check(i, n, adj, color)) {
                    return false;
                }
            }
        }
        return true;
    }
    private static boolean check(int start, int V, ArrayList<ArrayList<Integer>> adj, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 0;

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();

            for (int it : adj.get(node)) {
                if (color[it] == -1) { // If not yet colored
                    color[it] = 1 - color[node];
                    q.add(it);
                } else if (color[it] == color[node]) { // Same color detected
                    return false;
                }
            }
        }
        return true;
    }
 */
//dfs
    /*
    private boolean dfs(int node, int col, int color[], ArrayList<ArrayList<Integer>>adj) {

        color[node] = col;

        // traverse adjacent nodes
        for(int it : adj.get(node)) {
            // if uncoloured
            if(color[it] == -1) {
                if(dfs(it, 1 - col, color, adj) == false) return false;
            }
            // if previously coloured and have the same colour
            else if(color[it] == col) {
                return false;
            }
        }

        return true;
    }
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        int color[] = new int[V];
	    for(int i = 0;i<V;i++) color[i] = -1;

	    // for connected components
	    for(int i = 0;i<V;i++) {
	        if(color[i] == -1) {
	            if(dfs(i, 0, color, adj) == false) return false;
	        }
	    }
	    return true;
    }
     public static void main(String[] args)
    {
        // V = 4, E = 4
        ArrayList < ArrayList < Integer >> adj = new ArrayList < > ();
        for (int i = 0; i < 4; i++) {
            adj.add(new ArrayList < > ());
        }
        adj.get(0).add(2);
        adj.get(2).add(0);
        adj.get(0).add(3);
        adj.get(3).add(0);
        adj.get(1).add(3);
        adj.get(3).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);


        boolean ans = isBipartite(4, adj);
        if(ans)
            System.out.println("1");
        else System.out.println("0");
    }
     */
}
