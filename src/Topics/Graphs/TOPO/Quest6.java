package Topics.Graphs.TOPO;
import java.util.*;
//https://leetcode.com/problems/course-schedule-ii/description/
public class Quest6 {
    public static void main(String[] args) {
        int numCourses = 4; // Number of courses
        int[][] prerequisites = {
                {1, 0}, // To take course 1, you must complete course 0
                {2, 1}, // To take course 2, you must complete course 1
                {3, 2}  // To take course 3, you must complete course 2
        };

        int[] result = findOrder(numCourses, prerequisites);

        if (result.length > 0) {
            System.out.println("Order of courses to finish all: " + Arrays.toString(result));
        } else {
            System.out.println("It is not possible to finish all courses.");
        }
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        // Step 1: Create adjacency list representation of the graph
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Step 2: Calculate in-degrees for each node
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }

        // Step 3: Add all nodes with in-degree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // Step 4: Perform BFS to find the topological order
        int[] topo = new int[numCourses];
        int index = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            topo[index++] = node;

            // Reduce in-degree of all adjacent nodes
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }
        }

        // Step 5: Check if the topological sort is valid
        if (index == numCourses) {
            return topo; // Valid topological order
        }

        // Return an empty array if a cycle is detected
        return new int[0];
    }
}
