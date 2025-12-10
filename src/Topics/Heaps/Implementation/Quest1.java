package Topics.Heaps.Implementation;

class BinaryHeap {
    // Maximum elements that can be stored in heap
    static int capacity;

    // Current no of elements in heap
    static int size;

    // Array for storing the keys
    static int[] arr;

    /**
     * Constructor for the BinaryHeap.
     *
     * @param cap The maximum capacity of the heap.
     */
    BinaryHeap(int cap) {
        // Assigning the capacity
        capacity = cap;

        // Initially size of heap is zero
        size = 0;

        // Creating an array
        arr = new int[capacity];
    }

    // Returns the parent of ith Node
     int parent(int i) {
        return (i - 1) / 2;
    }

    // Returns the left child of ith Node
     int left(int i) {
        return 2 * i + 1;
    }

    // Returns the right child of the ith Node
     int right(int i) {
        return 2 * i + 2;
    }

    // Swaps two elements in the array
    private  void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Insert a new key x
     void Insert(int x) {
        if (size == capacity) {
            System.out.println("Binary Heap Overflown");
            return;
        }

        // Insert new element at end
        arr[size] = x;

        // Store the index, for checking heap property
        int k = size;

        // Increase the size
        size++;

        // Fix the min heap property (Bubble Up)
        while (k != 0 && arr[parent(k)] > arr[k]) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    // Fixes the Min Heap property from the given index downwards (Heapify Down)
    void Heapify(int ind) {
        // Right child
        int ri = right(ind);

        // Left child
        int li = left(ind);

        // Initially assume violated value is minimum
        int smallest = ind;

        if (li < size && arr[li] < arr[smallest])
            smallest = li;

        if (ri < size && arr[ri] < arr[smallest])
            smallest = ri;

        // If the Minimum among the three nodes is not the parent itself,
        // then swap and call Heapify recursively
        if (smallest != ind) {
            swap(ind, smallest);
            Heapify(smallest);
        }
    }

    // Returns the minimum element (the root)
     int getMin() {
        if (size == 0) return Integer.MAX_VALUE;
        return arr[0];
    }

    // Extracts and removes the minimum element
     int ExtractMin() {
        if (size <= 0)
            return Integer.MAX_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }

        int mini = arr[0];

        // Copy last Node value to root Node
        arr[0] = arr[size - 1];

        size--;

        // Call heapify on root node to fix the property
        Heapify(0);

        return mini;
    }

    // Decreases the value of element at index i to val
     void Decreasekey(int i, int val) {
        // Updating the new value
        arr[i] = val;

        // Fixing the Min heap (Bubble Up)
        while (i != 0 && arr[parent(i)] > arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Deletes the element at index i
     void Delete(int i) {
        // Force the element to the root
        Decreasekey(i, Integer.MIN_VALUE);
        // Extract it
        ExtractMin();
    }

    // Prints the current elements of the heap array
     void print() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}// Main method to demonstrate functionality

public class Quest1 {
    public static void main(String args[]) {
        BinaryHeap h = new BinaryHeap(20);

        h.Insert(4);
        h.Insert(1);
        h.Insert(2);
        h.Insert(6);
        h.Insert(7);
        h.Insert(3);
        h.Insert(8);
        h.Insert(5);

        System.out.print("Heap after initial insertions: ");
        h.print(); // Output: 1 3 2 6 7 4 8 5

        System.out.println("Min value is " + h.getMin()); // Output: 1

        h.Insert(-1);
        System.out.println("Min value after inserting -1 is " + h.getMin()); // Output: -1

        h.Decreasekey(3, -2); // The element '6' at index 3 is changed to -2
        System.out.println("Min value after Decreasekey is " + h.getMin()); // Output: -2

        h.ExtractMin();
        System.out.println("Min value after ExtractMin is " + h.getMin()); // Output: 1

        // After ExtractMin, the heap is: 1 3 2 5 7 4 8. Index 0 now holds 1.
        // Deleting the root (index 0)
        h.Delete(0);
        System.out.println("Min value after Delete(0) is " + h.getMin()); // Output: 2
    }
}

