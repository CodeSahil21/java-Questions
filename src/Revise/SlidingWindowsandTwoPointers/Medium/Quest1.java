package Revise.SlidingWindowsandTwoPointers.Medium;

public class Quest1 {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int maxPoints = maxScore(cardPoints, k);
        System.out.println("Maximum Score: " + maxPoints);
    }

    static  int maxScore(int[] arr,int k){
        int leftSum  = 0;
        int rightSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0 ; i < k;i++){
            leftSum += arr[i];
        }
        maxSum = leftSum;
        int rightIndex = arr.length-1;
        for(int i = k-1; i >= 0; i--){
            leftSum -= arr[i];
            rightSum += arr[rightIndex];
            rightIndex--;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
        return maxSum;
    }

}
