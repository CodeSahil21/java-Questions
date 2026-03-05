package Topics.Recursion;
import java.util.*;
public class Quest17 {
    public String getPermutation(int n, int k) {
        int fact = 1;
        List<Integer> numbers = new ArrayList<>();

        // Calculate (N-1)! and store numbers from 1 to N-1
        for (int i = 1; i < n; i++) {
            fact = fact * i;
            numbers.add(i);
        }
        // Add the last number N
        numbers.add(n);

        String ans = "";
        k = k - 1; // Convert K to 0-based indexing

        while (true) {
            // Find the correct block and append the number
            ans = ans + numbers.get(k / fact);

            // Remove the used number from the list
            numbers.remove(k / fact);

            // If all numbers are used, break the loop
            if (numbers.size() == 0) {
                break;
            }

            // Update K to find the position in the next sub-block
            k = k % fact;

            // Update the factorial for the remaining numbers
            fact = fact / numbers.size();
        }

        return ans;
    }
}
