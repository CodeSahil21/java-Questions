package Topics.StacksandQueues.Quest;

import java.util.*;
//https://leetcode.com/problems/maximal-rectangle/submissions/1539411440/
public class Quest9 {
    public static int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int n = matrix.length, m = matrix[0].length;
        int[][] prefixSum = new int[n][m];

        // Compute prefix sum (height of histogram at each column)
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (matrix[i][j] == '1') {
                    prefixSum[i][j] = (i == 0) ? 1 : prefixSum[i - 1][j] + 1;
                } else {
                    prefixSum[i][j] = 0;
                }
            }
        }

        int maxArea = 0;
        // Solve largest histogram for each row
        for (int i = 0; i < n; i++) {
            maxArea = Math.max(maxArea, largestRectangleArea(prefixSum[i]));
        }

        return maxArea;
    }
    static int largestRectangleArea(int histo[]) {
        Stack< Integer > st = new Stack < > ();
        int maxA = 0;
        int n = histo.length;
        for (int i = 0; i <= n; i++) {
            while (!st.empty() && (i == n || histo[st.peek()] >= histo[i])) {
                int height = histo[st.peek()];
                st.pop();
                int width;
                if (st.empty())
                    width = i;
                else
                    width = i - st.peek() - 1;
                maxA = Math.max(maxA, width * height);
            }
            st.push(i);
        }
        return maxA;
    }
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };

        System.out.println("Maximal Rectangle Area: " + maximalRectangle(matrix));
    }
}
/*
import java.util.*;

public class HistogramMaxArea {

    public static int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // Previous Smaller Element (PSE)
        int[] pse = new int[n];
        Stack<Integer> st1 = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st1.isEmpty() && heights[st1.peek()] >= heights[i]) {
                st1.pop();
            }
            pse[i] = st1.isEmpty() ? -1 : st1.peek();
            st1.push(i);
        }

        // Next Smaller Element (NSE)
        int[] nse = new int[n];
        Stack<Integer> st2 = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st2.isEmpty() && heights[st2.peek()] >= heights[i]) {
                st2.pop();
            }
            nse[i] = st2.isEmpty() ? n : st2.peek();
            st2.push(i);
        }

        // Calculate max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nse[i] - pse[i] - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};
        System.out.println("Largest Rectangle Area: " + largestRectangleArea(heights));
    }
}

 */