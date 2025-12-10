package Topics.DyanmicProgramming.LIS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//https://leetcode.com/problems/largest-divisible-subset/
public class Quest4 {
    public static void main(String[] args) {


        int[] arr = {1, 16, 7, 8, 4};
        int n = arr.length;


        System.out.print("The longest divisible subset elements are: ");
        System.out.println(divisibleSet(arr,n));

    }
    public static List<Integer> divisibleSet(int[] arr, int n) {
        int[] dp = new int[n];
        int[] prev_arr = new int[n];
        int last_Ind = 0;
        Arrays.fill(dp,1);
        int maxi = 1;
        Arrays.sort(arr);
        for (int ind = 0; ind < n; ind++) {
            prev_arr[ind] = ind;
            for (int prev = 0; prev < ind; prev++) {
                if(arr[ind] % arr[prev] == 0 &&  1 + dp[prev] > dp[ind] ){
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
        return lisSeq;
    }
}
