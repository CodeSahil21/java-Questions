package Topics.Heaps.Medium;
import java.util.*;
public class Quest4 {
    public static void main(String[] args) {
        // Create the input array
        int[] arr = {6, 5, 3, 2, 8, 10, 9};

        // Define k (though it's ignored in this brute force method)
        int k = 3;


        System.out.println("Original Array: " + Arrays.toString(arr));

        // Call the function to sort the array
        int[] result = sortNearlySortedArray(arr, k);

        // Print the sorted array
        System.out.println("Sorted Array: " + Arrays.toString(result));

        // Expected Output: [2, 3, 5, 6, 8, 9, 10]
    }

    public static int[] sortNearlySortedArray(int[] arr, int k) {
        Arrays.sort(arr);
        return arr;
    }
    public static List<Integer> sortNearlySortedArray(List<Integer> arr, int k) {
        // Min Heap Initialization (PriorityQueue defaults to Min Heap)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        List<Integer> result = new ArrayList<>();

        // 1. Initial Fill (First K+1 elements)
        // The loop condition i <= k ensures k+1 elements are added (indices 0 to k).
        // i < arr.size() handles the edge case where the array is smaller than k+1.
        for (int i = 0; i <= k && i < arr.size(); i++) {
            minHeap.add(arr.get(i));
        }

        // 2. Main Sliding Window Loop
        // Starts at the (k+1)th index, moving the window one by one.
        for (int i = k + 1; i < arr.size(); i++) {
            // Output the smallest element from the current window [i-(k+1), i-1]
            result.add(minHeap.poll());

            // Add the new element, expanding the window to the right: [i-k, i]
            minHeap.add(arr.get(i));
        }

        // 3. Final Cleanup
        // The heap now contains the last k+1 elements of the array.
        // They are extracted in ascending order to complete the sorted result.
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        return result;
    }
}
