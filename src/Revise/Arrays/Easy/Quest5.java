package Revise.Arrays.Easy;
import java.util.Arrays;

public class Quest5 {
    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;//number of student where each should get one packet
        int result = chocolateDistribution(arr,m);
        System.out.println(result);
    }

    static int chocolateDistribution(int[] arr,int m){
        if(arr.length == 0 || arr.length < m ){
            return -1;
        }
        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for(int i = 0 ; i < arr.length-m+1;i++){
            int min = arr[i];
            int max = arr[i+m-1];
            minDiff = Math.min(minDiff , max-min);
        }
        return minDiff;
    }
}
