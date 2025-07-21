package Topics.StacksandQueues.Quest;

import java.util.Stack;
//https://www.interviewbit.com/problems/nearest-smaller-element/
public class Quest2 {
    public static void main(String[] args) {
         int[] nums = {4, 1, 2, 3};
        int[] nge = previousSmallestElement(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Next Smallest Element for " + nums[i] + " is " + (nge[i] == -1 ? "-1" : nge[i]));
        }
    }
    public static int[] previousSmallestElement(int[] nums1) {
        int[] nge = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < nums1.length;i++){
            while(!stack.isEmpty() && stack.peek() >= nums1[i]){
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
/*
    public  int[] nextGreaterElements(int[] nums1) {
         int n = nums1.length;
        int[] nge = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums1[i % n]) {
                stack.pop();
            }
            if (i < n) {
                if (stack.isEmpty()) {
                    nge[i] = -1;
                } else {
                    nge[i] = stack.peek();
                }
            }
            stack.push(nums1[i % n]);
        }
        return nge;
    }
    public List<Integer> nearestSmallerToLeft(int[] arr) {
    Stack<Integer> stack = new Stack<>();
    List<Integer> result = new ArrayList<>();

    for (int num : arr) {
        while (!stack.isEmpty() && stack.peek() >= num) {
            stack.pop();
        }
        result.add(stack.isEmpty() ? -1 : stack.peek());
        stack.push(num);
    }
    return result;
}

 */