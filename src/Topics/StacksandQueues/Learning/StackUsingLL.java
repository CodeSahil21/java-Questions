package Topics.StacksandQueues.Learning;

public class StackUsingLL {
    private StackNode top = null;
    private int size = 0;

    boolean isEmpty() {
        return top == null;
    }

    int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        } else {
            return top.val;
        }
    }

    void push(int value) {
        StackNode temp = new StackNode(value);
        if (temp == null) { // When heap is exhausted
            System.out.println("Stack is full");
        } else {
            temp.next = top;
            top = temp;
            System.out.println(value + " pushed into stack");
            size++;
        }
    }

    void pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println(top.val + " popped from stack");
            StackNode temp = top;
            top = top.next;
            size--;
        }
    }

    class StackNode {
        int val;
        StackNode next;
        StackNode(int data) {
            val = data;
            next = null;
        }
    }

    public static void main(String[] args) {
        StackUsingLL stack = new StackUsingLL();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.pop();
        System.out.println("The size of the stack is " + stack.size);
        System.out.println("The top element of the stack is " + stack.peek());
    }
}

