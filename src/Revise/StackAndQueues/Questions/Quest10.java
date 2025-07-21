package Revise.StackAndQueues.Questions;

import java.util.Stack;

public class  Quest10 {




    public String removeKDigits(String input, int k) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            while (!st.isEmpty() && k > 0 && (st.peek() - '0') > (ch - '0')) {
                st.pop();
                k--;
            }
            st.push(ch);
        }

        // Remove remaining digits if k > 0
        while (k > 0) {
            st.pop();
            k--;
        }

        if (st.isEmpty()) {
            return "0";
        }

        // Build the result in the correct order
        StringBuilder result = new StringBuilder();
        while (!st.isEmpty()) {
            result.append(st.pop());
        }

        // Remove trailing zeros (from the end of the string)
        int i = result.length() - 1;
        while (i >= 0 && result.charAt(i) == '0') {
            i--;
        }

        // Extract the valid number portion
        String trimmed = result.substring(0, i + 1);

        // If the trimmed string is empty, return "0"
        return trimmed.isEmpty() ? "0" : new StringBuilder(trimmed).reverse().toString();
    }
}
/*
public class Histogram {

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = computePrevSmaller(heights);
        int[] nextSmaller = computeNextSmaller(heights);

        return computeMaxArea(heights, prevSmaller, nextSmaller);
    }

    private int[] computePrevSmaller(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            prevSmaller[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        return prevSmaller;
    }

    private int[] computeNextSmaller(int[] heights) {
        int n = heights.length;
        int[] nextSmaller = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            nextSmaller[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        return nextSmaller;
    }

    private int computeMaxArea(int[] heights, int[] prevSmaller, int[] nextSmaller) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}

 */