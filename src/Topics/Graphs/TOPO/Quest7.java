package Topics.Graphs.TOPO;
import java.util.*;
//https://leetcode.com/problems/alien-dictionary/editorial/
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
    public static String findOrder(String [] dict, int N, int K) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }


        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        List<Integer> topo = topoSort(K, adj);
        String ans = "";
        for (int it : topo) {
            ans = ans + (char)(it + (int)('a'));
        }

        return ans;

    }
}
/*
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
            int node = q.poll();
            topo.add(node);

            // Reduce in-degrees of adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return topo;
    }

    public static String findOrder(String[] dict, int N, int K) {
        // Step 1: Build the adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];

            // Check for condition 1: Larger string appearing before a shorter one
            if (s1.length() > s2.length() && s1.startsWith(s2)) {
                return ""; // Invalid order due to dictionary logic
            }

            int len = Math.min(s1.length(), s2.length());
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    break;
                }
            }
        }

        // Step 2: Perform topological sort
        List<Integer> topo = topoSort(K, adj);

        // Step 3: Check for condition 2: Cyclic dependency
        if (topo.size() < K) {
            return ""; // Invalid order due to cyclic dependency
        }

        // Step 4: Convert topological order to a string
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            ans.append((char) (it + 'a'));
        }

        return ans.toString();
    }

    public static void main(String[] args) {
        // Example 1: Valid order
        String[] dict1 = {"abcd", "abc"};
        int N1 = 2;
        int K1 = 4;

        String order1 = findOrder(dict1, N1, K1);
        if (order1.isEmpty()) {
            System.out.println("A valid order is not possible (Example 1).");
        } else {
            System.out.println("The valid order is: " + order1);
        }

        // Example 2: Cyclic dependency
        String[] dict2 = {"abc", "bca", "cab"};
        int N2 = 3;
        int K2 = 3;

        String order2 = findOrder(dict2, N2, K2);
        if (order2.isEmpty()) {
            System.out.println("A valid order is not possible (Example 2).");
        } else {
            System.out.println("The valid order is: " + order2);
        }
    }
 */

