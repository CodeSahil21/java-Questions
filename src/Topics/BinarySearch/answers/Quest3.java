package Topics.BinarySearch.answers;
//https://leetcode.com/problems/koko-eating-bananas/description/
public class Quest3 {
    public static void main(String[] args) {
        int[] v = {7, 15, 6, 3};
        int h = 8;
        int ans = minEatingSpeed(v, h);
        System.out.println("Koko should eat at least " + ans + " bananas/hr.");
    }
    static int findmax(int[] arr){
        int max = Integer.MIN_VALUE;
        for(int i =0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    public static int calculatehours(int[] arr,int hourly){
        int totalhours = 0;
        for (int i = 0; i < arr.length; i++) {
            totalhours += (int) Math.ceil((double)(arr[i])/(double)(hourly));
        }
        return totalhours;
    }
    public static int minEatingSpeed(int[] piles, int h) {
    int start = 1;
    int end = findmax(piles);
    int ans = Integer.MAX_VALUE;
    while(start <= end){
        int mid = start + (end - start) / 2;
          int result = calculatehours(piles,mid);
          if(result <= h){
              ans = mid;
              end = mid-1;
          }else{
              start = mid+1;
          }
    }
    return  ans;
    }

}
