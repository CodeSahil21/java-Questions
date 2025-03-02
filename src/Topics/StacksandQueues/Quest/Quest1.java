package Topics.StacksandQueues.Quest;

import java.util.Stack;

//https://leetcode.com/problems/next-greater-element-ii/description/
public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 2};
        int[] nge = nextGreaterElement(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println("Next Greater Element for " + arr[i] + " is " + (nge[i] == -1 ? "-1" : nge[i]));
        }
    }
    public static int[] nextGreaterElement(int[] nums1) {
          int[] nge = new int[nums1.length];
          Stack<Integer> stack = new Stack<>();

          for(int i = nums1.length-1; i >= 0;i--){
              while(!stack.isEmpty() && stack.peek() <= nums1[i]){
                  stack.pop();
              }
              if(stack.isEmpty()){
                  nge[i] = -1;
              }else{
                  nge[i] = stack.peek();
              }
              stack.push(nums1[i]);
          }
          return nge;
    }
}

