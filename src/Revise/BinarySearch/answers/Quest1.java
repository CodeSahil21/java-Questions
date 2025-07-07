package Revise.BinarySearch.answers;

public class Quest1 {
    public static void main(String[] args) {
        int n = 28;
        int ans = floorSqrt(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
    static int floorSqrt(int n){
        int start = 1;
        int end = n;
        long ans = 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid*mid <= n){
                ans = mid;
                start = mid+1;
            }else if( mid * mid  > n){
                end = mid-1;
            }
        }
        return (int) ans;
    }
}
