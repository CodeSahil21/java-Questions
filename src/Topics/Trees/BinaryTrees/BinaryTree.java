package Topics.Trees.BinaryTrees;

import java.util.*;

public class BinaryTree {
    public BinaryTree() {
    }

    private static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node root;

    // Insert elements
    public void populate(Scanner scanner) {
        System.out.println("Enter the root Node:");
        int value = scanner.nextInt();
        root = new Node(value);
        populate(scanner, root);
    }

    private void populate(Scanner scanner, Node node) {
        System.out.println("Do you want to enter left of " + node.value);
        boolean left = scanner.nextBoolean();
        if (left) {
            System.out.println("Enter the value of the left of " + node.value);
            int value = scanner.nextInt();
            node.left = new Node(value);
            populate(scanner, node.left);
        }
        System.out.println("Do you want to enter right of " + node.value);
        boolean right = scanner.nextBoolean();
        if (right) {
            System.out.println("Enter the value of the right of " + node.value);
            int value = scanner.nextInt();
            node.right = new Node(value);
            populate(scanner, node.right);
        }
    }

    public void display() {
        display(root, "");
    }

    private void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.value);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t ");
    }

    public void niceDisplay() {
        niceDisplay(root, 0);
    }

    private void niceDisplay(Node node, int level) {
        if (node == null) {
            return;
        }

        niceDisplay(node.right, level + 1);

        if (level != 0) {
            for (int i = 0; i < level - 1; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->" + node.value);
        } else {
            System.out.println(node.value);
        }
        niceDisplay(node.left, level + 1);
    }

    public void preOrder(Node node) {
        preOrderTraversal(node);
    }

    private void preOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public void inOrder(Node node) {
        inOrderTraversal(node);
    }

    private void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.println(node.value + " ");
        inOrderTraversal(node.right);
    }

    public void postOrder(Node node) {
        postOrderTraversal(node);
    }

    private void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.println(node.value + " ");
    }

    public List<List<Integer>> levelOrder() {
        return levelOrderTraversal(root);
    }

    private List<List<Integer>> levelOrderTraversal(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>(levelSize);
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                currentLevel.add(currentNode.value);
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

    public List<Integer> preorderTraversal() {
        return preorderTraversal(root);
    }

    private List<Integer> preorderTraversal(Node root) {
        List<Integer> preorder = new ArrayList<>();
        if (root == null) {
            return preorder;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while (!st.empty()) {
            root = st.pop();
            preorder.add(root.value);
            if (root.right != null) {
                st.push(root.right);
            }
            if (root.left != null) {
                st.push(root.left);
            }
        }
        return preorder;
    }

    public List<Integer> inOrderTraversalIterative() {
        return inOrderTraversalIterative(root);
    }

    private List<Integer> inOrderTraversalIterative(Node root) {
        List<Integer> arr = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            arr.add(current.value);
            current = current.right;
        }
        return arr;
    }

    public List<Integer> postOrderTraversalIterative() {
        return postOrderTraversalIterative(root);
    }

    private List<Integer> postOrderTraversalIterative(Node root) {
        List<Integer> postorder = new ArrayList<>();
        if (root == null) {
            return postorder;
        }
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        st1.push(root);
        while (!st1.empty()) {
            root = st1.pop();
            st2.push(root);
            if (root.left != null) {
                st1.push(root.left);
            }
            if (root.right != null) {
                st1.push(root.right);
            }
        }
        while (!st2.empty()) {
            postorder.add(st2.pop().value);
        }
        return postorder;
    }

    public void postOrderTraversalIterative2() {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalIterative2(root, list);
        System.out.println(list);
    }

    private void postOrderTraversalIterative2(Node root, List<Integer> post) {
        if (root == null) return;
        Stack<Node> stack = new Stack<>();
        Node current = root;
        Node temp;
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                stack.push(current);
                current = current.left;
            } else {
                temp = stack.peek().right;
                if (temp == null) {
                    temp = stack.pop();
                    post.add(temp.value);
                    while (!stack.isEmpty() && temp == stack.peek().right) {
                        temp = stack.pop();
                        post.add(temp.value);
                    }
                } else {
                    current = temp;
                }
            }
        }
    }
