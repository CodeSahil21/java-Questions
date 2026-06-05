package Topics.Arrays.Medium;

import java.util.Arrays;

//https://www.geeksforgeeks.org/given-a-sorted-and-rotated-array-find-if-there-is-a-pair-with-a-given-sum/?ref=lbp
//Pair Sum in a Sorted and Rotated Array
public class Quest9 {
    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        int target = 45;
        System.out.println("Pair found: " + pairInRotatedSorted(arr, target)); // Output: true
    }

    static boolean  pairInRotatedSorted(int[] arr, int target) {
        int start = 0;
        int end = arr.length-1;
        Arrays.sort(arr);
        while (start < end) {
            int sum = arr[start] + arr[end];
            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }

//    static int findpivot(int[] arr){
//        int start = 0;
//        int end = arr.length-1;
//        while(start <= end){
//            int mid = start + (end-start)/2;
//            //4 cases
//            //case 1:arr = {4,5,6,7,0,1,2} ex mid = 7 and mid+1 =0
//            if(mid < end && arr[mid]>arr[mid+1]){
//                return mid;
//            }
//            //case 2: {4,5,6,7,0,1,2,3} ex mid = 0 and mid-1 =7
//            if(mid > start && arr[mid] < arr[mid-1]){
//                return mid -1;
//            }
//            if(arr[mid] <= arr[start]){
//                end = mid-1;
//            }else{
//                start = mid+1;
//            }
//        }
//        return  -1;
//    }


    static boolean findPair(int arr[], int n, int target) {
        // 1. Find the pivot point (the largest element)
        int pivot = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // 2. Initialize pointers based on the pivot
        // Smallest element is right after the largest (pivot)
        int left = (pivot + 1) % n;
        int right = pivot;

        // 3. Meet-in-the-middle search using circular pointers
        while (left != right) {
            int currentSum = arr[left] + arr[right];

            if (currentSum == target) {
                return true;
            }

            // Adjust pointers circularly if sum doesn't match
            if (currentSum < target) {
                left = (left + 1) % n; // Move to next larger element
            } else {
                right = (n + right - 1) % n; // Move to next smaller element
            }
        }
        return false;
    }
}

