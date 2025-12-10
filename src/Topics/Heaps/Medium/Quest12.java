package Topics.Heaps.Medium;
import java.util.*;
public class Quest12 {
    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;

        System.out.println("--- Test Case 1 ---");
        System.out.println("Array: " + Arrays.toString(nums1) + ", K = " + k1);

        // Kth Smallest (Expected: 2)
        int kthSmallest1 = findKthSmallest(nums1, k1);
        System.out.println(k1 + "th Smallest Element: " + kthSmallest1 + " (Correct: " + (kthSmallest1 == 2) + ")");

        // Kth Largest (Expected: 5)
        int kthLargest1 = findKthLargest(nums1, k1);
        System.out.println(k1 + "th Largest Element: " + kthLargest1 + " (Correct: " + (kthLargest1 == 5) + ")");

        System.out.println("\n------------------------------");

        // Test Case 2: Array with Duplicates
        int[] nums2 = {7, 10, 4, 3, 20, 15};
        int k2 = 3;

        System.out.println("--- Test Case 2 ---");
        System.out.println("Array: " + Arrays.toString(nums2) + ", K = " + k2);

        // Kth Smallest (Sorted: 3, 4, 7, 10, 15, 20. Expected 3rd smallest: 7)
        int kthSmallest2 = findKthSmallest(nums2, k2);
        System.out.println(k2 + "rd Smallest Element: " + kthSmallest2 + " (Correct: " + (kthSmallest2 == 7) + ")");

        // Kth Largest (Sorted: 20, 15, 10, 7, 4, 3. Expected 3rd largest: 10)
        int kthLargest2 = findKthLargest(nums2, k2);
        System.out.println(k2 + "rd Largest Element: " + kthLargest2 + " (Correct: " + (kthLargest2 == 10) + ")");
    }
    public static int findKthLargest(int[] nums, int k) {
        // Min Heap (default PriorityQueue behavior)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            // If the heap size exceeds k, remove the smallest element in the heap.
            // This ensures the heap only keeps the K largest elements seen so far.
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        // The root of the Min Heap is the Kth largest element.
        return minHeap.peek();
    }
    public static int findKthSmallest(int[] nums, int k) {
        // Max Heap: The lambda (b, a) -> b - a ensures that the largest element (b)
        // has the highest priority and sits at the root.
        // Using Integer.compare(b, a) is safer than (b - a) to avoid potential
        // integer overflow issues with large negative numbers.
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for (int num : nums) {
            maxHeap.add(num);

            // If the heap size exceeds k, remove the maximum element (root).
            // This drops the current largest of the 'K smallest' we are tracking.
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // The remaining root is the largest among the K smallest elements, which is the Kth smallest.
        return maxHeap.peek();
    }
}
