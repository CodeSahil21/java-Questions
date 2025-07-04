package Revise.BinarySearch.OneDArrays;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7};
        int x = 6;
        int ind = searchInsert(arr, x);
        System.out.println("The index is: " + ind);
    }
    public static  int searchInsert(int[] arr, int x) {
        int start = 0;
        int end = arr.length;
        int ans = arr.length;
        while(start <= end){
            int mid = start +(end-start)/2;
            if(arr[mid] >= x){
                ans = mid;
                //search for lowest number greater than x
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
