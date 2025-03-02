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
