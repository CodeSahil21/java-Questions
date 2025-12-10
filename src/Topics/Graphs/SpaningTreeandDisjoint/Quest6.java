package Topics.Graphs.SpaningTreeandDisjoint;

public class Quest6 {

        public static void main(String[] args) {
            int[][] isConnected = {
                    {1, 1, 0},
                    {1, 1, 0},
                    {0, 0, 1}
            };
            int n = isConnected.length;

            int provinces = findCircleNum(isConnected);
            System.out.println("Number of Provinces: " + provinces);
        }


        public static int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            DisjointSet1 ds = new DisjointSet1(n);

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (isConnected[i][j] == 1) {
                        ds.unionBySize(i, j);
                    }
                }
            }

            int count = 0;
            for (int i = 0; i < n; i++) {
                if (ds.findUPar(i) == i) {
                    count++;
                }
            }

            return count;
        }


}
