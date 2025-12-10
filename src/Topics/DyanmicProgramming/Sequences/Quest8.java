package Topics.DyanmicProgramming.Sequences;
//http://leetcode.com/problems/target-sum/description/
public class Quest8 {
    static int mod =(int)(Math.pow(10,9)+7);
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 1 };
        int target = 3;

        int n = arr.length;

        // Call the targetSum function and print the result
        System.out.println("The number of ways found is " + targetSum(n, target, arr));
    }
    static int targetSum(int n, int d, int[] arr){
        int totalSum = 0;
        for (int i = 0; i < arr.length; i++) {
            totalSum += arr[i];
        }
        if(totalSum - d < 0 || (totalSum -d ) % 2 != 0){
            return 0;
        }
        return findWays(arr,(totalSum-d)/2);
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
