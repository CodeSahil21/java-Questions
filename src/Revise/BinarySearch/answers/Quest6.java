package Revise.BinarySearch.answers;

public class Quest6 {
    public static void main(String[] args) {
        int[] weights = {5, 4, 5, 2, 3, 4, 5, 6};
        int d = 5;
        int ans = shipWithinDays(weights, d);
        System.out.println("The minimum capacity should be: " + ans);
    }
    static int maxSum(int[] arr){
        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
    static int findMax(int[] arr){
        int max =Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length;i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    static  int heleprFunc(int[] arr, int cap){
        int days = 1;
        int load = 0;
        for (int i = 0; i < arr.length; i++) {
            if(load + arr[i] > cap){
                days += 1;
                load = arr[i];
            }else{
                load += arr[i];
            }
        }
        return days;
    }

    static int shipWithinDays(int[] arr,int days){
        int start = findMax(arr);
        int end = maxSum(arr);
        int ans = 0;
        while(start <= end){
            int mid = start + (end - start)/2;
            int result = heleprFunc(arr,mid);
            if(result <= days){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
