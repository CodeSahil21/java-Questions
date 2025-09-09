package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://leetcode.com/problems/cheapest-flights-within-k-stops/description/
class Pair5{
    int first;
    int second;
    public Pair5(int first,int second){
        this.first = first;
        this.second = second;
    }
}
class Tuple2 {
    int first, second, third;
    Tuple2(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
public class Quest10 {
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = {
                {0, 1, 100},
                {1, 2, 100},
                {2, 3, 100},
                {0, 2, 500}
        };
        int src = 0;
        int dst = 3;
        int k = 1;

        int result = findCheapestPrice(n, flights, src, dst, k);
        System.out.println("Cheapest price from " + src + " to " + dst + " with at most " + k + " stops: " + result);
    }
        public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // Create the adjacency list to depict airports and flights in
        // the form of a graph.
        ArrayList<ArrayList<Pair5>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0;i<m;i++) {
            adj.get(flights[i][0]).add(new Pair5(flights[i][1], flights[i][2]));
        }

        // Create a queue which stores the node and their distances from the
        // source in the form of {stops, {node, dist}} with ‘stops’ indicating
        // the no. of nodes between src and current node.
        Queue<Tuple2> q = new LinkedList<>();

        q.add(new Tuple2(0, src, 0));

        // Distance array to store the updated distances from the source.
        int[] dist = new int[n];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        // Iterate through the graph using a queue like in Dijkstra with
        // popping out the element with min stops first.
        while(!q.isEmpty()) {
            Tuple2 it = q.peek();
            q.remove();
            int stops = it.first;
            int node = it.second;
            int cost = it.third;

            // We stop the process as soon as the limit for the stops reaches.
            if(stops > k) continue;
            for(Pair5 iter: adj.get(node)) {
                int adjNode = iter.first;
                int edW = iter.second;

                // We only update the queue if the new calculated dist is
                // less than the prev and the stops are also within limits.
                if (cost + edW < dist[adjNode] && stops <= k) {
                    dist[adjNode] = cost + edW;
                    q.add(new Tuple2(stops + 1, adjNode, cost + edW));
                }
            }
        }
        // If the destination node is unreachable return ‘-1’
        // else return the calculated dist from src to dst.
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
