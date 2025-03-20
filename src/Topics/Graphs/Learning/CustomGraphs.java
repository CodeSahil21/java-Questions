package Topics.Graphs.Learning;
import java.util.*;
public class CustomGraphs {
    private int vertices; // Number of vertices
    private ArrayList<ArrayList<Integer>> adjacencyList;

    // Constructor
    public CustomGraphs(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList.get(source).add(destination);
        adjacencyList.get(destination).add(source); // For an undirected graph
    }

    // Display the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 3; // Number of nodes
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        // Initialize the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges
        adj.get(1).add(2);
        adj.get(2).add(1);
/*
//for undirected graph only
        adj.get(u).add(v);
        adj.get(v).add(u);
//for directed graph
        adj.get(u).add(v);

 */
        adj.get(2).add(3);
        adj.get(3).add(2);

        adj.get(1).add(3);
        adj.get(3).add(1);

        // Print the adjacency list
        for (int i = 1; i <= n; i++) {
            System.out.print("Node " + i + ": ");
            for (int neighbor : adj.get(i)) {
                System.out.print(neighbor + " ");
            }
            System.out.println();
        }
    }
}
class WeightedGraph {
    private int vertices; // Number of vertices
    private ArrayList<ArrayList<Pair>> adjacencyList;
    private boolean isDirected; // Flag for directed graph

    // Constructor
    public WeightedGraph(int vertices, boolean isDirected) {
        this.vertices = vertices;
        this.isDirected = isDirected;
        adjacencyList = new ArrayList<>();

        // Initialize the adjacency list for each vertex
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Add an edge with a weight
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Pair(destination, weight));

        // Add the reverse edge only if it's an undirected graph
        if (!isDirected) {
            adjacencyList.get(destination).add(new Pair(source, weight));
        }
    }

    // Display the graph
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Pair neighbor : adjacencyList.get(i)) {
                System.out.print("(" + neighbor.node + ", weight: " + neighbor.weight + ") ");
            }
            System.out.println();
        }
    }

    // Helper class to represent a vertex and its weight
    class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}