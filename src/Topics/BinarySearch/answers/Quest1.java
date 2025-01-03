package Topics.BinarySearch.answers;
//https://www.geeksforgeeks.org/problems/square-root/0?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=square-root
public class Quest1 {
    public static void main(String[] args) {
        int n = 28;
        int ans = floorSqrt(n);
        System.out.println("The floor of square root of " + n + " is: " + ans);
    }
    public static int floorSqrt(int n){
        int start = 1;
        int end = n;
        int ans =1;
        while(start <= end){
            int mid = (start + end)/2;
            if(mid*mid <= n){
                ans = mid;
                start =mid+1;
            }else if(mid*mid > n){
                end = mid-1;
            }
        }
        return ans;
    }
}
