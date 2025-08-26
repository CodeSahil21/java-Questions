package Revise.greedyalgo.medium;

import java.util.Arrays;

public class Quest9 {
    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println("Minimum candies required: " + candy(ratings));
    }
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];

        // Step 1: Give each child 1 candy
        Arrays.fill(candies, 1);

        // Step 2: Traverse left to right
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Step 3: Traverse right to left
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Step 4: Sum up candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }

        return total;
    }
}
