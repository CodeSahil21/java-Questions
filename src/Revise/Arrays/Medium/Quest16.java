package Revise.Arrays.Medium;

public class Quest16 {
    public static void main(String[] args) {
        int[] a = {100,101,102,103,104,105, 200, 1, 2, 3, 4};
        int ans = longestSuccessiveElements(a);
        System.out.println("The longest consecutive sequence is " + ans);
    }
    static int longestSuccessiveElements(int[] arr){
        int lastSmaller = Integer.MIN_VALUE;
        int cnt = 0;
        int longest = 1;
        for(int i = 0 ; i < arr.length;i++){
            if(arr[i] -1 == lastSmaller){
                cnt += 1;
                lastSmaller = arr[i];
        }else if(arr[i] != lastSmaller) {
                cnt = 1;
                lastSmaller = arr[i];
            }
            longest = Math.max(longest,cnt);
        }
        return longest;
    }
}
