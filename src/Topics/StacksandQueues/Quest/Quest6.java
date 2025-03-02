package Topics.StacksandQueues.Quest;

import java.util.Stack;

//https://leetcode.com/problems/sum-of-subarray-ranges/description/
public class Quest6 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        long sumArray = subArrayRanges(arr);
        System.out.println("Total sum of subarray ranges: " + sumArray);
    }

    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long sumOfMaxSubarrays = sumOfMaximum(nums);
        long sumOfMinSubarrays = sumofminimums(nums);
        return sumOfMaxSubarrays - sumOfMinSubarrays;
    }

    // Function to find the Next Greater Element for each element
    private static int[] findNGE(int[] arr) {
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            nge[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nge;
    }

    // Function to find the Previous Greater Element for each element
    private static int[] findPGE(int[] arr) {
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            pge[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return pge;
    }

    // Function to calculate the sum of maximum subarrays using NGE and PGE
    public static long sumOfMaximum(int[] arr) {
        int n = arr.length;
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pge[i];
            int right = nge[i] - i;
            total = (total + (right * left * arr[i]) % mod) % mod;
        }

        return total;
    }

    // Function to find the Next Smaller Element for each element
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

    // Function to calculate the sum of subarrays using NSE and PSE
    public static long sumofminimums(int[] arr) {
        int n = arr.length;
        int[] nse = findNSE(arr);
        int[] pse = findPSE(arr);
        long total = 0;
        int mod = (int) (1e9 + 7);

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            total = (total + (right * left * arr[i]) % mod) % mod;
        }

        return total;
    }

}


