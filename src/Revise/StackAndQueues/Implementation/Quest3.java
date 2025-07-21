package Revise.StackAndQueues.Implementation;

public class Quest3 {
    // Method to find the celebrity in a group of n people.
    public static int findCelebrity(int[][] M, int n) {
        int top = 0;
        int bottom = n - 1;

        while (top < bottom) {
            if (M[top][bottom] == 1) {
                top = top + 1;

            } else {
                bottom = bottom - 1;
            }
        }

        if (top > bottom) {
            return -1;
        }

        for (int i = 0; i < n; i++) {
            if (i == top) {
                continue;
            }
            if (M[top][i] == 0 && M[i][top] == 1) {
                continue;
            } else {
                return -1;
            }
        }

        return top;
    }

    public static void main(String[] args) {
        int[][] M = {
                {0, 1, 1},
                {0, 0, 1},
                {0, 0, 0}
        };
        int n = M.length;
        int celebrity = findCelebrity(M, n);
        if (celebrity == -1) {
            System.out.println("There is no celebrity in the group.");
        } else {
            System.out.println("The celebrity is person " + celebrity);
        }
    }
}
