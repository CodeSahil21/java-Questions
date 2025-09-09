package Revise.Graphs.Topo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Quest7 {
    public static void main(String[] args) {
        int N = 5, K = 4;
        String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
        String ans = findOrder(dict, N, K);

        for (int i = 0; i < ans.length(); i++) {
            System.out.print(ans.charAt(i) + " ");
        }
        System.out.println("");
    }
  public static String findOrder(String[] dict,int N,int K){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0 ; i < K;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0 ; i < N-1;i++){
            String s1 = dict[i];
            String s2 = dict[i+1];
            if(s1.length()>s2.length()&&s1.startsWith(s2)){
                return "";
            }
            int len = Math.min(s1.length(),s2.length());
            for(int j = 0 ; j < len;j++){
                if(s1.charAt(j) != s2.charAt(j)){
                    adj.get((s1.charAt(j)-'a')).add(s2.charAt(j)-'a');
                    break;
                }
            }
        }
        List<Integer> topo = topoSort(K,adj);
        if(topo.size() < K){
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for(int it : topo){
            ans.append((char) (it + 'a'));
        }
        return ans.toString();
  }
      private static List<Integer> topoSort(int V, List<List<Integer>> adj) {
        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            topo.add(node);
            // node is in your topo sort
            // so please remove it from the indegree

            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) q.add(it);
            }
        }

        return topo;
    }
}
