package Revise.greedyalgo.medium;

import java.util.Arrays;

public class Quest6 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 4}, {3, 5}, {5, 7}, {6, 8}};
        System.out.println("Minimum intervals to remove: " + eraseOverlapIntervals(intervals));
    }
    static int eraseOverlapIntervals(int[][] arr){
      if(arr.length == 0) {
          return  0;
      }
      Arrays.sort(arr,(a,b)->Integer.compare(a[1],b[1]));
        int count = 1;
        int lastEndTime = arr[0][1];
        for(int i = 1 ; i < arr.length;i++){
            if(arr[i][0] >= lastEndTime){
                count++;
                lastEndTime = arr[i][1];
            }
        }
        return arr.length - count;
    }
}
