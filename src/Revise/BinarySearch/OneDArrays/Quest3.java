package Revise.BinarySearch.OneDArrays;

public class Quest3 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int  x = 9;
        int ind = upperBound(arr,  x);
        System.out.println("The upper bound is the index: " + ind);
    }
    static int upperBound(int[] arr , int target){
        int start = 0;
        int end = arr.length;
        int ans = arr.length;
        while (start  <= end){
            int mid = start + ( end - start)/2;
            if(arr[mid] > target){
                ans  = mid ;
                end = mid -1;
            }else{
                start = mid +1;
            }
        }
        return ans;
    }
}
