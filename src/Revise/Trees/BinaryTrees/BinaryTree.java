package Revise.Trees.BinaryTrees;
import java.util.*;


public class BinaryTree {
    public class Node{
        int value;
        Node left;
        Node right;
        Node(int value){
            this.value = value;
        }
    }
    class Pair{
        Node node;
        int integer;
        Pair(Node node,int integer){
            this.node = node;
            this.integer = integer;
        }
    }
    private Node root;
    //insertion part
    public void populate(Scanner in){
        System.out.println("Enter the root node value");
        int value = in.nextInt();
        root= new Node(value);
        populate(in,root);
    }
    public void populate(Scanner in,Node node){
        System.out.println("Do you want to insert to the left of the "+ node.value);
        boolean left = in.nextBoolean();
        if(left){
            System.out.println("Enter the value to the left " + node.value);
            int value = in.nextInt();
            node.left = new Node(value);
            populate(in,node.left);
        }
        System.out.println("Do you want to insert to the right of the "+ node.value);
        boolean right = in.nextBoolean();
        if(right){
            System.out.println("Enter the value to the right " + node.value);
            int value = in.nextInt();
            node.right = new Node(value);
            populate(in,node.right);
        }
    }
  //traversals
  //preOrder :NLR
  public void preOrder(){
        preOrder(root);
  }
  public void preOrder(Node node){
       if(node == null){
           return;
       }
       System.out.print(node.value + " ");
       preOrder(node.left);
       preOrder(node.right);
  }
  //inOrder
  public void inOrder(){
        inOrder(root);
  }

  public void inOrder(Node node){
        if(node == null){
            return;
        }
        inOrder(node.left);
      System.out.print(node.value + "");
      inOrder(node.right);
  }
  //postOrder
    public void postOrder(){
        postOrder(root);
    }

