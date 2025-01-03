package Topics.BinarySearch.oneDarray;
//https://leetcode.com/problems/search-insert-position/#:~:text=Search%20Insert%20Position%20%2D%20LeetCode&text=Given%20a%20sorted%20array%20of,(log%20n)%20runtime%20complexity.
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
