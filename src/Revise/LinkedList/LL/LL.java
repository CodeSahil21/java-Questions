package Revise.LinkedList.LL;

public class LL {
   private  Node head;
   public LL(){}

    public void insertFirst(int value){
       Node newNode = new Node(value);
       newNode.next = head;
       head = newNode;
    }

    public void insertLast(int value){
       Node newNode =  new Node(value);
       if(head == null){
           head = newNode;
       }
       Node temp = head;
       while(temp.next != null){
           temp = temp.next;
       }
       temp.next = newNode;
    }

    public void insertAfter(int newValue, int targetValue) {
       // Find the node we want to insert after
        Node targetNode = head;
        while (targetNode != null && targetNode.value != targetValue) {
                targetNode = targetNode.next;
            }

            // If targetNode is null, the value was not found in the list.
            if (targetNode == null) {
                System.out.println("Node with value " + targetValue + " not found. Cannot insert.");
                return; // Exit the method
            }

            // If the target node was found, insert the new node after it
            Node newNode = new Node(newValue,targetNode.next);
            targetNode.next = newNode;
        }

  public void deleteFirst(){
       if(head == null){
           throw new IllegalStateException("List is empty");
       }
       head = head.next;
       return;
  }

  public void deleteLast(){
       if(head == null || head.next == null){
           deleteFirst();
           return;
       }
       Node temp = head;
       while(temp.next.next != null){
           temp = temp.next;
       }
       temp.next = null;
       return;

  }

  public void deleteAfter(int nodeVal){
       Node temp = head;
       while(temp != null && temp.value != nodeVal){
           temp = temp.next;
       }
       if(temp == null || temp.next == null){
           System.out.println("Cannot perform delete: Target node not found or it's the last node.");
           return;
       }

       temp.next = temp.next.next;
  }
    public void delete(int value) {
        // If the list is empty, there's nothing to do.
        if (head == null) {
            System.out.println("List is empty. Cannot delete value " + value);
            return;
        }

        // Case 1: The node to be deleted is the HEAD node.
        if (head.value == value) {
            head = head.next; // Move the head pointer to the next node
            return;
        }

        // Case 2: The node is somewhere else in the list.
        // We need to find the node BEFORE the one we want to delete.
        Node current = head;
        while (current.next != null && current.next.value != value) {
            current = current.next;
        }

        // After the loop, 'current.next' is the node to delete.
        // If 'current.next' is null, the value was not found.
        if (current.next != null) {
            // Bypass the node to be deleted
            current.next = current.next.next;
        } else {
            System.out.println("Value " + value + " not found in the list.");
        }
    }

