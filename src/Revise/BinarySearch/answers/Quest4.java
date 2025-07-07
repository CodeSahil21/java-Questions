package Revise.BinarySearch.answers;

public class Quest4 {
    public static void main(String[] args) {
        int[] arr = {7, 7, 7, 7, 13, 11, 12, 7};
        int k = 3;
        int m = 2;
        int ans = minDays(arr, k, m);
        if (ans == -1)
            System.out.println("We cannot make m bouquets.");
        else
            System.out.println("We can make bouquets on day " + ans);

    }
    static boolean helperFunc(int[] arr,int k, int m,int days){
        int count = 0;
        int noOfBouqets = 0;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] <= days){
                count++;
            }else{
                noOfBouqets += (count/k);
                count =0;
            }
        }
        noOfBouqets += (count/k);
        if(noOfBouqets >= m ){
            return true;
        }
        return false;
    }
    static int minDays(int[] arr,int k,int m){
        if(arr.length < m* k){
            return -1;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0 ;  i < arr.length;i++){
            max = Math.max(arr[i],max);
            min  = Math.min(arr[i],min);
        }
        int start = min;
        int end =  max;
        int ans = -1;
        while(start<= end){
            int mid = start + (end - start)/2;
            if(helperFunc(arr,k,m,mid)){
                ans = mid;
                end = mid-1;
            }else {
                start = mid+1;
            }
        }
        return ans;
    }
}
