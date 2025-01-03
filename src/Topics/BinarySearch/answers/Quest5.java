package Topics.BinarySearch.answers;
//https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class Quest5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
    public static  int findMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    static int sumDiv(int[] arr,int div){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
    public static int smallestDivisor(int[] nums, int threshold) {
             int start = 1;
             int end = findMax(nums);
             int ans = -1;
             while(start <= end){
                 int mid = start + (end-start)/2;
                 if(sumDiv(nums,mid) <= threshold){
                     ans = mid;
                     end = mid-1;
                 }else{
                     start = mid+1;
                 }
             }
             return ans;
    }
}
