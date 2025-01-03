package Topics.Arrays.Easy;
import java.util.Arrays;
//https://www.geeksforgeeks.org/chocolate-distribution-problem/
public class Quest5 {
    public static void main(String[] args) {
       int[] arr = {7, 3, 2, 4, 9, 12, 56};
       int m = 3;//number of student where each should get one packet
        int result = chocolateDistribution(arr,m);
        System.out.println(result);
    }
    static int chocolateDistribution(int[] arr, int m){
        //first we look for edge ie array is empty or no childrens are greater than packet
        if(arr.length==0 || m >arr.length) {
            return -1;
        }
        //to find subarray where The difference between the maximum and minimum number of chocolates in the packets given to the students is minimized
        Arrays.sort(arr);
        int MinDiff = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length-m+1; i++) {
            int min = arr[i];
            int max = arr[i+m-1];
            MinDiff = Math.min(MinDiff,max-min);
        }
        return MinDiff;
    }
}




/*
Sliding window Technique
1)suppose we have given array  is sorted
{-1,1,2,3,4,5,6}
2)maximum sum of subarray  with n(ex=4) elements consecutively

 */