    public Node get(int index) {
        Node node = head;
        for (int i = 0; node != null && i < index; i++) {
            node = node.next;
        }
        if (node == null) {
            throw new IndexOutOfBoundsException("Index out of bounds");
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
//add two numbers
    public Node addTwoNumbers(Node node1,Node node2){
       Node dummyHead = new Node(-1);
       Node current = dummyHead;
       int carry = 0;
       Node temp1 = node1;
       Node temp2 = node2;
       while(temp1 != null || temp2 != null){
           int sum = carry;
           if(temp1 != null){
               sum += temp1.value;
               temp1 = temp1.next;
           }
           if(temp2 != null){
               sum += temp2.value;
               temp2 = temp2.next;
           }
           Node newNode = new Node(sum%10);
           carry = sum/10;
           current.next = newNode;
           current = current.next;
       }
       if(carry > 0){
           Node newNode = new Node(carry);
           current.next =  newNode;
       }
       return head = dummyHead.next;
    }
//sort List
     public Node sortList(){
       if(head == null){
           return null;
       }
       Node zerohead = new Node(-1);
       Node oneHead = new Node(-1);
       Node twoHead = new Node(-1);

       Node zero = zerohead;
       Node one  = oneHead;
       Node two = twoHead;
       Node temp = head;
       while(temp !=  null){
           if(temp.value == 0){
               zero.next = temp;
               zero = zero.next;
           }else if(temp.value == 1){
               one.next = temp;
               one = one.next;
           }else if(temp.value == 2){
               two.next = temp;
               two = two.next;
           }
           temp = temp.next;
       }
       zero.next = (oneHead.next != null) ? oneHead.next:twoHead.next;
       one.next = twoHead.next;
       two.next = null;

       return head = zerohead.next;
     }
//odd and even linkedList
     public Node oddEvenList(){
        if(head == null){
           return null;
       }
       Node  odd = head;
       Node even = head.next;
       Node evenHead = head.next;
       while(even != null && even.next != null){
           odd.next = odd.next.next;
           even.next = even.next.next;
           odd = odd.next;
           even = even.next;
       }
       odd.next = evenHead;
       return head;
     }
//remove nth node from the end of the  linkedList
     public Node removenthNode(int k){
       Node fast = head;
       Node slow = head;
       for(int i = 0 ; i < k; i++){
           if(fast == null){
               return head;
           }
           fast = fast.next;
       }
       if(fast == null){
           head =  head.next;
           return head;
       }
       while(fast.next != null){
           fast = fast.next;
           slow = slow.next;
       }
       slow.next = slow.next.next;
       return head;
     }
//Reverse the list : iterative
     public Node reverseList(){
       if(head == null || head.next == null){
           return  head;
       }
       Node prev = null;
       Node temp = head;
       while(temp != null){
           Node front = temp .next;
           temp.next = prev;
           prev = temp;
           temp = front;
       }
       return head = prev;
     }
//Reverse the list : recursive
    public Node reverseListR(Node head){
        if(head == null || head.next == null){
            return  head;
        }
       Node newHead = reverseListR(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
//Palindrome
    public boolean isPalindrome(){
       if(head == null || head.next == null){
           return true;
       }
       Node slow =  head;
       Node fast = head;
       while(fast.next != null && fast.next.next != null){
           slow = slow.next;
           fast = fast.next.next;
       }
       Node newHead = reverseListR(slow.next);
       Node first = head;
       Node second = newHead;
       while(second != null){
           if(first.value != second.value){
               reverseListR(newHead);
               return false;
           }
           first = first.next;
           second = second.next;
       }
       reverseListR(newHead);
       return true;
    }
//Add one to linked List
public Node addOne(){
       Node temp = head;
       int carry = addHelper(temp);
       if(carry == 1){
           Node newNode = new Node(-1);
           newNode.next = head;
           head = newNode;
       }
       return head;
}
public int addHelper(Node temp){
       if(temp == null){
           return 1;
       }
       int carry = addHelper(temp.next);
       temp.value += carry;
       if(temp.value < 10){
           return 0;
       }else{
           temp.value = 0;
           return 1;
       }
}
//Find middle of linked List
    public Node findMiddle(){
      Node slow  = head;
      Node fast = head;
      while(fast != null && fast.next != null){
          slow = slow.next;
          fast = fast.next;
      }
      return slow;
    }
// find intersection part
private Node getIntersectionNode(Node headA, Node headB) {
    if (headA == null || headB == null) {
        return null;
    }
    Node temp1 = headA;
    Node temp2 = headB;
    while (temp1 != temp2) {
        temp1 = (temp1 == null) ? headB : temp1.next;
        temp2 = (temp2 == null) ? headA : temp2.next;
    }
    return temp1;
}
//has cycle
public boolean hasCycle(){
    Node slow = head;
    Node fast = head;
    while(fast != null && fast.next != null){
        slow= slow.next;
        fast = fast.next.next;
        if(fast == slow){
            return true;
        }
    }
    return false;
}
//delete middle
//https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
public Node deleteMiddle(){
    Node slow = head;
    Node fast = head;
    fast = fast.next.next;
    while(fast != null && fast.next != null){
        slow= slow.next;
        fast = fast.next.next;
    }
    slow.next = slow.next.next;
    return head;

}
//find loop
int findLoop(Node fast, Node slow){
    int cnt=1;
    fast= fast.next;
    while(fast != slow){
        cnt++;
        fast= fast.next;
    }
    return cnt;
}
    int lenghtLoop(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
            if(fast == slow){
                return findLoop(fast,slow);

            }
        }
        return 0;
    }
//detect cycle start
    public Node detectCycleStart(){
       Node slow = head;
       Node fast = head;
       while(fast != null && fast.next != null){
           slow = slow.next;
           fast = fast.next.next;
           if(slow == fast){
               slow = head;
               while(slow != fast){
                   slow = slow.next;
                   fast = fast.next;
               }
               return slow;
           }
       }
       return null;
    }
//reverseKthNodes in group
public Node reverseKGroup(Node head, int k) {
    Node temp = head;
    Node prevLast = null;

    while (temp != null) {
        Node kthNode = getKthNode(temp, k);

        if (kthNode == null) {
            if (prevLast != null) {
                prevLast.next = temp;
            }
            break;
        }

        Node nextNode = kthNode.next;
        kthNode.next = null;
        Node reversedHead = reverseLinkedList(temp);

        if (temp == head) {
            head = reversedHead;
        } else {
            prevLast.next = reversedHead;
        }

        prevLast = temp;
        temp = nextNode;
    }
    return head;
}

    public Node getKthNode(Node temp, int k) {
        k -= 1;
        while (temp != null && k > 0) {
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
//merge two sorted linked list
public Node mergeTwoSortedLists(LL list1, LL list2) {
    Node dummy = new Node(-1); // Dummy head node
    Node current = dummy;

    Node l1 = list1.head;
    Node l2 = list2.head;

    while (l1 != null && l2 != null) {
        if (l1.value <= l2.value) {
            current.next = l1;
            l1 = l1.next;
        } else {
            current.next = l2;
            l2 = l2.next;
        }
        current = current.next;
    }

    while( l1 != null){
        current.next = l1;
        l1 = l1.next;
    }
    while( l2 != null){
        current.next = l2;
        l2 = l2.next;
    }
    head = dummy.next; // Set the head of the merged list
    return head;
}
//sort LL

public Node mergeTwoSortedLinkedLists(Node list1, Node list2) {
    Node dummyNode = new Node(-1);
    Node temp = dummyNode;

    while (list1 != null && list2 != null) {
        if (list1.value <= list2.value) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }
        temp = temp.next;
    }

    if (list1 != null) {
        temp.next = list1;
    } else {
        temp.next = list2;
    }

    return dummyNode.next;
}
    public Node findMiddle(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public Node sortLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);

        return mergeTwoSortedLinkedLists(left, right);
    }
//rotate linkedList
public Node  rotateRight(int k){
        if(head == null || k == 0){
            return head;
        }
        Node tail = head;
        int len = 1;
        while(tail.next != null){
            len += 1;
            tail = tail.next;
        }
        if(k % len == 0){
            return head;
        }
        k = k % len;
        tail.next = head;
        Node newLastNode = findNthNode(head,len-k);
        head = newLastNode.next;
        newLastNode.next = null;
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
//flatten LinkedList
//public Node merge(Node list1, Node list2) {
//    Node dummyNode = new Node(-1); // Dummy head node
//    Node res = dummyNode;
//
//    while (list1 != null && list2 != null) {
//        if (list1.data < list2.data) {
//            res.child = list1;
//            res = list1;
//            list1 = list1.child;
//        } else {
//            res.child = list2;
//            res = list2;
//            list2 = list2.child;
//        }
//    }
//
//    if (list1 != null) {
//        res.child = list1;
//    } else {
//        res.child = list2;
//    }
//
//    return dummyNode.child;
//}

    //    public Node flattenLinkedList(Node head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        Node mergedHead = flattenLinkedList(head.next);
//        head = merge(head, mergedHead);
//        return head;
//    }
    public class Node{
        private int value;
        private Node next;

        public Node(int value){
            this.value = value;
        }
        public Node(int value,Node next){
            this.value = value;
            this.next = next;
        }
    }
}
