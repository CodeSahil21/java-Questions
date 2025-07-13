package Revise.BinarySearch.answers;
import java.util.Arrays;
public class Quest8 {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
    static boolean cowsPossible(int[] arr,int k, int dist){
        int cowsCount = 1;
        int last = arr[0];
        for(int i  = 1;  i < arr.length;i++){
            if(arr[i] - last >= dist){
                cowsCount += 1;
                last = arr[i];
            }
            if(cowsCount >= k){
                return true;
            }
        }
        return false;
    }
    static int aggressiveCows(int[] stalls,int k){
        Arrays.sort(stalls);
        int ans = -1;
        int start  = 1;
        int end = stalls[stalls.length-1] - stalls[0];
        while(start <= end){
            int mid = start + (end - start )/2;
            if(cowsPossible(stalls,k,mid)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
    
}
