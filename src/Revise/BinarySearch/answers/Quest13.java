package Revise.BinarySearch.answers;

public class Quest13 {
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + findMedianSortedArrays(a, b));
    }
    public static double findMedianBrute(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[] merged = new int[n + m];
        int i = 0, j = 0, k = 0;

        // Merge arrays
        while (i < n && j < m) {
            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        while (i < n) merged[k++] = nums1[i++];
        while (j < m) merged[k++] = nums2[j++];

        int total = n + m;
        if (total % 2 == 1) return merged[total / 2];
        else return (merged[total / 2] + merged[(total / 2) - 1]) / 2.0;
    }

    public static double findMedianSortedArraysOptimal(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        int totalLength = n1 + n2;

        int ind1 = totalLength / 2 - 1;
        int ind2 = totalLength / 2;

        int i = 0, j = 0, count = 0;
        int ind1el = 0, ind2el = 0;

        while (i < n1 && j < n2) {
            int val = (a[i] <= b[j]) ? a[i++] : b[j++];
            if (count == ind1) ind1el = val;
            if (count == ind2) ind2el = val;
            count++;
        }

        while (i < n1) {
            int val = a[i++];
            if (count == ind1) ind1el = val;
            if (count == ind2) ind2el = val;
            count++;
        }

        while (j < n2) {
            int val = b[j++];
            if (count == ind1) ind1el = val;
            if (count == ind2) ind2el = val;
            count++;
        }

        return (totalLength % 2 == 0) ? (ind1el + ind2el) / 2.0 : ind2el;
    }
    public static double findMedianSortedArrays(int[] a, int[] b) {
        int n1 = a.length, n2 = b.length;
        //if n1 is bigger swap the arrays:
        if (n1 > n2) return findMedianSortedArrays(b, a);

        int n = n1 + n2; //total length
        int left = (n1 + n2 + 1) / 2; //length of left half
        //apply binary search:
        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = left - mid1;
            //calculate l1, l2, r1 and r2;
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;

            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return Math.max(l1, l2);
                else return ((double) (Math.max(l1, l2) + Math.min(r1, r2))) / 2.0;
            } else if (l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return 0; //dummy statement
    }


}
