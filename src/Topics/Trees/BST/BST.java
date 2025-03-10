package Topics.Trees.BST;

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

        } else{
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
}
