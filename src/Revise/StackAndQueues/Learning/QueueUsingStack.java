package Revise.StackAndQueues.Learning;
import java.util.*;
public class QueueUsingStack {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public QueueUsingStack() {
        first = new Stack<>();
        second = new Stack<>();
    }

    public void add(int item) throws Exception {
        while (!first.isEmpty()) {
            second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()) {
            first.push(second.pop());
        }
    }

    public int remove() throws Exception {
        return first.pop();
    }

    public int peek() throws Exception {
        return first.peek();
    }

    public boolean isEmpty() {
        return first.isEmpty();
    }
}