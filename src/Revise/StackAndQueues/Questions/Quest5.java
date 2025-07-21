package Revise.StackAndQueues.Questions;

import java.util.Stack;

public class Quest5 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 3};
        int[] nse = nextSmallestElement(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("Next Smallest Element for " + nums[i] + " is " + (nse[i] == -1 ? "-1" : nse[i]));
        }
    }

    public static int[] nextSmallestElement(int[] nums) {
        int[] nse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                nse[i] = -1;
            } else {
                nse[i] = stack.peek();
            }
            stack.push(nums[i]);
        }
        return nse;
    }
}
