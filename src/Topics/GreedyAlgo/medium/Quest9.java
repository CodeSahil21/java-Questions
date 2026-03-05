package Topics.GreedyAlgo.medium;
import java.util.*;
//https://leetcode.com/problems/candy/description/
public class Quest9 {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1); // each child gets at least 1 candy

        // Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }

        // Sum up candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        return total;
    }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};
        System.out.println("Minimum candies required: " + candy(ratings));

        int[] ratings2 = {1, 2, 2};
        System.out.println("Minimum candies required: " + candy(ratings2));

        int[] ratings3 = {1, 3, 4, 5, 2};
        System.out.println("Minimum candies required: " + candy(ratings3));
    }
}

