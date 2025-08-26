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
}
