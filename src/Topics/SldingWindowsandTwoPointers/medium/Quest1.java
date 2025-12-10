package Topics.SldingWindowsandTwoPointers.medium;
//https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/description/
public class Quest1 {
    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        int maxPoints = maxScore(cardPoints, k);
        System.out.println("Maximum Score: " + maxPoints);
    }
    public static int maxScoreBrute(int[] cardPoints, int k) {
        int N = cardPoints.length;
        int maxSum = 0;

        // Iterate i from 0 to k (i = number of cards taken from the left)
        for (int i = 0; i <= k; i++) {
            int currentScore = 0;

            // 1. Sum of i cards from the left
            for (int j = 0; j < i; j++) {
                currentScore += cardPoints[j];
            }

            // 2. Sum of k-i cards from the right
            for (int j = 0; j < k - i; j++) {
                currentScore += cardPoints[N - 1 - j];
            }

            maxSum = Math.max(maxSum, currentScore);
        }
        return maxSum;
    }
    public static int maxScore(int[] cardPoints, int k) {

        int leftSum =0;
        int rightSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < k;i++){
            leftSum = leftSum + cardPoints[i];
        }
        int rightIndex = cardPoints.length-1;
        maxSum = leftSum;
        for (int i = k-1; i >= 0; i--) {
            leftSum = leftSum - cardPoints[i];
            rightSum = rightSum + cardPoints[rightIndex];
            rightIndex = rightIndex-1;
            maxSum = Math.max(maxSum,leftSum+rightSum);
        }
       return maxSum;
    }
}
