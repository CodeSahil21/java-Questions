package Topics.LinkedList.DLL;
import java.util.*;
public class DLL {
    protected Node head;

    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        Node last = head;
        node.next = null;
        if (head == null) {
            node.prev = null;
            head = node;
            return;
        }
        while (last.next != null) {
            last = last.next;
        }
        last.next = node;
        node.prev = last;
    }

    public Node find(int val) {
        Node node = head;
        while (node != null) {
            if (node.value == val) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val) {
        Node p = find(after);
        if (p == null) {
            System.out.println("does not exist");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if (node.next != null) {
            node.next.prev = node;
        }
    }

    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int val = head.value;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        return val;
    }

    public int deleteLast() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            return deleteFirst();
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        int val = last.value;
        last.prev.next = null;
        return val;
    }

    public int delete(int val) {
        Node node = find(val);
        if (node == null) {
            throw new IllegalStateException("Value not found in the list");
        }
        if (node == head) {
            return deleteFirst();
        }
        if (node.next == null) {
            return deleteLast();
        }
        int value = node.value;
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return value;
    }

    public void display() {
        Node temp = head;
        Node last = null;
        while (temp != null) {
            System.out.print(temp.value + "->");
            last = temp;
            temp = temp.next;
        }
        System.out.println("END");
        System.out.println("Print in reverse");
        while (last != null) {
            System.out.print(last.value + "<-");
            last = last.prev;
        }
        System.out.println("END");
    }
//https://www.geeksforgeeks.org/problems/delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=delete-all-occurrences-of-a-given-key-in-a-doubly-linked-list
    public Node deleteAllOccurences(int key){
        Node temp =head;
        while(temp != null){
            if(temp.value == key) {
              if(temp ==  head){
                  head = head.next;
                  if(head != null){
                      head.prev = null;
                  }
                  temp = head;
              }else {
                  Node nextNode = temp.next;
                  Node prevNode = temp.prev;
                  if (nextNode != null) {
                      nextNode.prev = prevNode;
                  }
                  if (prevNode != null) {
                      prevNode.next = nextNode;
                  }
                  temp = nextNode;
              }
            }else{
                temp = temp.next;
            }
        }
        return head;
    }
    //https://www.geeksforgeeks.org/problems/find-pairs-with-given-sum-in-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-pairs-with-given-sum-in-doubly-linked-list
    public Node findTail(Node head) {
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        return tail;
    }

    public List<List<Integer>> findPairs(Node head, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (head == null) return ans;

        Node left = head;
        Node right = findTail(head);

        while (left.value < right.value) {
            if (left.value + right.value == k) {
                List<Integer> pair = new ArrayList<>();
                pair.add(left.value);
                pair.add(right.value);
                ans.add(pair);
                left = left.next;
                right = right.prev;
            } else if (left.value + right.value < k) {
                left = left.next;
            } else {
                right = right.prev;
            }
        }
        return ans;
    }
//https://www.geeksforgeeks.org/problems/remove-duplicates-from-a-sorted-doubly-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=remove-duplicates-from-a-sorted-doubly-linked-list
    public Node  removeDuplicates(){
        Node temp = head;
        while(temp != null && temp.next != null){
            Node nextNode  = temp.next;
            while (nextNode != null && nextNode.value == temp.value){
                nextNode = nextNode.next;
            }
            temp.next = nextNode;
            if(nextNode != null){
                nextNode.prev = temp;
            }
            temp = temp.next;
        }
        return  head;
    }


    protected class Node {
        protected int value;
        protected Node next;
        protected Node prev;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
