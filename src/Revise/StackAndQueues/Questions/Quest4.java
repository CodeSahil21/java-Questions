package Revise.StackAndQueues.Questions;

import java.util.Arrays;
import java.util.Stack;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {3, 1, 2,4};
        System.out.println("Sum of Subarray Minimums: " + sumSubArrayMinsOptimal(arr));
//        int[] nse = nse(arr);
//        int[] pse = pse(arr);
//        System.out.println(Arrays.toString(nse));
//        System.out.println(Arrays.toString(pse));
    }
    private static int[] nse(int[] arr){
        int n = arr.length;
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = n-1 ; i >=0;i--){
            while(!st.isEmpty() && arr[st.peek()] >= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i] = n;
            }else{
                nse[i] = st.peek();
            }
            st.push(i);
        }
        return nse;
    }

    private static int[] pse(int[] arr){
        int n = arr.length;
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0 ; i < n;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i] = -1;
            }else{
                pse[i] = st.peek();
            }
            st.push(i);
        }
        return pse;
    }
  static int sumSubArrayMinsOptimal(int[] arr){
        int[] nse = nse(arr);
        int[] pse = pse(arr);
        long total = 0;
        int mod = (int)(1e9 +7);
        for(int i =0 ; i < arr.length;i++){
            int left =  i - pse[i] ;
            int right = nse[i] - i;
            long contribution = (left * right % mod) * arr[i] % mod;
            total = (total + contribution) % mod;
        }
        return (int)total;
  }
    public static int sumSubarrayMinsBrute(int[] arr) {
        int n = arr.length;
        int sum = 0;
        int mod = (int)(1e9 + 7);
        for (int i = 0; i < n; i++) {
            int minVal = arr[i];
            for (int j = i; j < n; j++) {
                minVal = Math.min(minVal, arr[j]);
                sum = (sum + minVal) % mod;
            }
        }

        return sum;
    }
}
