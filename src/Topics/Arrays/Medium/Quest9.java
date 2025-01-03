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
}

