package Topics.BinarySearch.answers;

import java.util.Arrays;

//https://www.spoj.com/problems/AGGRCOW/
public class Quest8 {
    public static void main(String[] args) {
        int[] stalls = {0, 3, 4, 7, 10, 9};
        int k = 4;
        int ans = aggressiveCows(stalls, k);
        System.out.println("The maximum possible minimum distance is: " + ans);
    }
    public static boolean cowsPossible(int[] arr,int dist ,int cows){
        int cowscount =1;
        int last = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] - last  >= dist ){
                cowscount += 1;
                last = arr[i];
            }
            if(cowscount >= cows){
                return true;
            }
        }
        return false;
    }
    static  int aggressiveCows(int[] arr,int k){
        Arrays.sort(arr);
        int start = 1;
        int ans = -1;
        int end = arr[arr.length-1] -arr[0];
        while(start <= end){
            int mid = (start+end)/2;
            if(cowsPossible(arr,mid,k)){
                ans = mid;
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return ans;
    }
}
