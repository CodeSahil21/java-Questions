package Topics.LinkedList.LL;
import java.util.*;
public class LL {
    private Node head;
    public LL() {}
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    public void insertLast(int val) {
        Node node = new Node(val);
        if (head == null) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    public void insert(int val, int ind) {
        if (ind == 0) {
            insertFirst(val);
            return;
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            if (temp == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            temp = temp.next;
        }
        Node node = new Node(val, temp.next);
        temp.next = node;
    }

    public int deleteFirst() {
        if (head == null) {
            throw new IllegalStateException("List is Empty");
        }
        int val = head.value;
        head = head.next;
        return val;
    }

    public int deleteLast() {
        if (head == null || head.next == null) {
            return deleteFirst();
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = null;
        return val;
    }

    public int delete(int ind) {
        if (ind == 0) {
            return deleteFirst();
        }
        Node temp = head;
        for (int i = 1; i < ind; i++) {
            if (temp == null || temp.next == null) {
                throw new IndexOutOfBoundsException("Index out of bounds");
            }
            temp = temp.next;
        }
        int val = temp.next.value;
        temp.next = temp.next.next;
        return val;
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
    //https://leetcode.com/problems/add-two-numbers/description/
    public Node addTwoNumbers(Node num1, Node num2) {
        Node dummyHead = new Node(-1);
        Node current = dummyHead;
        Node temp1 = num1;
        Node temp2 = num2;
        int carry = 0;
        while (temp1 != null || temp2 != null) {
            int sum = carry;
            if (temp1 != null) {
                sum += temp1.value;
                temp1 = temp1.next;
            }
            if (temp2 != null) {
                sum += temp2.value;
                temp2 = temp2.next;
            }
            Node newNode = new Node(sum % 10);
            carry = sum / 10;
            current.next = newNode;
            current = current.next;
        }
        if (carry > 0) {
            Node newNode = new Node(carry);
            current.next = newNode;
        }
         return head = dummyHead.next;
    }
    //https://www.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=given-a-linked-list-of-0s-1s-and-2s-sort-it
    public Node sortList() {
        if (head == null) {
            return null;
        }
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        Node temp = head;
        while (temp != null) {
            if (temp.value == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.value == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }
        zero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null;

        return head = zeroHead.next;
    }
    //https://leetcode.com/problems/odd-even-linked-list/description/
    public Node oddEvenList() {
        if (head == null) {
            return null;
        }
        Node odd = head;
        Node even = head.next;
        Node evenHead = head.next;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    //https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    public Node removeNthFromEnd(int k){
        Node fast  = head;
        Node slow = head;
        for (int i = 0; i < k; i++) {
            if(fast == null){
                return  head;
            }
            fast = fast.next;
        }
        if(fast == null){
            head = head.next;
            return  head;
        }
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    //https://leetcode.com/problems/reverse-linked-list/description/
    public Node reverseList(){
        if(head == null || head.next == null){
            return head;
        }
        Node temp = head;
        Node prev = null;
        while(temp != null){
            Node front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return head = prev;
    }
    private Node reverseListR(Node head){
        if(head == null || head.next == null){
            return  head;
        }
        Node newHead = reverseListR(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }
    public void reverseListR(){
        head = reverseListR(head);
    }
    //https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome() {
        if(head == null || head.next == null){
            return  true;
        }
        Node slow = head;
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
        return  true;
    }
//https://www.geeksforgeeks.org/problems/add-1-to-a-number-represented-as-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=add-1-to-a-number-represented-as-linked-list
     public int addHelper(Node temp){
            if(temp == null ) {
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
    public Node addone(){
        Node temp = head;
        int carry = addHelper(temp);
        if(carry == 1){
            Node newNode =  new Node(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
//https://leetcode.com/problems/intersection-of-two-linked-lists/description/
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

    public int getIntersectionNode(LL list1, LL list2) {
        if (list1.head == null || list2.head == null) {
            return -1;
        }
        Node temp1 = list1.head;
        Node temp2 = list2.head;
        Node ans = getIntersectionNode(temp1, temp2);
        return (ans != null) ? ans.value : -1;
    }
/*
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        while(temp1 != temp2){
             temp1= temp1.next;
             temp2 = temp2.next;
             if(temp1 == temp2){
                return temp1;
        }
             if(temp1== null){
                temp1 = headB;
             }
             if(temp2 == null){
                temp2 = headA;
             }
        }
        return temp1;
    }
 */
    //https://leetcode.com/problems/middle-of-the-linked-list/description/
    public Node middleNode(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    //https://leetcode.com/problems/linked-list-cycle/submissions/1498347180/
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
    //https://www.geeksforgeeks.org/problems/find-length-of-loop/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=find-length-of-loop
    int findLoop(Node fast,Node slow){
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
    //https://leetcode.com/problems/linked-list-cycle-ii/
    public Node  detectCycleStart(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow= slow.next;
            fast = fast.next.next;
            if(fast == slow){
                slow = head;
                while(slow != fast){
                    slow = slow.next;
                    fast = fast.next;
                }
                return  slow;
            }
        }
        return null;
    }
//https://leetcode.com/problems/reverse-nodes-in-k-group/
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

//https://leetcode.com/problems/rotate-list/
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
public Node findNthNode(Node temp,int n){
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
//mergecode
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
//https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=flattening-a-linked-list
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
public  Node mergeKLists(ArrayList<Node> listArray) {
    // Priority queue to maintain
    // sorted order based on node values
    // Pairs store node value and pointer to the node
    PriorityQueue<Map.Entry<Integer, Node>> pq = new PriorityQueue<>(
            Comparator.comparingInt(Map.Entry::getKey));

    // Push the heads of all the
    // linked lists into the priority queue
    for (Node node : listArray) {
        // Check if the current linked list exists
        if (node != null) {
            // Push the pair of node data and
            // node pointer into the priority queue
            pq.add(new AbstractMap.SimpleEntry<>(node.value, node));
        }
    }

    // Create a dummy node to build the merged list
    Node dummyNode = new Node(-1, null);
    Node temp = dummyNode;

    // Merge the lists present
    // in the priority queue
    while (!pq.isEmpty()) {
        // Get the top element (minimum node value)
        // from the priority queue
        Map.Entry<Integer, Node> it = pq.poll();

        // Check if the current
        // node has a next node
        if (it.getValue().next != null) {
            // Push the next node
            // into the priority queue
            pq.add(new AbstractMap.SimpleEntry<>(it.getValue().next.value, it.getValue().next));
        }

        // Set the next pointer of the
        // current node in the merged list
        temp.next = it.getValue();
        temp = temp.next;
    }

    // Return the merged linked list
    return dummyNode.next;
}
//
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

   
}


    // Other methods like insertFirst, insertLast, delete, display, etc.







