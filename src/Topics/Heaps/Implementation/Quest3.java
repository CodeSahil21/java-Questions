package Topics.Heaps.Implementation;

public class Quest3 {
    public static void main(String[] args) {
        int[] nums = {10, 20, 30, 21, 23};

        // Output result
        boolean output = isMinHeap(nums);
        System.out.println(output ? "true" : "false");
    }
    public static boolean isMinHeap(int[] nums) {
        int n = nums.length;

        // Iterate through all non-leaf nodes
        for (int i = 0; i <= (n / 2) - 1; i++) {

            // Calculate the index of the left child
            int left = 2 * i + 1;

            // If left child exists and is smaller than parent, not a min-heap
            if (left < n && nums[i] > nums[left]) {
                return false;
            }

            // Calculate the index of the right child
            int right = 2 * i + 2;

            // If right child exists and is smaller than parent, not a min-heap
            if (right < n && nums[i] > nums[right]) {
                return false;
            }
        }

        // If no violations found, it is a min-heap
        return true;
    }
    public static boolean isMaxHeap(int[] nums) {
        int n = nums.length;

        // Iterate through all non-leaf nodes (potential parents)
        for (int i = 0; i <= (n / 2) - 1; i++) {

            // 1. Check Left Child
            int left = 2 * i + 1;

            // If left child exists AND parent < left child, it's a violation.
            if (left < n && nums[i] < nums[left]) {
                return false; // Violation: Parent is smaller than a child
            }

            // 2. Check Right Child
            int right = 2 * i + 2;

            // If right child exists AND parent < right child, it's a violation.
            if (right < n && nums[i] < nums[right]) {
                return false; // Violation: Parent is smaller than a child
            }
        }

        // If no parent was found to be smaller than its child, it is a Max Heap
        return true;
    }
}
