package Topics.Arrays.Hard;

import java.util.Arrays;

//https://leetcode.com/problems/merge-sorted-array/
public class Quest8 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
            int len = n+m;
            int gap = (len/2) + (len % 2);//to select gap ir=e cieling
            while(gap > 0){
                int left = 0;
                int right = left+gap;
                while(right < len){
                    if(left < m && right >= m ){
                        swapIfgreater(nums1,nums2,left,right-m);
                    }else if( left >= m){
                        swapIfgreater(nums2,nums2,left-m,right-m);
                    }else{
                        swapIfgreater(nums1,nums1,left,right);
                    }
                    left++;
                    right++;
                }
                if(gap == 1){
                    break;
                }
                // Otherwise, calculate new gap:
                gap = (gap / 2) + (gap % 2);
            }
//        System.arraycopy(nums2, 0, nums1, m, n);

    }
    public static void swapIfgreater(int[] arr1,int[] arr2,int m, int n){
        if(arr1[m] > arr2[n]){
            int temp = arr1[m];
            arr1[m] = arr2[n];
            arr2[n] = temp;
        }
    }
    public static void merge(long[] arr1, long[] arr2, int n, int m) {

        // Declare 2 pointers:
        int left = n - 1;
        int right = 0;

        // Swap the elements until arr1[left] is
        // smaller than arr2[right]:
        while (left >= 0 && right < m) {
            if (arr1[left] > arr2[right]) {
                long temp = arr1[left];
                arr1[left] = arr2[right];
                arr2[right] = temp;
                left--;
                right++;
            } else {
                break;
            }
        }

        // Sort arr1[] and arr2[] individually:
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

}
