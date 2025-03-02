package Topics.Arrays.Medium;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = maxProfit(arr);
        System.out.println(result);
    }
    //time complexity o(n) and space o(1)
    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        int minoff = prices[0];

        for(int i = 0;i<prices.length;i++){
//we select minioff form the array :minium stock prices at ith day
            minoff = Math.min(minoff,prices[i]);
//we subtract prices of stock at that day  with minoff to calculate profit
            int profit = prices[i] - minoff;
            // we compare profit with maxprofit  and if profit > maxprofit :maxprofit = profit
            maxprofit = Math.max(maxprofit, profit);

        }
        return maxprofit;
    }
}
