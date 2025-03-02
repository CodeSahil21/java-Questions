package Topics.StacksandQueues.Quest;
import java.util.*;
public class Quest11 {
    public static int[] count_NGEs(int arr[], int n, int queries[], int q) {
        int[] nextGreater = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            nextGreater[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        int[] result = new int[q];
        for (int i = 0; i < q; i++) {
            int count = 0;
            int index = queries[i];
            for (int j = index + 1; j < n; j++) {
                if (arr[j] > arr[index]) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }
}

