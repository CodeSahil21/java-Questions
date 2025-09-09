package Revise.Graphs.ShortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Tuple2{
    int first,second,third;
    Tuple2(int first,int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
class Pair5{
    int first,second;
    Pair5(int first,int second){
        this.first = first;
        this.second = second;
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
    public static int findCheapestPrice(int n,int[][] flights,int src,int dst,int k){
        ArrayList<ArrayList<Pair5>> adj = new ArrayList<>();
        for(int i = 0 ; i < n;i++){
            adj.add(new ArrayList<>());
        }
        int m = flights.length;
        for(int i = 0 ; i < m;i++){
            adj.get(flights[i][0]).add(new Pair5(flights[i][1],flights[i][2]));
        }
        Queue<Tuple2>  q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist,(int)(1e9));
        q.add(new Tuple2(0,src,0));
        dist[src] = 0;
        while (!q.isEmpty()){
            Tuple2 curr = q.peek();
            int stops = curr.first;
            int node = curr.second;
            int cost = curr.third;
            q.poll();
            if(stops > k){
                continue;
            }
            for(Pair5 it:adj.get(node)){
                int adjnode = it.first;
                int edgeWeight = it.second;
                if(dist[adjnode] > cost + edgeWeight && stops <= k){
                    dist[adjnode] = cost +edgeWeight;
                    q.add(new Tuple2(stops+1,adjnode,cost+edgeWeight));
                }
            }
        }
        if(dist[dst] == (int)(1e9)) return -1;
        return dist[dst];
    }
}
