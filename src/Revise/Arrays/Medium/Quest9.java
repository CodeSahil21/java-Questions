package Revise.Arrays.Medium;
import java.util.Arrays;
public class Quest9 {
    public static void main(String[] args) {
        int[] arr = {11, 15, 26, 38, 9, 10};
        int target = 19;
        System.out.println("Pair found: " + pairInRotatedSorted(arr, target)); // Output: true
    }

    static boolean pairInRotatedSorted(int[] arr,int target){
        int start = 0 ;
        int end = arr.length-1;
        Arrays.sort(arr);
        while(start <= end){
            int sum = arr[start] + arr[end];
            if(sum  > target){
                end--;
            }else if(sum < target){
                start++;
            }else if(sum == target){
                return true;
            }
        }
        return false;
    }
}
