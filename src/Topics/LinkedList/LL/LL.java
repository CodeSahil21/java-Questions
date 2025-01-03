package Topics.LinkedList.LL;

public class LL {
   protected Node head;
    protected int size;
   public LL(){
       this.size = 0;
   }
   public void insertFirst(int val){
       Node node = new Node(val);
       node.next = head;
       head = node;
       size += 1;
   }
   public void insertLast(int val){
       Node node = new Node(val);
       if(head == null){
           insertFirst(val);
           return;
       }
       Node temp = head;
       while(temp.next != null ){
           temp = temp.next;
       }
       temp.next = node;
       size++;
   }
   public void insert(int val,int ind){
       if(ind == 0){
           insertFirst(val);
           return;
       }
       if(ind == size){
           insertLast(val);
           return;
       }
       Node temp = head;
       for (int i = 1 ;i < ind ; i++) {
           temp = temp.next;
       }
       Node node = new Node(val,temp.next);
       temp.next = node;
       size++;
   }
     public int deleteFirst(){
       if(head == null){
           throw new  IllegalStateException("List is Empty");
       }
       int val = head.value;
       head = head.next;
       size--;
       return val;
     }

     public int deleteLast(){
       if(size <= 1){
           deleteFirst();
       }
       Node secondLast = get(size-2);
       int val = secondLast.next.value;
       secondLast.next = null;
       size--;
       return val;
     }
     public int delete(int ind){
       if(ind == 0){
           deleteFirst();
       }
       if(ind == size-1){
           deleteLast();
       }
       Node prev = get(size-1);
       int val = prev.next.value;
       prev.next = prev.next.next;
       size--;
       return val;
     }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("End");
    }
    public Node findNodeByValue(int value) {
        Node node = head;
        while (node != null) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }



    protected class Node{
        protected int value;
        protected Node next;

       public Node(int value){
           this.value = value;
       }
       public Node(int value, Node next){
           this.value = value;
           this.next = next;
       }
   }
}
