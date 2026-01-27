package Topics.LinkedList;

import Topics.LinkedList.LL.LL;

public class LL1 {
    private Node head;
    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
    public Node rotata( int k) {
       if (head == null || k == 0){
           return head;
       }
       Node tail = head;
       int len = 1;
       while(tail.next != null){
           len +=1;
           tail = tail.next;
       }
       if(k % len== 0){
           return head;
       }
       k = k % len;
       Node ktNode = findNthNode(head,len-k);
       tail.next = head;
       head = ktNode.next;
       ktNode.next = null;
       return head;
    }
    public Node findNthNode(Node temp, int n){
        int cnt =1;
        while(temp != null){
            if(cnt == n){
                return temp;
            }
            cnt++;
            temp = temp.next;
        }
        return temp;
    }
    public Node getKthNode(Node temp,int k){
        k -= 1;
        while(k > 0 && temp != null){
            k--;
            temp = temp.next;
        }
        return temp;
    }
    public Node reverseLinkedList(Node head) {
        Node temp = head;
        Node prev = null;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }
    public Node mergeTwoSortedLists(Node l1, Node l2) {
        Node dummyHead = new Node(-1);
       Node temp1 = l1;
       Node temp2 = l2;
       Node current = dummyHead;
       while(temp1 != null && temp2 != null){
           if(temp1.value <= temp2.value){
               current.next = temp1;
               temp1 = temp1.next;
           }else{
               current.next = temp2;
               temp2 = temp2.next;
           }
           current = current.next;
       }
       if(temp1 != null){
           current.next = temp1;
       }else{
           current.next = temp2;
       }
       head = dummyHead.next;
       return head;
    }
}