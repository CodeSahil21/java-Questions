package Topics.DyanmicProgramming.stocks;

public class Quest3 {
    public static void main(String[] args) {
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int n = prices.length;
        int k = 2;
        // Calculate and print the maximum profit
        System.out.println("The maximum profit that can be generated with almost k transaction is " + maxProfitTab(prices,k));
    }
    static int maxProfitTab(int[] arr,int k){
        int n = arr.length;
        int[][] ahead = new int[2][k+1];
//        for (int ind = 0; ind < n-1; ind++) {
//            for (int buy = 0; buy <=1 ; buy++) {
//                dp[ind][buy][0] = 0;
//            }
//        }
//        for (int buy = 0; buy <= 1 ; buy++) {
//            for (int cap = 0; cap < 2; cap++) {
//                dp[n][buy][cap] = 0;
//            }
//        }
        for (int ind = n-1; ind >= 0 ; ind--) {
            int[][] curr = new int[2][k+1];
            for (int buy = 0; buy <= 1 ; buy++) {
                for (int cap = 1; cap <= k; cap++) {
                    int op1;
                    int op2;
                    if(buy == 0){
                        //no buy
                        op1  =  ahead[0][cap];
                        //buy = - because we invested
                        op2 =   -arr[ind] + ahead[1][cap];
                    }else{
                        //no sell
                        op1 =  ahead[1][cap];
                        //sell
                        op2 = arr[ind] + ahead[0][cap-1];
                    }
                    curr[buy][cap] =  Math.max(op1,op2);
                }
            }
            ahead = curr.clone();
        }
        return ahead[0][k];
    }

}
