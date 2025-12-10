package Topics.DyanmicProgramming.Sequences;
//https://leetcode.com/problems/partition-equal-subset-sum/
public class Quest2 {
    public static void main(String args[]) {
        int[] arr = {2, 3, 3, 3, 4, 5};
        int n = arr.length;

        // Check if the array can be partitioned into two equal subsets
        if (canPartition(n, arr))
            System.out.println("The Array can be partitioned into two equal subsets");
        else
            System.out.println("The Array cannot be partitioned into two equal subsets");
    }
    static  boolean canPartition(int n,int[] arr){
        int totalSum = 0;
        for (int i = 0; i < n; i++) {
            totalSum += arr[i];
        }
       if(totalSum % 2 == 1){
           return  false;
       }
       int target = totalSum /2;
       if(subsetSumToKTabSpace(n,target,arr)){
           return true;
       }
       return false;
    }
    static boolean subsetSumToKTabSpace(int n,int k,int[] arr) {
        boolean[] prev = new boolean[k+1];
        prev[0] = true;
        if (arr[0] <= k) {
            prev[arr[0]] = true;
        }
        for (int ind = 1; ind < n ; ind++) {
            boolean[] curr = new boolean[k+1];
            curr[0] = true;
            for (int t = 1; t <=k ; t++) {
                boolean notTake = prev[t];
                boolean take = false;
                if (t >= arr[ind]){
                    take = prev[t - arr[ind]];
                }
                curr[t] = take | notTake;
            }
            prev = curr;
        }
        return prev[k];
    }

}
