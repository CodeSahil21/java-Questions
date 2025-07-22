package Revise.SlidingWindowsandTwoPointers.Medium;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 2, 3, 3}; // Example array
        int k = 2; // Maximum distinct integers
        System.out.println(fruitInBasket2(arr, k)); // Output: 4
    }
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
      static int fruitInBasket2(int[] arr, int k){
        int left  = 0;
        int right = 0;
        int maxLen = 0;
        int n = arr.length;
          Map<Integer,Integer> mpp = new HashMap<>();
          while (right < n){
              mpp.put(arr[right],mpp.getOrDefault(arr[right] ,0)+1);
              if(mpp.size()> k){
                  mpp.put(arr[left] ,mpp.get(arr[left])-1);
                  if(mpp.get(arr[left]) == 0){
                      mpp.remove(arr[left]);
                  }
                  left++;
              }
              if(mpp.size() <= k){
                  int len =  right -left + 1;
                  maxLen = Math.max(len,maxLen);
              }
              right++;
          }
          return maxLen;
      }
    public static int totalFruit(int[] fruits) {
        int maxLen = 0;

        for (int i = 0; i < fruits.length; i++) {
            Set<Integer> basket = new HashSet<>();
            int j = i;

            while (j < fruits.length) {
                basket.add(fruits[j]);
                if (basket.size() > 2) break; // too many types
                maxLen = Math.max(maxLen, j - i + 1);
                j++;
            }
        }

        return maxLen;
    }

}
