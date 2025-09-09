package Revise.Graphs.BfsAndDfs;
import java.util.ArrayList;
public class Quest1 {
    public static void main(String[] args) {
        int[][] isConnected = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
  int ans = numOfProvinces(isConnected);
        System.out.println(ans);
    }
   public static int numOfProvinces(int[][] connected){

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < connected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0 ; i < connected.length;i++){
            for (int j = 0; j < connected.length; j++) {
                if(connected[i][j] == 1 && i != j){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        int[] vis = new int[connected.length];
        int provinceCount  = 0;
        for(int i = 0 ; i < connected.length;i++){
            if(vis[i] == 0){
                provinceCount++;
                dfs(i,adj,vis);
            }
        }
        return provinceCount;
   }

   private static void dfs(int node,ArrayList<ArrayList<Integer>> adj,int[] vis){
        vis[node] = 1;
        for(int neighbour : adj.get(node)){
            if(vis[neighbour] == 0 ){
                dfs(neighbour,adj,vis);
            }
        }
   }
}
