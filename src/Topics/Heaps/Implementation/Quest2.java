package Topics.Heaps.Implementation;

class BinaryMaxHeap {
    // Maximum elements that can be stored in heap
    static int capacity;

    // Current no of elements in heap
    static int size;

    // Array for storing the keys
    static int[] arr;

    /**
     * Constructor for the BinaryMaxHeap.
     * @param cap The maximum capacity of the heap.
     */
    BinaryMaxHeap(int cap) {
        capacity = cap;
        size = 0;
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

        // Fix the MAX heap property (Bubble Up)
        // CONDITION: Swap if parent is SMALLER than the child.
        while (k != 0 && arr[parent(k)] < arr[k]) {
            swap(k, parent(k));
            k = parent(k);
        }
    }

    // Fixes the Max Heap property from the given index downwards
     void Heapify(int ind) {
        int ri = right(ind);
        int li = left(ind);

        // Initially assume violated value is maximum
        int largest = ind;

        // Find the LARGEST among the parent, left, and right
        if (li < size && arr[li] > arr[largest])
            largest = li;

        if (ri < size && arr[ri] > arr[largest])
            largest = ri;

        // If the Maximum among the three nodes is not the parent itself,
        // then swap and call Heapify recursively
        if (largest != ind) {
            swap(ind, largest);
            Heapify(largest);
        }
    }

    // Returns the maximum element (the root)
     int getMax() {
        if (size == 0) return Integer.MIN_VALUE;
        return arr[0];
    }

    // Extracts and removes the maximum element
     int ExtractMax() {
        if (size <= 0)
            return Integer.MIN_VALUE;

        if (size == 1) {
            size--;
            return arr[0];
        }

        int maxi = arr[0];

        // Copy last Node value to root Node
        arr[0] = arr[size - 1];

        size--;

        // Call heapify on root node
        Heapify(0);

        return maxi;
    }

    // Increases the value of element at index i to val
     void Increasekey(int i, int val) {
        // Updating the new value
        arr[i] = val;

        // Fixing the Max heap (Bubble Up)
        // CONDITION: Swap if parent is SMALLER than the child.
        while (i != 0 && arr[parent(i)] < arr[i]) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    // Deletes the element at index i
     void Delete(int i) {
        // Force the element to the root by making it the largest possible value
        Increasekey(i, Integer.MAX_VALUE);
        // Extract it
        ExtractMax();
    }

    // Prints the current elements of the heap array
     void print() {
        for (int i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

}
public class Quest2 {
    // Main method to demonstrate functionality
    public static void main(String args[]) {
        BinaryMaxHeap h = new BinaryMaxHeap(20);

        h.Insert(4);
        h.Insert(1);
        h.Insert(2);
        h.Insert(6);
        h.Insert(7);
        h.Insert(3);
        h.Insert(8);
        h.Insert(5);

        System.out.print("Heap after initial insertions: ");
        h.print(); // Output: 8 7 4 6 1 3 2 5 (or similar structure)

        System.out.println("Max value is " + h.getMax()); // Output: 8

        h.Insert(10);
        System.out.println("Max value after inserting 10 is " + h.getMax()); // Output: 10

        h.Increasekey(3, 12); // Element at index 3 is increased to 12
        System.out.println("Max value after Increasekey is " + h.getMax()); // Output: 12

        h.ExtractMax();
        System.out.println("Max value after ExtractMax is " + h.getMax()); // Output: 10 (or 8, depending on heap structure)

        // Delete the root (index 0)
        h.Delete(0);
        System.out.println("Max value after Delete(0) is " + h.getMax()); // The new max value
    }
}
