package Revise.BinarySearch.answers;

public class Quest3 {
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minEatingSpeed(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
    static int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i = 0 ;i < arr.length;i++){
            max = Math.max(arr[i],max);
        }
        return max;
    }
    static int calculateHours(int[] arr,int hourly){
        int totalHours = 0;
        for(int i = 0; i < arr.length;i++){
            totalHours += (int) Math.ceil((double)(arr[i])/(double)(hourly));
        }
        return totalHours;
    }
    static  int minEatingSpeed(int[] arr,int h){
        int start = 1;
        int end = max(arr);
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int result = calculateHours(arr,mid);
            if(result <= h){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

}
