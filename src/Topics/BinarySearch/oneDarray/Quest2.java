package Topics.BinarySearch.oneDarray;
//https://www.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%253BbatchId=154&utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=floor-in-a-sorted-array
public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {3, 5, 8, 15, 19};
        int  x = 6;
        int ind = lowerBound(arr,  x);
        System.out.println("The lower bound is the index: " + ind);
    }
    public static int lowerBound(int[] arr,int x){
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