//    public List<List<Integer>> preInPostTraversal() {
//        return preInPostTraversal(root);
//    }
//
//    private List<List<Integer>> preInPostTraversal(Node root) {
//        List<Integer> pre = new ArrayList<>();
//        List<Integer> in = new ArrayList<>();
//        List<Integer> post = new ArrayList<>();
//
//        if (root == null) {
//            return new ArrayList<>();
//        }
//
//        Stack<Pair<Node, Integer>> st = new Stack<>();
//        st.push(new Pair<>(root, 1));
//
//        while (!st.empty()) {
//            Pair<Node, Integer> it = st.pop();
//
//            if (it.getValue() == 1) {
//                pre.add(it.getKey().value);
//                it.setValue(2);
//                st.push(it);
//                if (it.getKey().left != null) {
//                    st.push(new Pair<>(it.getKey().left, 1));
//                }
//            } else if (it.getValue() == 2) {
//                in.add(it.getKey().value);
//                it.setValue(3);
//                st.push(it);
//                if (it.getKey().right != null) {
//                    st.push(new Pair<>(it.getKey().right, 1));
//                }
//            } else {
//                post.add(it.getKey().value);
//            }
//        }
//
//        List<List<Integer>> result = new ArrayList<>();
//        result.add(pre);
//        result.add(in);
//        result.add(post);
//        return result;
//    }

    //medium section
    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    private int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        Queue<Node> queue = new LinkedList<>();
        int level = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            level++;
        }
        return level;
    }

    public int maxDepth() {
        return maxDepth(root);
    }

    //https://leetcode.com/problems/boundary-of-binary-tree/description/
    // Boundary order traversal
    public List<Integer> boundaryOrderTraversal() {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        if (!isLeaf(root)) {
            result.add(root.value);
        }
        leftBoundary(root, result);
        leafNodes(root, result);
        rightBoundary(root, result);
        return result;
    }

    private void leftBoundary(Node node, List<Integer> result) {
        Node current = node.left;
        while (current != null) {
            if (!isLeaf(current)) {
                result.add(current.value);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
    }

    private void rightBoundary(Node node, List<Integer> result) {
        Node current = node.right;
        List<Integer> temp = new ArrayList<>();
        while (current != null) {
            if (!isLeaf(current)) {
                temp.add(current.value);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }
        for (int i = temp.size() - 1; i >= 0; i--) {
            result.add(temp.get(i));
        }
    }

    private void leafNodes(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            result.add(node.value);
            return;
        }
        leafNodes(node.left, result);
        leafNodes(node.right, result);
    }

    private boolean isLeaf(Node node) {
        return node.left == null && node.right == null;
    }

    public List<Integer> leftView() {
        List<Integer> result = new ArrayList<>();
        leftView(root, 0, new int[]{-1}, result);
        return result;
    }

    private void leftView(Node node, int level, int[] maxLevel, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (level > maxLevel[0]) {
            result.add(node.value);
            maxLevel[0] = level;
        }
        leftView(node.left, level + 1, maxLevel, result);
        leftView(node.right, level + 1, maxLevel, result);
    }

    //https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightView() {
        List<Integer> result = new ArrayList<>();
        rightView(root, 0, new int[]{-1}, result);
        return result;
    }

    private void rightView(Node node, int level, int[] maxLevel, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (level > maxLevel[0]) {
            result.add(node.value);
            maxLevel[0] = level;
        }
        rightView(node.right, level + 1, maxLevel, result);
        rightView(node.left, level + 1, maxLevel, result);
    }

    //height of the tree recursively
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;  // Return -1 for an empty tree
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    //https://leetcode.com/problems/balanced-binary-tree/description/
    public boolean isBalanced() {
        return isBalanced(root) != -1;
    }

    private int isBalanced(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = isBalanced(node.left);
        int rightHeight = isBalanced(node.right);

        if (leftHeight == -1) {
            return -1;
        }
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //https://leetcode.com/problems/diameter-of-binary-tree/description/
    public int diameterOfBinaryTree() {
        int[] diameter = new int[1];
        diameter[0] = 0;
        height(root, diameter);
        return diameter[0];
    }

    // Function to calculate the height of the tree and update the diameter
    private int height(Node node, int[] diameter) {
        if (node == null) {
            return 0;
        }
        int leftHeight = height(node.left, diameter);
        int rightHeight = height(node.right, diameter);
        diameter[0] = Math.max(diameter[0], leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
    // Function to find the maximum path sum for the entire binary tree
    public int maxPathSum() {
        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0];
    }

    // Function to calculate the maximum path sum for each node
    private int findMaxPathSum(Node node, int[] maxi) {
        if (node == null) {
            return 0;
        }
        int leftMaxPath = Math.max(0, findMaxPathSum(node.left, maxi));
        int rightMaxPath = Math.max(0, findMaxPathSum(node.right, maxi));
        maxi[0] = Math.max(maxi[0], leftMaxPath + rightMaxPath + node.value);
        return Math.max(leftMaxPath, rightMaxPath) + node.value;
    }

    //https://leetcode.com/problems/same-tree/description/
    private boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        return (node1.value == node2.value
                && isIdentical(node1.left, node2.left)
                && isIdentical(node1.right, node2.right));
    }

    // Public method to compare two binary trees
    public boolean isIdentical(BinaryTree tree1, BinaryTree tree2) {
        return isIdentical(tree1.root, tree2.root);
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
// Function to perform ZigZag level order traversal
    public List<List<Integer>> zigzagLevelOrder() {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<Node> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean leftToRight = true;

        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            List<Integer> row = new LinkedList<>(); // Change to LinkedList

            for (int i = 0; i < size; i++) {
                Node node = nodesQueue.poll();
                if (leftToRight) {
                    row.add(node.value); // Add at the end
                } else {
                    row.add(0, node.value); // Add at the beginning
                }

                if (node.left != null) {
                    nodesQueue.add(node.left);
                }
                if (node.right != null) {
                    nodesQueue.add(node.right);
                }
            }

            leftToRight = !leftToRight;
            result.add(new ArrayList<>(row));
        }

        return result;
    }

    //https://leetcode.com/problems/symmetric-tree/description/
    private boolean isSymmetricUtil(Node root1, Node root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }

        return (root1.value == root2.value)
                && isSymmetricUtil(root1.left, root2.right)
                && isSymmetricUtil(root1.right, root2.left);
    }

    public boolean isSymmetric() {
        if (root == null) {
            return true;
        }
        return isSymmetricUtil(root.left, root.right);
    }

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
    class Tuple {
        Node node;
        int row;
        int col;

        public Tuple(Node _node, int _row, int _col) {
            node = _node;
            row = _row;
            col = _col;
        }
    }

    public List<List<Integer>> findVertical() {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            Tuple tuple = q.poll();
            Node node = tuple.node;
            int x = tuple.row;
            int y = tuple.col;

            if (!map.containsKey(x)) {
                map.put(x, new TreeMap<>());
            }
            if (!map.get(x).containsKey(y)) {
                map.get(x).put(y, new PriorityQueue<>());
            }
            map.get(x).get(y).offer(node.value);

            if (node.left != null) {
                q.offer(new Tuple(node.left, x - 1, y + 1));
            }
            if (node.right != null) {
                q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }

    //https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    class Pair<T, U> {
        private final T key;
        private final U value;

        public Pair(T key, U value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public U getValue() {
            return value;
        }
    }

    public List<Integer> topView() {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            if (!mpp.containsKey(line)) {
                mpp.put(line, node.value);
            }

            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for (int value : mpp.values()) {
            ans.add(value);
        }
        return ans;
    }

    //https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1
    public List<Integer> bottomView() {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> mpp = new TreeMap<>();
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            Pair<Node, Integer> pair = q.poll();
            Node node = pair.getKey();
            int line = pair.getValue();

            mpp.put(line, node.value);

            if (node.left != null) {
                q.add(new Pair<>(node.left, line - 1));
            }

            if (node.right != null) {
                q.add(new Pair<>(node.right, line + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : mpp.entrySet()) {
            ans.add(entry.getValue());
        }
        return ans;
    }

    //https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=root-to-leaf-paths
    public boolean getPath(Node root, List<Integer> arr, int x) {
        if (root == null) {
            return false;
        }
        arr.add(root.value);
        if (root.value == x) {
            return true;
        }
        if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
            return true;
        }
        arr.remove(arr.size() - 1);
        return false;
    }

    public List<Integer> solve(int B) {
        List<Integer> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }
        getPath(root, arr, B);
        return arr;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
    public int findLCAValue(Node p, Node q) {
        Node lcaNode = findLCA(root, p, q);
        return lcaNode != null ? lcaNode.value : -1; // Return -1 if LCA is null
    }

    private Node findLCA(Node root, Node p, Node q) {
        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursive search in left and right subtrees
        Node left = findLCA(root.left, p, q);
        Node right = findLCA(root.right, p, q);

        // If both left and right are not null, we found the LCA
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    //https://leetcode.com/problems/maximum-width-of-binary-tree/description/
    public int widthOfBinaryTree() {
        if (root == null) {
            return 0;
        }

        int ans = 0;
        Queue<Pair<Node, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            int mmin = q.peek().getValue();

            int first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                int cur_id = q.peek().getValue() - mmin;
                Node node = q.peek().getKey();
                q.poll();

                if (i == 0) {
                    first = cur_id;
                }

                if (i == size - 1) {
                    last = cur_id;
                }

                if (node.left != null) {
                    q.add(new Pair<>(node.left, cur_id * 2 + 1));
                }

                if (node.right != null) {
                    q.add(new Pair<>(node.right, cur_id * 2 + 2));
                }
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }

    //https://www.geeksforgeeks.org/problems/children-sum-parent/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=hildren-sum-parent
    private void changeTree(Node node) {
        if (root == null) {
            return;
        }

        int child = 0;
        if (root.left != null) {
            child += root.left.value;
        }
        if (root.right != null) {
            child += root.right.value;
        }

        if (child >= root.value) {
            root.value = child;
        } else {
            if (root.left != null) {
                root.left.value = root.value;
            } else if (root.right != null) {
                root.right.value = root.value;
            }
        }

        changeTree(root.left);
        changeTree(root.right);

        int tot = 0;
        if (root.left != null) {
            tot += root.left.value;
        }
        if (root.right != null) {
            tot += root.right.value;
        }

        if (root.left != null || root.right != null) {
            root.value = tot;
        }
    }

    public void changeTree() {
        changeTree(root);
    }

    //https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/description/
    private void markParents(Node node, Map<Node, Node> parent_track) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parent_track.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parent_track.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    public List<Integer> distanceK(Node root, Node target, int k) {
        Map<Node, Node> parent_track = new HashMap<>();
        markParents(root, parent_track);

        Map<Node, Boolean> visited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        visited.put(target, true);
        int current_level = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            if (current_level == k) break;
            current_level++;
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && !visited.containsKey(current.left)) {
                    queue.offer(current.left);
                    visited.put(current.left, true);
                }
                if (current.right != null && !visited.containsKey(current.right)) {
                    queue.offer(current.right);
                    visited.put(current.right, true);
                }
                if (parent_track.get(current) != null && !visited.containsKey(parent_track.get(current))) {
                    queue.offer(parent_track.get(current));
                    visited.put(parent_track.get(current), true);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().value);
        }
        return result;
    }

    //https://www.geeksforgeeks.org/problems/burning-tree/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=burning-tree
    private void bfsToMapParents(Node root, HashMap<Node, Node> parentMap, int target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        parentMap.put(root, null);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.offer(current.left);
            }
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.offer(current.right);
            }
        }
    }

    // Method to calculate time to burn the binary tree
    public int timeToBurnTree(int startValue) {
        HashMap<Node, Node> parentMap = new HashMap<>();
        bfsToMapParents(root, parentMap, startValue);

        Node targetNode = findNode(root, startValue);
        if (targetNode == null) {
            return -1; // Target node not found
        }

        return findMaxDistance(parentMap, targetNode);
    }

    // Helper method to find a node by value
    private Node findNode(Node node, int value) {
        if (node == null) {
            return null;
        }
        if (node.value == value) {
            return node;
        }
        Node left = findNode(node.left, value);
        if (left != null) {
            return left;
        }
        return findNode(node.right, value);
    }

    // Method to find the maximum distance (time to burn the tree)
    private int findMaxDistance(HashMap<Node, Node> parentMap, Node target) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(target);
        HashMap<Node, Boolean> visited = new HashMap<>();
        visited.put(target, true);
        int maxDistance = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean flag = false;

            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                if (current.left != null && !visited.containsKey(current.left)) {
                    flag = true;
                    visited.put(current.left, true);
                    queue.offer(current.left);
                }
                if (current.right != null && !visited.containsKey(current.right)) {
                    flag = true;
                    visited.put(current.right, true);
                    queue.offer(current.right);
                }
                if (parentMap.get(current) != null && !visited.containsKey(parentMap.get(current))) {
                    flag = true;
                    visited.put(parentMap.get(current), true);
                    queue.offer(parentMap.get(current));
                }
            }
            if (flag) {
                maxDistance++;
            }
        }
        return maxDistance;
    }

    //https://leetcode.com/problems/count-complete-tree-nodes/
    // Count total nodes in the tree
    public int countNodes() {
        return countNodes(root);
    }

    private int countNodes(Node root) {
        // Check if the tree is empty
        if (root == null) {
            return 0;
        }

        // Find the height of the left subtree
        int lh = findHeightLeft(root);
        // Find the height of the right subtree
        int rh = findHeightRight(root);

        // If the heights are equal, the tree is a full binary tree
        if (lh == rh) {
            return (1 << lh) - 1;
        }

        // Otherwise, recursively count nodes in left and right subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    // Function to find the height of the left subtree
    private int findHeightLeft(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    // Function to find the height of the right subtree
    private int findHeightRight(Node node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    //https://www.geeksforgeeks.org/problems/unique-binary-tree-requirements/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=unique-binary-tree-requirements
    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
// Build tree from preorder and inorder traversals
    public Node buildTree(int[] preorder, int[] inorder) {
        // Create a map to store indices of elements in the inorder traversal
        Map<Integer, Integer> inMap = new HashMap<>();

        // Populate the map with indices of elements in the inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }

        // Call the private helper function to recursively build the tree
        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inMap);
    }

    private Node buildTree(int[] preorder, int preStart, int preEnd,
                           int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inMap) {
        // Base case: If the start indices exceed the end indices, return null
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }

        // Create a new Node with the value at the current preorder index
        Node root = new Node(preorder[preStart]);

        // Find the index of the current root value in the inorder traversal
        int inRoot = inMap.get(root.value);

        // Calculate the number of elements in the left subtree
        int numsLeft = inRoot - inStart;

        // Recursively build the left subtree
        root.left = buildTree(preorder, preStart + 1, preStart + numsLeft,
                inorder, inStart, inRoot - 1, inMap);

        // Recursively build the right subtree
        root.right = buildTree(preorder, preStart + numsLeft + 1, preEnd,
                inorder, inRoot + 1, inEnd, inMap);

        // Return the current root node
        return root;
    }

    //https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
    public Node buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length != postorder.length) {
            return null;
        }

        // Create a map to store the indices of elements in the inorder traversal
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }

        // Call the recursive function to build the binary tree
        return buildTreePostIn(inorder, 0, inorder.length - 1, postorder, 0,
                postorder.length - 1, hm);
    }

    private Node buildTreePostIn(int[] inorder, int is, int ie,
                                 int[] postorder, int ps, int pe, Map<Integer, Integer> hm) {

        // Base case: If the subtree is empty, return null
        if (ps > pe || is > ie) {
            return null;
        }

        // Create a new Node with the root value from postorder
        Node root = new Node(postorder[pe]);

        // Find the index of the root value in inorder traversal
        int inRoot = hm.get(postorder[pe]);

        // Number of nodes in the left subtree
        int numsLeft = inRoot - is;

        // Recursively build the left subtree
        root.left = buildTreePostIn(inorder, is, inRoot - 1, postorder,
                ps, ps + numsLeft - 1, hm);

        // Recursively build the right subtree
        root.right = buildTreePostIn(inorder, inRoot + 1, ie, postorder,
                ps + numsLeft, pe - 1, hm);

        // Return the root of the constructed subtree
        return root;
    }

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
    public String serialize(Node root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            Node curNode = q.poll();

            if (curNode == null) {
                sb.append("#,");
            } else {
                sb.append(curNode.value).append(",");
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }

        return sb.toString();
    }

    // Deserialize the binary tree
    public Node deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split(",");
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        for (int i = 1; i < values.length; i++) {
            Node node = q.poll();

            if (!values[i].equals("#")) {
                Node leftNode = new Node(Integer.parseInt(values[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;
            if (i < values.length && !values[i].equals("#")) {
                Node rightNode = new Node(Integer.parseInt(values[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }

        return root;
    }

    //moris preorder and inorder traversal
    // Preorder traversal (Morris traversal)
    public List<Integer> getPreorder(Node root) {
        List<Integer> preorder = new ArrayList<>();
        Node cur = root;

        while (cur != null) {
            if (cur.left == null) {
                preorder.add(cur.value);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    preorder.add(cur.value);
                    cur = cur.left;
                } else {
                    prev.right = null;
                    cur = cur.right;
                }
            }
        }

        return preorder;
    }

    // Inorder traversal (Morris traversal)
    public List<Integer> getInorder(Node root) {
        List<Integer> inorder = new ArrayList<>();
        Node cur = root;

        while (cur != null) {
            if (cur.left == null) {
                inorder.add(cur.value);
                cur = cur.right;
            } else {
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    prev.right = null;
                    inorder.add(cur.value);
                    cur = cur.right;
                }
            }
        }

        return inorder;
    }
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/description/
    // Flatten the binary tree into a linked list
    public void flatten(Node root) {
        Node curr = root;

        while (curr != null) {
            if (curr.left != null) {
                Node pre = curr.left;
                while (pre.right != null) {
                    pre = pre.right;
                }

                pre.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;

        }
    }
}