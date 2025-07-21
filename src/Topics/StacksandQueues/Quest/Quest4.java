package Topics.StacksandQueues.Quest;
import java.util.*;
public class Quest4 {
    private static int[] findNSE(int[] arr) {
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nse[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nse;
    }

    // Function to find the Previous Smaller Element for each element
    private static int[] findPSE(int[] arr) {
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            pse[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pse;
    }

    // Function to calculate the sum of the array using NSE and PSE
    public static int sum(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        int total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (right * left * arr[i]) % mod) % mod;
        }

        return total;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        int sumArray = sum(arr);
        System.out.println("Total sum: " + sumArray);
    }
}
/*//for large data

public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
    int[] nse = findNSE(arr);
    int[] pse = findPSE(arr);
    long total = 0;
    int mod = (int)(1e9 + 7);

    for (int i = 0; i < n; i++) {
        long left = i - pse[i];
        long right = nse[i] - i;
        // Calculate contribution using long to avoid overflow
        long contribution = (left * right % mod) * arr[i] % mod;
        total = (total + contribution) % mod;
    }

    return (int)total;
    }


 */