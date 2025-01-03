package Topics.BinarySearch.answers;
//https://leetcode.com/problems/kth-missing-positive-number/description/
public class Quest7 {
    public static void main(String[] args) {
        int[] vec = {4, 7, 9, 10};
        int  k = 4;
        int ans = findKthPositive(vec,  k);
        System.out.println("The missing number is: " + ans);
    }
    public static  int findKthPositive(int[] arr, int k) {
            int start = 0;
            int end = arr.length-1;
            while(start <= end){
                int mid = (start+end)/2;
                int missing = arr[mid] - (mid+1);
                if(missing < k){
                    start =mid+1;
                }else{
                    end = mid-1;
                }
            }
            return  k + end +1;
    }
}
