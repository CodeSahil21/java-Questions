package Topics.StacksandQueues.implementations;
import java.util.*;
//https://leetcode.com/problems/online-stock-span/description/
public class Quest1 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Stock spans are:");
        for (int price : prices) {
            System.out.print(stockSpanner.next(price) + " ");
        }
    }
}

class StockSpanner {
    private Stack<int[]> stack;
    private int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = -1; // Initialize index to -1 since we're starting with the first price
    }

    public int next(int price) {
        index++; // Move to the next index
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            stack.pop();
        }
        int span = (stack.isEmpty()) ? (index + 1) : (index - stack.peek()[1]);
        stack.push(new int[]{price, index});
        return span;
    }


}

