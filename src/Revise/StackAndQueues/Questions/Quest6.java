package Revise.StackAndQueues.Questions;

import java.util.Stack;

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

    private static int[] findPGE(int[] arr){
        int n = arr.length;
        int[] pge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n ; i++){
            while(!st.isEmpty() && arr[st.peek()] < arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i] = -1;
            }else{
                pge[i] = st.peek();
            }
            st.push(i);
        }
        return pge;
    }
    private static int[] findNGE(int[] arr){
        int n = arr.length;
        int[] nge = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >=0; i--){
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = n;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }

    public static long sumOfMaximum(int[] arr){
        int[] nge = findNGE(arr);
        int[] pge = findPGE(arr);
        long total = 0;
        int mod = (int)(1e9 + 7);
        for(int i =  0 ; i < arr.length; i++){
            int right = nge[i] - i;
            int left = i - pge[i];
            long contribution = (left * right % mod) * arr[i] % mod;
            total = (total + contribution) % mod;
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
    public static int sumOfSubarrayRanges(int[] arr) {
        int n = arr.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            int maxVal = arr[i];
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, arr[j]);
                maxVal = Math.max(maxVal, arr[j]);
                sum += (maxVal - minVal);
            }
        }

        return sum;
    }
}
