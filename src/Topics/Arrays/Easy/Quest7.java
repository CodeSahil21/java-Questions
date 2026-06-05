package Topics.Arrays.Easy;
import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/second-largest3735/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=second-largest
//sceond largest element
public class Quest7 {
    public static void main(String[] args) {
        int[] arr = {12,3,5,10,34,19};
        int result = secondLargest(arr);
        System.out.println("The Second largest element is : "+ result);
    }
    static int secondLargest(int[] arr){
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]> largest){
                secondLargest = largest;
                largest = arr[i];
            }else if(arr[i] > secondLargest && arr[i] != largest){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }

        return secondLargest;
    }
}
/*
Phase 1: The Brute Force (Combinatorial)In an interview, you'd explain that without sorting, you are forced to look at every possible group of $m$ packets.The Narrative: "Initially, we could try to find every possible subset of size $m$ from the given packets. For each subset, we calculate the difference between the maximum and minimum values. However, the number of ways to choose $m$ items from $n$ is $\binom{n}{m}$, which is exponential. This will quickly crash for large inputs."Java// Note: This is a conceptual representation of the Brute Force
// logic using recursion to find all combinations.
public static int bruteForceChocolate(int[] arr, int m, int index, List<Integer> current) {
    if (current.size() == m) {
        int max = Collections.max(current);
        int min = Collections.min(current);
        return max - min;
    }
    if (index == arr.length) return Integer.MAX_VALUE;

    // Option 1: Include this packet
    current.add(arr[index]);
    int res1 = bruteForceChocolate(arr, m, index + 1, current);

    // Option 2: Exclude this packet (Backtrack)
    current.remove(current.size() - 1);
    int res2 = bruteForceChocolate(arr, m, index + 1, current);

    return Math.min(res1, res2);
}
Phase 2: The Transition (The "Sorting" Insight)This is your moment to shine by identifying the bottleneck.The Narrative: "The bottleneck here is that our packets are scattered. To minimize the difference between the max and min, the values need to be as close to each other as possible. If we sort the array, those 'close' values will be forced to sit right next to each other. This turns a complex search into a simple Sliding Window problem."Phase 3: The Optimal Solution ($O(n \log n)$)Now, present the efficient logic. Explain that by sorting, you only need to check contiguous windows of size $m$.Javapublic static int chocolateDistribution(int[] arr, int m) {
    // 1. Edge cases: Empty array or not enough packets for students
    if (arr.length == 0 || m > arr.length) {
        return -1;
    }

    // 2. Sort the array - This is the core optimization
    Arrays.sort(arr); // O(n log n)

    int minDiff = Integer.MAX_VALUE;

    // 3. Sliding Window: Check every group of 'm' packets
    // Because it's sorted, the min is at 'i' and max is at 'i + m - 1'
    for (int i = 0; i <= arr.length - m; i++) {
        int currentDiff = arr[i + m - 1] - arr[i];

        if (currentDiff < minDiff) {
            minDiff = currentDiff;
        }
    }

    return minDiff;
}
Phase 4: Performance SummaryPresent this table to the interviewer to wrap up the discussion.ApproachLogicTime ComplexitySpace ComplexityBrute ForceRecursive combinations$O(\binom{n}{m})$$O(n)$ (Recursion depth)Sorting + WindowSort then single pass$O(n \log n)$$O(1)$
 */