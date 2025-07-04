package Revise.BinarySearch.OneDArrays;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int  x = 6;
        int ind = lowerBound(arr,  x);
        System.out.println("The lower bound is the index: " + ind);
    }
    static int lowerBound(int[] arr,int target){
        int start = 0;
        int end = arr.length;
        int ans = arr.length;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(arr[mid] >= target){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
