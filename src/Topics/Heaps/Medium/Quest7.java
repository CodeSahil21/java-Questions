package Topics.Heaps.Medium;
import java.util.*;
public class Quest7 {

    public static void main(String[] args) {


        // Input task list
        char[] tasks = {'A','A','A','B','B','B'};

        // Cooldown
        int n = 2;

        // Output the result
        System.out.println(leastInterval(tasks, n));
    }
    public static int leastInterval(char[] tasks, int n) {

        // Step 1: Count frequency of each task
        Map<Character, Integer> freq = new HashMap<>();
        for (char task : tasks) {
            freq.put(task, freq.getOrDefault(task, 0) + 1);
        }

        // Step 2: Create a max heap (priority queue in reverse order)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int count : freq.values()) {
            maxHeap.add(count);
        }

        // Total time required
        int time = 0;

        // Step 3: Process tasks in cycles of size (n + 1)
        while (!maxHeap.isEmpty()) {

            // Temporary list to store tasks of current cycle
            List<Integer> temp = new ArrayList<>();

            // Set cycle size as cooldown + 1
            int cycle = n + 1;

            // Track number of tasks processed in current cycle
            int i = 0;

            // Run up to (n+1) tasks or until heap is empty
            while (i < cycle && !maxHeap.isEmpty()) {

                // Pick the most frequent task
                int count = maxHeap.poll();

                // Decrease frequency since task is used once
                count--;

                // If task still remains, store it for next cycle
                if (count > 0) {
                    temp.add(count);
                }

                // Count 1 unit time for this task
                time++;
                i++;
            }

            // Step 4: Push remaining tasks from temp back into the heap
            for (int rem : temp) {
                maxHeap.add(rem);
            }

            // Step 5: If heap is not empty, add idle time
            if (!maxHeap.isEmpty()) {
                time += (cycle - i);
            }
        }

        // Return total time taken
        return time;
    }

}
