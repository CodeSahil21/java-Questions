package Topics.Graphs.ShortestPathAlgo;
//https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/description/
public class Quest15 {
    public static void main(String[] args) {
        int n = 4; // Number of cities
        int[][] edges = {
                {0, 1, 3},
                {1, 2, 1},
                {1, 3, 4},
                {2, 3, 1}
        };
        int distanceThreshold = 4; // Maximum distance allowed

        // Create an instance of the class and call the method

        int cityNo = findTheCity(n, edges, distanceThreshold);

        // Print the result
        System.out.println("The city with the smallest number of reachable neighbors is: " + cityNo);
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Initialize the distance matrix
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        // Populate distances from the edges
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            dist[u][v] = wt;
            dist[v][u] = wt;
        }

        // Distance to self is 0
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }

        // Apply Floyd-Warshall algorithm to calculate shortest paths
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Find the city with the smallest number of reachable neighbors
        int cntCity = n;
        int cityNo = -1;
        for (int city = 0; city < n; city++) {
            int count = 0;
            for (int adjCity = 0; adjCity < n; adjCity++) {
                if (dist[city][adjCity] <= distanceThreshold) {
                    count++;
                }
            }

            // Update the city with fewer reachable cities or higher index in case of a tie
            if (count <= cntCity) {
                cntCity = count;
                cityNo = city;
            }
        }

        return cityNo;
    }
}
