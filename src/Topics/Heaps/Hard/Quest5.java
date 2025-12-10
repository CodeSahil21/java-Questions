package Topics.Heaps.Hard;
import java.util.*;
//https://leetcode.com/problems/find-median-from-data-stream/description/
public class Quest5 {
    public static void main(String[] args) {

    }

}


class MedianFinder {
    // Max-heap: Stores the smaller half (Max element is the largest of the small numbers)
    private PriorityQueue<Integer> maxHeap;

    // Min-heap: Stores the larger half (Min element is the smallest of the large numbers)
    private PriorityQueue<Integer> minHeap;

    // Constructor
    public MedianFinder() {
        // Max-Heap: uses reverse order comparator
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        // Min-Heap: uses default natural order
        minHeap = new PriorityQueue<>();
    }

    // O(log N) Time Complexity
    public void addNum(int num) {
        // Step 1 & 2: Maintain Ordering Invariant
        // 1. Add 'num' to maxHeap (the smaller half)
        maxHeap.offer(num);
        // 2. Move the largest element from maxHeap to minHeap.
        // This ensures all elements in maxHeap are truly smaller than those in minHeap.
        minHeap.offer(maxHeap.poll());

        // Step 3: Maintain Size Invariant
        // If minHeap is ever larger, move its smallest element back to maxHeap.
        // This guarantees maxHeap is the larger of the two heaps.
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    // O(1) Time Complexity
    public double findMedian() {
        // Case 1: Even total count (sizes are equal)
        if (maxHeap.size() == minHeap.size()) {
            // Median is the average of the two middle elements (S1 and L1)
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }

        // Case 2: Odd total count (maxHeap is larger by 1)
        // Median is the single middle element, which is the largest element in the smaller half (S1).
        return maxHeap.peek();
    }
}