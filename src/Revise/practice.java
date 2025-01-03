package Revise;
import java.util.*;
public class practice {
}
 class MinHeap {
    private ArrayList<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index) < list.get(p)) {
            swap(index, p);
            upheap(p);
        }
    }

    public int remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        int temp = list.get(0);
        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int min = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(min) > list.get(left)) {
            min = left;
        }

        if (right < list.size() && list.get(min) > list.get(right)) {
            min = right;
        }

        if (min != index) {
            swap(min, index);
            downheap(min);
        }
    }

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }
}


 class MaxHeap {
    private ArrayList<Integer> list;

    public MaxHeap() {
        list = new ArrayList<>();
    }

    private void swap(int first, int second) {
        int temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int left(int index) {
        return index * 2 + 1;
    }

    private int right(int index) {
        return index * 2 + 2;
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }

    private void upheap(int index) {
        if (index == 0) {
            return;
        }
        int p = parent(index);
        if (list.get(index) > list.get(p)) {
            swap(index, p);
            upheap(p);
        }
    }

    public int remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Removing from an empty heap!");
        }

        int temp = list.get(0);
        int last = list.remove(list.size() - 1);
        if (!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return temp;
    }

    private void downheap(int index) {
        int max = index;
        int left = left(index);
        int right = right(index);

        if (left < list.size() && list.get(max) < list.get(left)) {
            max = left;
        }

        if (right < list.size() && list.get(max) < list.get(right)) {
            max = right;
        }

        if (max != index) {
            swap(max, index);
            downheap(max);
        }
    }

    public ArrayList<Integer> heapSort() throws Exception {
        ArrayList<Integer> data = new ArrayList<>();
        while (!list.isEmpty()) {
            data.add(this.remove());
        }
        return data;
    }

     public boolean isEmpty() {
        return list.isEmpty();
     }
 }

 class Main {
    public static void main(String[] args) throws Exception {
        int[] array = {10, 20, 30, 40, 50};
        System.out.println(productOfThreeLargestDistinct(array));
    }

    public static int productOfThreeLargestDistinct(int[] array) throws Exception {
        MaxHeap heap = new MaxHeap();
        Set<Integer> distinctElements = new HashSet<>();

        // Insert elements into the max heap
        for (int value : array) {
            if (!distinctElements.contains(value)) {
                heap.insert(value);
                distinctElements.add(value);
            }
        }

        // Remove the three largest distinct elements
        int product = 1;
        for (int i = 0; i < 3; i++) {
            if (!heap.isEmpty()) {
                int value = heap.remove();
                product *= value;
            } else {
                throw new IllegalArgumentException("Array has less than three distinct elements");
            }
        }

        return product;
    }
}