    public void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + " " );
    }
  //level order traversal
    public List<List<Integer>> levelOrderTraversal(){
        List<List<Integer>> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Node>  q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            List<Integer> levels = new ArrayList<>(levelSize);
            for(int i = 0 ; i < levelSize; i++){
                Node currentNode = q.poll();
                levels.add(currentNode.value);
                if(currentNode.left != null){
                    q.add(currentNode.left);
                }
                if(currentNode.right != null){
                    q.add(currentNode.right);
                }
            }
            result.add(levels);
        }
        return result;
    }
  //iterative preorder traversal
    public List<Integer> iterative_PreOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
           Node currentNode =  st.pop();
           result.add(currentNode.value);
           if(currentNode.right != null){
               st.push(currentNode.right);
           }
           if(currentNode.left != null){
               st.push(currentNode.left);
           }
        }
        return result;
    }
  //Iterative InOrder traversal
  public List<Integer> iterative_InOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        if(root == null){
            return result;
        }
        Node current = root;
        while(current != null || !st.isEmpty()){
            while(current!= null){
                st.add(current);
                current = current.left;
            }
            current = st.pop();
            result.add(current.value);
            current = current.right;
        }
        return  result;
  }
  //Iterative Postorder traversal :2 stack
  public List<Integer> iterative_PostOrderTraversal(){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<Node> s1 = new Stack<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(root);
        while(!s1.isEmpty()){
            Node current = s1.pop();
            s2.add(current);
            if(current.left != null){
                s1.push(current.left);
            }
            if(current.right != null){
                s1.push(current.right);
            }
        }
        while(!s2.isEmpty()){
            result.add(s2.pop().value);
        }
        return result;
  }
  //iterative post order : 1stack
  public List<Integer> postOrderTraversalIterative2() {
      List<Integer> result = new ArrayList<>();
      if (root == null) return result;
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
                  result.add(temp.value);
                  //to check if it  has root value
                  while (!stack.isEmpty() && temp == stack.peek().right) {
                      temp = stack.pop();
                      result.add(temp.value);
                  }
              } else {
                  current = temp;
              }
          }
      }
      return result;
  }
  //maxDepth
  public int maxDepth(){
        if(root == null){
            return 0;
        }
      Queue<Node> q  = new LinkedList<>();
        int  levels = 0;
        q.offer(root);
        while(!q.isEmpty()){
            int levelSize = q.size();
            for(int i = 0  ; i < levelSize;i++){
                Node currentNode = q.poll();
                if(currentNode.left != null){
                    q.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    q.offer(currentNode.right);
                }
            }
            levels++;
        }
        return levels;
  }
 //height of binary tree
 public int height(){
       return height(root);
 }
 private int height(Node node){
       if(node == null){
           return 0;
       }
       int leftHeight = height(node.left);
       int rightHeight = height(node.right);

       return Math.max(leftHeight,rightHeight) + 1;
 }
 //check for balanced binary tree
  public boolean isBalanced(){
        return isBalanced(root) != -1;
  }
  private int isBalanced(Node  node){
        if(node == null){
            return 0;
        }
     int leftHeight =  isBalanced(node.left);
     int rightHeight = isBalanced(node.right);

     if(leftHeight == -1 ){
         return -1;
     }
     if(rightHeight == -1){
         return -1;
     }
     if(Math.abs(leftHeight - rightHeight) > 1){
         return -1;
     }
     return Math.max(leftHeight,rightHeight) + 1;

  }
  //diameter of binary tree
   public int diameter() {
       int[] diameter = new int[1];
       diameter(root, diameter);
       return diameter[0];
   }
   public int diameter(Node node,int[] diameter){
        if(node == null){
            return 0;
        }
        int leftHeight = diameter(node.left,diameter);
        int rightHeight = diameter(node.right,diameter);
        diameter[0] = Math.max(diameter[0],leftHeight+rightHeight);
        return Math.max(leftHeight,rightHeight)+1;
   }
   //maxPath
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
  //Identical
  public boolean isIdentical(BinaryTree t1, BinaryTree t2){
        return isIdentical(t1.root,t2.root);
  }
  private boolean isIdentical(Node node1 ,Node node2){
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1 == null || node2 == null){
            return false;
        }
        return (node1.value == node2.value && isIdentical(node1.left,node2.left)&& isIdentical(node1.right,node2.right));
  }
 //ZigZag Traversal
 public List<List<Integer>> zigZagTraversal(){
    List<List<Integer>> result = new ArrayList<>();
    if(root == null){
        return result;
    }
    boolean leftToRight  = true;
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    while (!q.isEmpty()){
        int levelSize = q.size();
        List<Integer> level = new ArrayList<>();
        for(int i = 0 ; i < levelSize;i++){
            Node current = q.poll();
            if(leftToRight){
                level.add(current.value);
            }else{
                level.add(0,current.value);
            }
            if(current.left!= null){
                q.offer(current.left);
            }
            if(current.right != null){
                q.offer(current.right);
            }
        }
        leftToRight = !leftToRight;
        result.add(level);
    }
    return result;
    }
   //Boundary order traversal
    public List<Integer>  boundaryTraversal(){
        List<Integer> result  = new ArrayList<>();
        if(root == null){
            return result;
        }
        result.add(root.value);
        leftBoundary(root,result);
        leaf(root,result);
        rightBoundary(root,result);
        return result;
    }
    public void leftBoundary(Node node , List<Integer> result){
        Node current = node.left;
        while(current != null){
            if(!isLeaf(current)){
                result.add(current.value);
            }
            if(current.left != null ){
                current = current.left;
            }else{
                current = current.right;
            }
        }
    }
    public void rightBoundary(Node node,List<Integer> result){
        Node current = node.right;
        List<Integer> temp = new ArrayList<>();
        while(current != null){
            if(!isLeaf(current)){
                temp.add(current.value);
            }
            if(current.right != null){
                current = current.right;
            }else{
                current = current.left;
            }
        }
        for(int i = temp.size() - 1; i >=0; i--){
            result.add(temp.get(i));
        }
    }
    public boolean isLeaf(Node node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }
    public void leaf(Node node,List<Integer> result){
        if(root == null){
            return;
        }
        if(isLeaf(node)){
            result.add(node.value);
            return;
        }
        leaf(node.left,result);
        leaf(node.right,result);
    }
    //top view and bottom view
    public static List<Integer> topView(Node root) {
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(root, 0));

        while (!queue.isEmpty()) {
            Pair1 p = queue.poll();
            Node node = p.node;
            int hd = p.hd;

            if (!hdMap.containsKey(hd)) {
                hdMap.put(hd, node.value);
            }

            if (node.left != null) queue.add(new Pair1(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair1(node.right, hd + 1));
        }

        return new ArrayList<>(hdMap.values());
    }

    public static List<Integer> bottomView(Node root) {
        Map<Integer, Integer> hdMap = new TreeMap<>();
        Queue<Pair1> queue = new LinkedList<>();
        queue.add(new Pair1(root, 0));

        while (!queue.isEmpty()) {
            Pair1 p = queue.poll();
            Node node = p.node;
            int hd = p.hd;

            // Overwrite every time to get the bottom-most node
            hdMap.put(hd, node.value);

            if (node.left != null) queue.add(new Pair1(node.left, hd - 1));
            if (node.right != null) queue.add(new Pair1(node.right, hd + 1));
        }

        return new ArrayList<>(hdMap.values());
    }

    static class Pair1 {
        Node node;
        int hd;
        Pair1(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
   //left view
   public List<Integer> leftView(){
        List<Integer> result = new ArrayList<>();
        if(root == null ){
            return result;
        }
        leftView(root,0,new int[]{-1},result);
        return result;
   }
   public void leftView(Node node,int level,int[] max,List<Integer> result){
        if(node == null){
            return;
        }
        if(level > max[0]){
            result.add(node.value);
            max[0] = level;
        }
        leftView(node.left,level+1,max,result);
        leftView(node.right,level+1,max,result);
   }
   //right view
   public List<Integer> rightView(){
       List<Integer> result = new ArrayList<>();
       if(root == null ){
           return result;
       }
       rightView(root,0,new int[]{-1},result);
       return result;
   }
    public void rightView(Node node,int level,int[] max,List<Integer> result){
        if(node == null){
            return;
        }
        if(level > max[0]){
            result.add(node.value);
            max[0] = level;
        }
        leftView(node.right,level+1,max,result);
        leftView(node.left,level+1,max,result);
    }
    //
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
    //top vie
         class Pair2<T, U> {
            private final T key;
            private final U value;

            public Pair2(T key, U value) {
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
            Queue<Pair2<Node, Integer>> q = new LinkedList<>();
            q.add(new Pair2<>(root, 0));

            while (!q.isEmpty()) {
                Pair2<Node, Integer> pair = q.poll();
                Node node = pair.getKey();
                int line = pair.getValue();

                if (!mpp.containsKey(line)) {
                    mpp.put(line, node.value);
                }

                if (node.left != null) {
                    q.add(new Pair2<>(node.left, line - 1));
                }

                if (node.right != null) {
                    q.add(new Pair2<>(node.right, line + 1));
                }
            }

            for (int value : mpp.values()) {
                ans.add(value);
            }
            return ans;
        }
  //bottom view of binary tree
   public List<Integer>  bottomView(){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<Pair2<Node,Integer>>  q = new LinkedList<>();
        Map<Integer,Integer> mp = new HashMap<>();
        q.add(new Pair2<>(root,0));
        while(!q.isEmpty()){
            Pair2<Node,Integer>  current = q.poll();
            Node node = current.getKey();
            int line = current.getValue();
            mp.put(line,node.value);
            if(node.left != null){
                q.add(new Pair2<>(node.left,line-1));
            }
            if(node.right != null){
                q.add(new Pair2<>(node.left ,line+1));
            }
        }
        for(Map.Entry<Integer,Integer>  entry: mp.entrySet()){
            result.add(entry.getValue());
        }
        return result;
   }
 //check for symmetry
    public boolean isSymmetric(){
        if(root == null){
            return true;
        }
        return isSymmetric(root.left,root.right);
    }
    private boolean isSymmetric(Node root1,Node root2){
        if(root1 == null || root2 == null){
            return root1 == root2;
        }
        return (root1.value == root2.value)
                && isSymmetric(root1.left, root2.right)
                && isSymmetric(root1.right, root2.left);
        }
    //get path
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
    //LCA
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
    //maxwidth of binary tree
    public int maxwidth(){
        if(root == null){
            return 0;
        }
        int ans = 0;
        Queue<Pair2<Node,Integer>> q = new LinkedList<>();
        q.add(new Pair2<>(root,0));
        while(!q.isEmpty()){
            int size = q.size();
            int Mmin = q.peek().getValue();
            int first = 0;
            int last = 0;
            for(int  i =0 ;i < size ;i++){
                int curr_id = q.peek().getValue()-Mmin;
                Node node =q.peek().getKey();
                q.poll();
                if(i == 0){
                    first = curr_id;
                }
                if(i == size-1){
                    last = curr_id;
                }
                if(node.left != null){
                    q.add(new Pair2<>(node.left,curr_id*2+1));
                }
                if(node.right != null){
                    q.add(new Pair2<>(node.right,curr_id*2+2));
                }
            }
            ans =  Math.max(ans,last-first+1);
        }
        return ans;
    }
   //children  sum property
    public void changeTree(){
        changeTree(root);
    }
    private void changeTree(Node node){
        if(root == null){
            return ;
        }
        int child = 0;
        if(root.left != null){
            child += root.left.value;
        }
        if(root.right != null){
            child += root.right.value;
        }
        if(child >= root.value){
            root.value = child;
        }else{
            if(root.left != null){
                root.left.value = child;
            }
            if(root.right != null){
                root.right.value = child;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if(root.left != null){
            tot += root.left.value;
        }
        if(root.right != null){
           tot += root.right.value;
        }
        if(root.left != null || root.right != null){
            root.value = tot;
        }
    }
    //print nodes at the k distance
    public List<Integer> distanceAtK(Node root,Node target,int k){
        Map<Node,Node> parent_Track = new HashMap<>();
        markParentBfs(root,parent_Track);

        Map<Node ,Boolean> visited = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(target);
        visited.put(target,true);
        int current_level = 0;
        while(!q.isEmpty()){
            if(current_level == k){
                break;
            }
            current_level++;
            int size = q.size();
            for(int i =0; i < size;i++){
                Node current = q.poll();
                if(current.left != null && !visited.containsKey(current.left)){
                    q.offer(current.left);
                    visited.put(current.left ,true);
                }
                if(current.right != null && !visited.containsKey(current.right)){
                    q.offer(current.right);
                    visited.put(current.right ,true);
                }
                if(parent_Track.get(current) != null && !visited.containsKey(parent_Track.get(current))){
                    q.offer(parent_Track.get(current));
                    visited.put(parent_Track.get(current),true);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()){
            res.add(q.poll().value);
        }
        return res;
    }
    public void markParentBfs(Node root,Map<Node,Node> parent_Track){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node current = q.poll();
            for (int i = 0; i < size; i++) {
                if(current.left != null){
                    q.add(current.left);
                    parent_Track.put(current.left,current);
                }
                if(current.right != null){
                    q.add(current.right);
                    parent_Track.put(current.right,current);
                }
            }
        }
    }
    //minimum time to burn tree
    private void markParentBfs1(Node root,Map<Node,Node> parent_Track){
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node current = q.poll();
            for (int i = 0; i < size; i++) {
                if(current.left != null){
                    q.add(current.left);
                    parent_Track.put(current.left,current);
                }
                if(current.right != null){
                    q.add(current.right);
                    parent_Track.put(current.right,current);
                }
            }
        }
    }
    public int timetoBurnTree(int startValue){
        HashMap<Node ,Node> parent_track = new HashMap<>();
        markParentBfs1(root,parent_track);
        Node targetNode = findNode(root,startValue);
        if (targetNode == null) {
            return -1; // Target node not found
        }
        return maxDistance(parent_track,targetNode);
    }
    private Node findNode(Node node,int target){
        if(node == null){
            return null;
        }
        if(node.value == target){
            return node;
        }
        findNode(node.left, target);
        if(node.left != null){
            return node.left;
        }
        return findNode(node.right,target);
    }

    public int maxDistance(Map<Node,Node> parent_Track, Node target){
        Queue<Node> q = new LinkedList<>();
        Map<Node, Boolean> vis = new HashMap<>();
        q.offer(target);
        vis.put(target,true);
        int maxDistance = 0;
        while(!q.isEmpty()){
            int size = q.size();
            boolean flag = false;
            for(int i = 0; i < size;i++){
                Node current = q.poll();
                if(current.left != null && !vis.containsKey(current.left)){
                    vis.put(current.left,true);
                    q.add(current.left);
                    flag = true;
                }
                if(current.right != null && !vis.containsKey(current.right)){
                    vis.put(current.right,true);
                    q.add(current.right);
                    flag = true;
                }
                if(parent_Track.get(current) != null && !vis.containsKey(parent_Track.get(current))){
                    q.add(parent_Track.get(current));
                    vis.put(parent_Track.get(current),true);
                    flag = true;
                }
            }
            if(flag){
                maxDistance++;
            }
        }
        return  maxDistance;
    }
    //count nodes
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
    //inorder and preOrder
    public Node buildTree(int[] inOrder,int[] preOrder){
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i = 0; i < inOrder.length;i++  ){
            inMap.put(inOrder[i],i);
        }

        return buildTree(preOrder, 0,preOrder.length-1,inOrder,0,inOrder.length-1,inMap);
    }
    private Node buildTree(int[] preOrder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd,Map<Integer,Integer> inMap){
        if(preStart > preEnd  ||  inStart > inEnd){
            return null;
        }
        Node root = new Node(preOrder[preStart]);
        int inRoot =  inMap.get(inOrder[inStart]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree(preOrder,preStart + 1, preStart + numsLeft,inOrder,inStart,inRoot -1,inMap);
        root.right = buildTree(preOrder,preStart +numsLeft+1,preEnd,inOrder,inRoot+1,inEnd,inMap);
        return root;
    }
    //postOrder inOrder;
    public Node buildTree2(int[] inOrder,int[] postOrder){
        Map<Integer,Integer> inMap = new HashMap<>();
        for (int i = 0; i < inOrder.length; i++) {
            inMap.put(inOrder[i],i);
        }
        return buildTree2(inOrder,0,inOrder.length-1,postOrder,0,postOrder.length-1,inMap);
    }
    private Node buildTree2(int[] inOrder,int inStart,int inEnd,int[] postOrder,int postStart,int postEnd,Map<Integer,Integer> inMap){
        if(postStart > postEnd  ||  inStart > inEnd){
            return null;
        }
        Node root = new Node(postOrder[postEnd]);
        int inRoot =  inMap.get(inOrder[inStart]);
        int numsLeft = inRoot - inStart;

        root.left = buildTree2(inOrder,inStart, inRoot-1,postOrder,postStart,postStart + numsLeft-1,inMap);
        root.right = buildTree2(inOrder,inRoot+1,inEnd,postOrder,postStart+numsLeft,postEnd-1,inMap);
        return root;
    }
    //serialize
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
    //
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

