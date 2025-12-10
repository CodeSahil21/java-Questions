package Topics.DyanmicProgramming.LIS;
import java.util.*;
public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {10, 9, 2, 5, 3, 7, 101, 18};

        int n = arr.length;

        System.out.println("The length of the longest increasing subsequence is " + lengthOfLIS_Optimal(arr, n));
    }
    public static int lengthOfLIS_Optimal(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(arr[0]);

        for (int i = 1; i < n; i++) {
            // If the current element extends the LIS (it's the largest tail so far)
            if (arr[i] > temp.get(temp.size() - 1)) {
                temp.add(arr[i]);
            }
            // Otherwise, find the smallest tail >= arr[i] and replace it
            else {
                int ind = lowerBound(temp, arr[i]);
                temp.set(ind, arr[i]);
            }
        }
        return temp.size();
    }
    public static int lowerBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size() - 1;
        int ans = arr.size(); // Default answer if target is greater than all elements

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr.get(mid) >= target) {
                // Potential answer found (element is >= target)
                ans = mid;
                // Try to find an even smaller index
                high = mid - 1;
            } else {
                // Current element is too small, look in the right half
                low = mid + 1;
            }
        }
        return ans;
    }
}
