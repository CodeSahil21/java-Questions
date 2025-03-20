package Topics.Trees.BST;
import java.util.*;
public class BST {
    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public BST() {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int value) {
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            return node;
        }

        if (value < node.value) {
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length);
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public void display() {
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    //https://leetcode.com/problems/search-in-a-binary-search-tree/
    // Search for a value in the BST
    public Node searchBST(Node root, int val) {
        // Loop until either the tree is exhausted or the value is found
        while (root != null && root.value != val) {
            // Traverse left or right based on the value
            root = val < root.value ? root.left : root.right;
        }
        // Return the node containing the value or null if not found
        return root;
    }

    //https://www.geeksforgeeks.org/problems/minimum-element-in-bst/1
    // Find the minimum value in the BST
    public int findMin() {
        if (isEmpty()) {
            throw new IllegalStateException("The tree is empty.");
        }
        return findMin(root).value;
    }

    private Node findMin(Node node) {
        // The leftmost node contains the minimum value
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Find the maximum value in the BST
    public int findMax() {
        if (isEmpty()) {
            throw new IllegalStateException("The tree is empty.");
        }
        return findMax(root).value;
    }

    private Node findMax(Node node) {
        // The rightmost node contains the maximum value
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    //https://www.geeksforgeeks.org/problems/implementing-ceil-in-bst/1
// Method to find the ceiling value in the BST
    public int findCeil(Node root, int key) {
        // Initialize the variable to store the ceiling value
        int ceil = -1;

        // Traverse the BST until reaching the end or finding the key
        while (root != null) {
            // If the key is found, assign it as the ceiling and return
            if (root.value == key) {
                ceil = root.value;
                return ceil;
            }

            // If the key is greater, move to the right subtree
            if (key > root.value) {
                root = root.right;
            } else {
                // If the key is smaller, update ceil and move to the left subtree
                ceil = root.value;
                root = root.left;
            }
        }
        // Return the computed ceiling value
        return ceil;
    }

    // https://www.geeksforgeeks.org/problems/floor-in-bst/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-bst
    public int findFloor(Node root, int key) {
        // Initialize the variable to store the ceiling value
        int floor = -1;

        // Traverse the BST until reaching the end or finding the key
        while (root != null) {
            // If the key is found, assign it as the ceiling and return
            if (root.value == key) {
                floor = root.value;
                return floor;
            }


            if (key > root.value) {
                floor = root.value;
                root = root.right;

            } else {
                root = root.left;
            }
        }
        // Return the computed ceiling value
        return floor;
    }

    //https://leetcode.com/problems/delete-node-in-a-bst/description/
// Method to delete a node from the BST
    public Node deleteNode(Node root, int key) {
        if (root == null) {
            return null;
        }
        if (root.value == key) {
            return helper(root);
        }
        Node dummy = root;
        while (root != null) {
            if (root.value > key) {
                if (root.left != null && root.left.value == key) {
                    root.left = helper(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if (root.right != null && root.right.value == key) {
                    root.right = helper(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return dummy;
    }

    // Helper method to handle node deletion
    public Node helper(Node root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {
            Node rightChild = root.right;
            Node lastRight = findLastRight(root.left);
            lastRight.right = rightChild;
            return root.left;
        }
    }

    // Method to find the rightmost node of a subtree
    public Node findLastRight(Node root) {
        if (root.right == null) {
            return root;
        }
        return findLastRight(root.right);
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
// Reverse inorder traversal to find Kth largest element
    private void reverseInorder(Node node, int[] counter, int k, int[] kLargest) {
        if (node == null || counter[0] >= k) return;

        // Traverse right subtree first
        reverseInorder(node.right, counter, k, kLargest);

        // Increment counter after visiting right subtree
        counter[0]++;

        // Check if current node is the Kth largest
        if (counter[0] == k) {
            kLargest[0] = node.value;
            return;
        }

        // Traverse left subtree if Kth largest is not found
        reverseInorder(node.left, counter, k, kLargest);
    }

    // Inorder traversal to find Kth smallest element
    private void inorder(Node node, int[] counter, int k, int[] kSmallest) {
        if (node == null || counter[0] >= k) return;

        // Traverse left subtree
        inorder(node.left, counter, k, kSmallest);

        // Increment counter after visiting left subtree
        counter[0]++;

        // Check if current node is the Kth smallest
        if (counter[0] == k) {
            kSmallest[0] = node.value;
            return;
        }

        // Traverse right subtree if Kth smallest is not found
        inorder(node.right, counter, k, kSmallest);
    }

    // Method to find Kth smallest and largest elements
    public int[] findKth(Node root, int k) {
        int[] kSmallest = new int[]{Integer.MIN_VALUE};
        int[] kLargest = new int[]{Integer.MIN_VALUE};
        // Counter to track visited nodes
        int[] counter = new int[]{0};

        // Find Kth smallest element
        inorder(root, counter, k, kSmallest);

        // Reset counter for Kth largest element
        counter[0] = 0;

        // Find Kth largest element
        reverseInorder(root, counter, k, kLargest);

        return new int[]{kSmallest[0], kLargest[0]};
    }

    //https://leetcode.com/problems/validate-binary-search-tree/description/
// Method to validate if a tree is a BST
    public boolean isValidBST(Node root) {
        return validate(root, null, null);
    }

    private boolean validate(Node node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        // Check if the current node violates the min/max constraints
        if ((min != null && node.value <= min) || (max != null && node.value >= max)) {
            return false;
        }

        // Recursively validate the left and right subtrees
        return validate(node.left, min, node.value) && validate(node.right, node.value, max);
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
    public Node findLCA(Node root, Node p, Node q) {
        if (root == null) {
            return null;
        }

        // If both p and q are smaller than root, explore the left subtree
        if (p.value < root.value && q.value < root.value) {
            return findLCA(root.left, p, q);
        }

        // If both p and q are greater than root, explore the right subtree
        if (p.value > root.value && q.value > root.value) {
            return findLCA(root.right, p, q);
        }

        // If neither of the above conditions are true, current root is the LCA
        return root;
    }

    //https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
// New method to construct a BST from preorder traversal
    public Node bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE, new int[]{0});
    }

    private Node bstFromPreorder(int[] preorder, int bound, int[] i) {
        if (i[0] == preorder.length || preorder[i[0]] > bound) return null;
        Node root = new Node(preorder[i[0]++]);
        root.left = bstFromPreorder(preorder, root.value, i);
        root.right = bstFromPreorder(preorder, bound, i);
        return root;
    }

    //https://leetcode.com/problems/inorder-successor-in-bst/description/
// Method to find the in-order successor of a given node
    public Node inorderSuccessor(Node root, Node p) {
        Node successor = null;

        while (root != null) {
            if (p.value >= root.value) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }

        return successor;
    }

    //https://leetcode.com/problems/binary-search-tree-iterator/description/
// BSTIterator class for traversal
    public class BSTIterator {
        private Stack<Node> stack = new Stack<>();

        public BSTIterator(Node root) {
            pushAll(root);
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            Node tmpNode = stack.pop();
            pushAll(tmpNode.right);
            return tmpNode.value;
        }

        private void pushAll(Node node) {
            for (; node != null; stack.push(node), node = node.left) ;
        }
    }

    //https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
    public class BSTIterator2 {
        private Stack<Node> stack = new Stack<>();
        private boolean reverse; // Indicates the direction of traversal: true for reverse, false for forward

        public BSTIterator2(Node root, boolean isReverse) {
            this.reverse = isReverse;
            pushAll(root);
        }

        /**
         * @return whether we have a next smallest/largest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest/largest number
         */
        public int next() {
            Node tmpNode = stack.pop();
            if (!reverse) { // Forward traversal
                pushAll(tmpNode.right);
            } else { // Reverse traversal
                pushAll(tmpNode.left);
            }
            return tmpNode.value;
        }

        private void pushAll(Node node) {
            while (node != null) {
                stack.push(node);
                if (reverse) { // Reverse in-order traversal: right subtree first
                    node = node.right;
                } else { // Normal in-order traversal: left subtree first
                    node = node.left;
                }
            }
        }
    }

        public boolean findTarget(Node root, int k) {
            if (root == null) return false;

            BSTIterator2 leftIter = new BSTIterator2(root, false); // Normal in-order traversal
            BSTIterator2 rightIter = new BSTIterator2(root, true);  // Reverse in-order traversal

            int i = leftIter.next(); // Start with smallest value
            int j = rightIter.next(); // Start with largest value

            // Two-pointer approach
            while (i < j) {
                if (i + j == k) {
                    return true; // Found the pair
                } else if (i + j < k) {
                    i = leftIter.next(); // Move forward in in-order traversal
                } else {
                    j = rightIter.next(); // Move backward in reverse in-order traversal
                }
            }
            return false; // No pair found
        }
//https://leetcode.com/problems/recover-binary-search-tree/description/
public class RecoverBST {
    private Node first = null;  // First incorrect node
    private Node middle = null; // Node adjacent to the first (if swapped nodes are adjacent)
    private Node last = null;   // Second incorrect node (if not adjacent)
    private Node prev = null;   // Tracks the previously visited node

    // Method to recover the BST
    public void recoverTree(Node root) {
        // In-order traversal to identify swapped nodes
        inorder(root);

        // Fix the BST by swapping the values of the incorrect nodes
        if (first != null && last != null) {
            int temp = first.value;
            first.value = last.value;
            last.value = temp;
        } else if (first != null && middle != null) {
            int temp = first.value;
            first.value = middle.value;
            middle.value = temp;
        }
    }

    // In-order traversal to find the swapped nodes
    private void inorder(Node root) {
        if (root == null) return;

        // Traverse left subtree
        inorder(root.left);

        // Check for violations
        if (prev != null && root.value < prev.value) {
            // First violation
            if (first == null) {
                first = prev;
                middle = root;
            } else {
                // Second violation
                last = root;
            }
        }
        // Update prev node
        prev = root;

        // Traverse right subtree
        inorder(root.right);
    }
}
//https://www.geeksforgeeks.org/problems/largest-bst/1
public class LargestBSTInBinaryTree {

    // Class to store information about a subtree
    static class SubtreeInfo {
        int size;        // Size of the subtree
        int min;         // Minimum value in the subtree
        int max;         // Maximum value in the subtree
        boolean isBST;   // Whether the subtree is a BST

        SubtreeInfo(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }

    // Main function to find the largest BST
    public int largestBST(Node root) {
        return largestBSTHelper(root).size;
    }

    // Helper function to calculate information about the largest BST
    private SubtreeInfo largestBSTHelper(Node node) {
        // Base case: Null node
        if (node == null) {
            return new SubtreeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }

        // Recurse for left and right subtrees
        SubtreeInfo leftInfo = largestBSTHelper(node.left);
        SubtreeInfo rightInfo = largestBSTHelper(node.right);

        // Check if the current subtree is a BST
        if (leftInfo.isBST && rightInfo.isBST &&
                node.value > leftInfo.max && node.value < rightInfo.min) {
            int size = leftInfo.size + rightInfo.size + 1;
            int min = Math.min(node.value, leftInfo.min);
            int max = Math.max(node.value, rightInfo.max);
            return new SubtreeInfo(size, min, max, true);
        }

        // If not a BST, return the size of the largest BST found so far
        return new SubtreeInfo(Math.max(leftInfo.size, rightInfo.size),
                0, 0, false);
    }
}
}
