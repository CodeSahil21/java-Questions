package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://www.geeksforgeeks.org/problems/implementing-dijkstra-set-1-adjacency-matrix/1
class Pair3{
    int node;
    int distance;
    public Pair3(int distance,int node){
        this.node = node;
        this.distance = distance;
    }
}
public class Quest5 {
    public static void main(String[] args) {
        int V = 5; // Number of vertices
        int S = 0; // Source node

        // Adjacency list to represent the graph
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

        // Initializing the adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Adding edges to the graph
        // Edge format: {destination, weight}
        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(4, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 3)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 6)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(2, 2)));
        adj.get(4).add(new ArrayList<>(Arrays.asList(3, 4)));

        // Call the dijkstra function
        int[] result = dijkstra(V, adj, S);

        // Print the shortest distances from the source to all nodes
        System.out.println("Shortest distances from source " + S + ":");
        for (int i = 0; i < result.length; i++) {
            System.out.println("Node " + i + " : " + result[i]);
        }
    }
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
   public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S) {
       // Create a priority queue for storing the nodes as a pair {dist, node}
       // where dist is the distance from source to the node.
       PriorityQueue<Pair3> pq = new PriorityQueue<Pair3>((x, y) -> x.distance - y.distance);

       int[] dist = new int[V];

       // Initializing dist array with a large number to
       // indicate the nodes are unvisited initially.
       // This array contains distance from source to the nodes.
       Arrays.fill(dist, (int) (1e9));

       // Source initialized with dist = 0.
       dist[S] = 0;
       pq.add(new Pair3(0, S));

       // Now, pop the minimum distance node first from the min-heap
       // and traverse all its adjacent nodes.
       while (!pq.isEmpty()) {
           int dis = pq.peek().distance;
           int node = pq.peek().node;
           pq.remove();

           // Check all adjacent nodes of the popped element
           // whether the previous distance is larger than the current one.
           for (int i = 0; i < adj.get(node).size(); i++) {
               int edgeWeight = adj.get(node).get(i).get(1);
               int adjNode = adj.get(node).get(i).get(0);

               // If the current distance is smaller,
               // update the distance and push it into the queue.
               if (dis + edgeWeight < dist[adjNode]) {
                   dist[adjNode] = dis + edgeWeight;
                   pq.add(new Pair3(dist[adjNode], adjNode));
               }
           }
       }

       // Return the array containing shortest distances
       // from source to all the nodes.
       return dist;
   }

}
