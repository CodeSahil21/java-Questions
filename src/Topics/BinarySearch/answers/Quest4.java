package Topics.BinarySearch.answers;
//https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/
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
    public static int findmin(int[] arr){
        int min = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        return min;
    }
    public static int findmax(int[] arr){
        int max = arr[0];
        for(int i = 0; i < arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static boolean possible(int[] arr,int m,int k,int day){
        int count = 0;
        int noOfBouquets =0;
        for(int i = 0; i<arr.length;i++){
            if(arr[i] <= day){
                count++;
            }else{
                noOfBouquets += (count/k);
                count = 0;
            }
        }
        noOfBouquets += (count/k);
        if(noOfBouquets >= m){
            return true;
        }
        return false;
    }
    public static int minDays(int[] bloomday, int m, int k) {
        if(bloomday.length < m*k){
            return -1;
        }
        int ans = -1;
        int start = findmin(bloomday);
        int end = findmax(bloomday);
        while(start <= end){
            int mid = (start + end)/2;
            if(possible(bloomday,m,k,mid)){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
}
