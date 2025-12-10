package Topics.SldingWindowsandTwoPointers.medium;

import java.util.HashMap;

//https://www.geeksforgeeks.org/problems/fruit-into-baskets-1663137462/1
public class Quest4 {
    public static int fruitInBasket(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < arr.length) {
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            if (mpp.size() > k) {
                while (mpp.size() > k) {
                    mpp.put(arr[left], mpp.get(arr[left]) - 1);
                    if (mpp.get(arr[left]) == 0) {
                        mpp.remove(arr[left]);
                    }
                    left++;
                }
            }

            if (mpp.size() <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }
    public static int fruitInBasket2(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < arr.length) {
            mpp.put(arr[right], mpp.getOrDefault(arr[right], 0) + 1);

            if (mpp.size() > k) {
                    mpp.put(arr[left], mpp.get(arr[left]) - 1);
                    if (mpp.get(arr[left]) == 0) {
                        mpp.remove(arr[left]);
                    }
                    left++;

            }

            if (mpp.size() <= k) {
                int len = right - left + 1;
                maxLen = Math.max(maxLen, len);
            }

            right++;
        }

        return maxLen;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 3}; // Example array
        int k = 2; // Maximum distinct integers
        System.out.println(fruitInBasket2(arr, k)); // Output: 4
    }
}
/*
public static int fruitInBasketBrute(int[] arr, int k) {
    int N = arr.length;
    int maxLen = 0;

    for (int i = 0; i < N; i++) { // Start index
        HashMap<Integer, Integer> distinctElements = new HashMap<>();
        for (int j = i; j < N; j++) { // End index

            // Track distinct elements in the current subarray arr[i...j]
            distinctElements.put(arr[j], distinctElements.getOrDefault(arr[j], 0) + 1);

            if (distinctElements.size() <= k) {
                // If constraint met, update max length
                maxLen = Math.max(maxLen, j - i + 1);
            } else {
                // Constraint violated, stop expanding this window
                break;
            }
        }
    }
    return maxLen;
}
 */