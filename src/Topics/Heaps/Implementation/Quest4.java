package Topics.Heaps.Implementation;
import java.util.*;
public class Quest4 {
    public static void main(String[] args) {
        // --- 1. Max Heap Initialization ---
        // We use Collections.reverseOrder() to tell the PriorityQueue
        // to order elements in reverse of their natural order (largest first).
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        int[] inputElements = {4, 1, 2, 6, 7, 3, 8, 5};
        System.out.println("Input elements to be added: " + Arrays.toString(inputElements));

        // --- 2. Insertion ---
        for (int element : inputElements) {
            maxHeap.add(element);
        }

        // --- 3. Peek and Check Size ---
        System.out.println("\n--- Initial State ---");
        // Note: Printing the heap directly (toString) does NOT guarantee Max Heap order,
        // only that the Max element is at the root.
        System.out.println("PriorityQueue (Internal Array View): " + maxHeap);
        System.out.println("Max Element (Peek): " + maxHeap.peek()); // Should be the maximum value (8)
        System.out.println("Current Size: " + maxHeap.size());

        // --- 4. Extraction (Testing Max Heap Property) ---
        System.out.println("\n--- Extracting Elements (Poll) in Max Heap Order ---");

        // The poll() operation retrieves and removes the maximum element repeatedly.
        while (!maxHeap.isEmpty()) {
            int maxElement = maxHeap.poll();
            System.out.println("Extracted Max: " + maxElement);
        }

        System.out.println("\nFinal Size: " + maxHeap.size());
    }

}
