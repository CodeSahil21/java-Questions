package Revise.StackAndQueues.Questions;

import java.util.Stack;

public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[] nge = nextGreaterElement(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Next Greater Element for " + arr[i] + " is " + (nge[i] == -1 ? "-1" : nge[i]));
        }
    }
    static int[] nextGreaterElement(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[arr.length];
        for(int i = arr.length-1 ; i >=0;i--){
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
        }
        return  nge;
    }
}
//int[] arr = {4, 5, 2, 25};