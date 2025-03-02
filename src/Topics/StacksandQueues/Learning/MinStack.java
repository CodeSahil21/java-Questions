package Topics.StacksandQueues.Learning;

import java.util.Stack;

class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int top = stack.pop();
        if (top == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return stack.peek();
    }

    public int getMin() {
        if (minStack.isEmpty()) {
            throw new RuntimeException("Min stack is empty");
        }
        return minStack.peek();
    }
    public static void main(String[] args) {
        System.out.println("2303031300052");

        MinStack minStack = new MinStack();
        minStack.push(5);
        minStack.push(3);
        minStack.push(8);
        System.out.println(minStack.getMin()); // Output: 3
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 3
        minStack.pop();
        System.out.println(minStack.getMin()); // Output: 5
    }
}


