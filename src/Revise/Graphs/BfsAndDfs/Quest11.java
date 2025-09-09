package Revise.Graphs.BfsAndDfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
//            boolean isBipartite = isBipartite(matrix.length, adjList);
            boolean isBipartite = isBipartite(matrix.length, matrix);
            System.out.println("Is the graph bipartite? " + isBipartite);
        }
    }
    public static boolean isBipartite(int V, int[][] matrix) {
        int[] color = new int[V];
        Arrays.fill(color, -1); // -1 means unvisited

        for (int i = 0; i < V; i++) {
            if (color[i] == -1) {
                if (!check(i, V, matrix, color)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean check(int node, int V, int[][] matrix, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        color[node] = 0;

        while (!q.isEmpty()) {
            int val = q.poll();
            for (int i = 0; i < V; i++) {
                if (matrix[val][i] == 1) { // there's an edge between val and i
                    if (color[i] == -1) {
                        color[i] = 1 - color[val];
                        q.offer(i);
                    } else if (color[i] == color[val]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

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

     */
}
