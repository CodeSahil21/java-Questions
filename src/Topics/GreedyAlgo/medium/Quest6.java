package Topics.GreedyAlgo.medium;
import java.util.*;
//https://leetcode.com/problems/non-overlapping-intervals/
public class Quest6 {
        public static int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) return 0;

            // Sort intervals based on the ending time (index 1)
            Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

            int count = 1; // Count of non-overlapping intervals
            int lastEndTime = intervals[0][1];

            for (int i = 1; i < intervals.length; i++) {
                if (intervals[i][0] >= lastEndTime) {
                    count++;
                    lastEndTime = intervals[i][1]; // Update last ending time
                }
            }

            return intervals.length - count; // Intervals to remove
        }

        public static void main(String[] args) {
            int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {5, 7}, {6, 8}};
            System.out.println("Minimum intervals to remove: " + eraseOverlapIntervals(intervals));
        }
    }
