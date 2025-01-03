package Topics.BinarySearch.answers;
//https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
public class Quest6 {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = shipWithinDays(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
    public static int maxsum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
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
    public static int days(int[] arr,int cap){
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] + load > cap){
                days += 1;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return days;
    }
    public static int shipWithinDays(int[] weights, int days) {
        int start = findMax(weights);
        int end = maxsum(weights);
        int ans = -1;
        while (start <= end){
            int  mid = (start+end)/2;
            if(days(weights,mid) <= days){
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
         return ans;
    }
}
