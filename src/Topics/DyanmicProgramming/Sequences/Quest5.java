package Topics.DyanmicProgramming.Sequences;

public class Quest5 {
    static int mod =(int)(Math.pow(10,9)+7);
    public static void main(String[] args) {
        int[] arr = {5,2,6,4};
        int n = arr.length;
        int d=3;

        System.out.println("The number of subsets found are "+countPartitions(n,d,arr));
    }
    static int countPartitions(int n, int d, int[] arr){
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
             totalSum += arr[i];
        }
        if(totalSum - d < 0 || (totalSum -d ) % 2 != 0){
            return 0;
        }
        return findWaysTab(arr,(totalSum-d)/2);
    }
    static int findWaysTab(int[] num, int tar){
        int n = num.length;

        int[][] dp = new int[n][tar+1];

        if(num[0] == 0) dp[0][0] =2;  // 2 cases -pick and not pick
        else dp[0][0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) dp[0][num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            for(int target= 0; target<=tar; target++){

                int notTaken = dp[ind-1][target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = dp[ind-1][target-num[ind]];

                dp[ind][target]= (notTaken + taken)%mod;
            }
        }
        return dp[n-1][tar];
    }
    static int findWays(int[] num, int tar){
        int n = num.length;

        int[] prev = new int[tar+1];

        if(num[0] == 0) prev[0] =2;  // 2 cases -pick and not pick
        else prev[0] = 1;  // 1 case - not pick

        if(num[0]!=0 && num[0]<=tar) prev[num[0]] = 1;  // 1 case -pick

        for(int ind = 1; ind<n; ind++){
            int[] cur =new int[tar+1];
            for(int target= 0; target<=tar; target++){
                int notTaken = prev[target];

                int taken = 0;
                if(num[ind]<=target)
                    taken = prev[target-num[ind]];

                cur[target]= (notTaken + taken)%mod;
            }
            prev = cur;
        }
        return prev[tar];
    }


}
