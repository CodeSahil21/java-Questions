package Topics.Graphs.SpaningTreeandDisjoint;

public class Quest5 {
    public static void main(String[] args) {

        int n = 6;
        int[][] connections = {
                {0, 1},
                {0, 2},
                {0, 3},
                {1, 4}
                // Note: One computer (5) is disconnected
        };

        int operationsNeeded = makeConnected(n, connections);
        System.out.println("Minimum operations needed to connect all computers: " + operationsNeeded);
    }
    public static int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;
        DisjointSet1 ds = new DisjointSet1(n);
        for (int i = 0; i < connections.length; i++) {
            int u = connections[i][0];
            int v = connections[i][1];
            ds.unionBySize(u, v);
        }
        int cnt =0;
        for (int j = 0; j < n; j++) {
            if(ds.findUPar(j)==j){
                cnt++;
            }
        }
        return cnt-1;
    }

}
