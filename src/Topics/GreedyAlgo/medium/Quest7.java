package Topics.GreedyAlgo.medium;
import java.util.*;
//https://leetcode.com/problems/insert-interval/
public class Quest7 {
    public static void main(String[] args) {

    }
    public  static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Left part (before newInterval, no overlap)
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Overlapping part (merge intervals)
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Right part (after newInterval, no overlap)
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert List<int[]> to int[][]
        return result.toArray(new int[result.size()][]);
    }
}

