package Topics.Heaps.Hard;
import java.util.*;
public class Quest3 {
    public long connectRopes(int[] ropeLengths) {
        // Create a Min-Heap (Java's default PriorityQueue is a Min-Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // 1. Load all initial rope lengths into the heap
        for (int length : ropeLengths) {
            minHeap.offer(length);
        }

        long totalCost = 0;

        // 2. Loop until only one rope (the final connected one) remains
        while (minHeap.size() > 1) {
            // a. Extract the two smallest ropes (O(logN))
            int first = minHeap.poll();
            int second = minHeap.poll();

            // b. Calculate and accumulate the cost
            int currentCost = first + second;
            totalCost += currentCost;

            // c. Insert the newly formed rope back into the heap (O(logN))
            minHeap.offer(currentCost);
        }

        // 3. Return the accumulated minimum cost
        return totalCost;
    }
}
