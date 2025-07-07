package Revise.BinarySearch.answers;

public class Quest5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int limit = 8;
        int ans = smallestDivisor(arr, limit);
        System.out.println("The minimum divisor is: " + ans);
    }
    static int helperFunc(int[] arr,int div){
        int sum = 0;
        for(int i = 0; i< arr.length;i++){
            sum += (int) Math.ceil((double)(arr[i])/(double)(div));
        }
        return sum;
    }
    static int smallestDivisor(int[] arr,int limit){
        int start = 1;
        int end =  Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length;i++ ){
            end = Math.max(arr[i],end);
        }
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int result = helperFunc( arr, mid);
            if(result <= limit){
                ans = mid;
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }

}
