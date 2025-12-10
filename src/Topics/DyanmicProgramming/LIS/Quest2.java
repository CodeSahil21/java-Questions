package Topics.DyanmicProgramming.LIS;

import java.util.*;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + printLISN2(arr, n));
    }
    public static List<Integer> printLISN2(int[] arr, int n) {
        int[] dp = new int[n];
        int[] prev_arr = new int[n];
        int last_Ind = 0;
        Arrays.fill(dp,1);
        int maxi = 1;
        for (int ind = 0; ind < n; ind++) {
            prev_arr[ind] = ind;
            for (int prev = 0; prev < ind; prev++) {
                if(arr[prev] < arr[ind] &&  1 + dp[prev] > dp[ind] ){
                    dp[ind] = 1 + dp[prev];
                    prev_arr[ind] = prev;
                }
            }
        }
        int maxLen = 0, maxIndex = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxLen) {
                maxLen = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> lisSeq = new ArrayList<>();
        int curr = maxIndex; // Index of the last element in the LIS

        while (true) {
            lisSeq.add(arr[curr]);
            if (prev_arr[curr] == curr) {
                break;
            }

            curr = prev_arr[curr];
        }
        Collections.reverse(lisSeq);

        return lisSeq;
    }
}
