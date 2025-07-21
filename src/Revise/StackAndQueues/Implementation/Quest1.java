package Revise.StackAndQueues.Implementation;
import java.util.Stack;

public class Quest1 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};

        System.out.println("Stock spans are:");
        for (int price : prices) {
            System.out.print(stockSpanner.next(price) + " ");
        }
    }
    static int[] stockSpanBruteForce(int[] prices) {
        int n = prices.length;
        int[] span = new int[n];

        for (int i = 0; i < n; i++) {
            span[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (prices[j] <= prices[i]) {
                    span[i]++;
                } else {
                    break;
                }
            }
        }

        return span;
    }

}

class StockSpanner{
    private Stack<int[]> stack;
    private  int index;
    StockSpanner(){
        stack = new Stack<>();
        index = -1;
    }
    public int next(int price){
        index++;
        while(!stack.isEmpty() && stack.peek()[0] <= price){
            stack.pop();
        }
        int span = index - (stack.isEmpty() ? -1 : stack.peek()[1]);
        stack.push(new int[] {price,index});
        return span;
    }
}