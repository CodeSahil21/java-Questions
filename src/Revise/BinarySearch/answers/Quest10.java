package Revise.BinarySearch.answers;

public class Quest10 {
    public static int countPainters(int[] boards, int time) {
        int painters = 1;
        long boardsPainter = 0;

        for (int i = 0; i < boards.length; i++) {
            if (boardsPainter + boards[i] <= time) {
                boardsPainter += boards[i];
            } else {
                painters++;
                boardsPainter = boards[i];
            }
        }
        return painters;
    }

    public static int findLargestMinDistance(int[] boards, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int board : boards) {
            low = Math.max(low, board);
            high += board;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int painters = countPainters(boards, mid);

            if (painters > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] boards = {10, 20, 30, 40};
        int k = 2;
        int ans = findLargestMinDistance(boards, k);
        System.out.println("The answer is: " + ans);
    }
}
