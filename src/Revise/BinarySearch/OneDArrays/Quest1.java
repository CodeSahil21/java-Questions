package Revise.BinarySearch.OneDArrays;

public class Quest1 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int ans = binarySearch(arr,8);
        System.out.println("The target element is the index: " + ans);
    }
    static int binarySearch(int[] arr,int target){
        int start =0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] == target){
                return mid;
            }else if(arr[mid] > target){
                end = mid-1;
            }else if (arr[mid] < target){
                start = mid+1;
            }
        }
        return -1;
    }
}
