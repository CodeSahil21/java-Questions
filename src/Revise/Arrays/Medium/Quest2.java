package Revise.Arrays.Medium;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int result = maxProfit(arr);
        System.out.println(result);
    }

    static int maxProfit(int[] arr){
        int maxProfit = 0;
        int minOff = arr[0];
        for(int i = 0; i< arr.length;i++){
            minOff = Math.min(minOff,arr[i]);
            int profit = arr[i] - minOff;
            maxProfit = Math.max(maxProfit,profit);
        }
        return maxProfit;
    }
}
