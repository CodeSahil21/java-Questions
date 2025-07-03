package Topics.Arrays.Medium;
import java.util.*;
//https://leetcode.com/problems/subarray-sum-equals-k/description/
//subarray-sum-equals-k
public class Quest20 {
    public static void main(String[] args) {
      int[] arr = {3, 4, 7, -2, 2, 1, 4, 2};
      int   k = 7;
    }
    public static int subarraySum(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> mpp = new HashMap<>();
        int preSum = 0, cnt = 0;

        mpp.put(0, 1); // Initialize with sum 0 occurring once

        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }
        return cnt;
    }

}
