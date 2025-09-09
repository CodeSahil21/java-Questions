package Revise.Graphs.ShortestPath;

import java.util.LinkedList;
import java.util.Queue;

class Pair6 {
    int first, second;
    Pair6(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
public class Quest11 {
    public static void main(String[] args) {
        int start=3, end=30;
        int[] arr = {2,5,7};

        int ans = minimumMultiplications(arr,start,end);

        System.out.print(ans);
        System.out.println();
    }
    static int minimumMultiplications(int[] arr, int start, int end) {

        // Create a queue for storing the numbers as a result of multiplication
        // of the numbers in the array and the start number.
        Queue<Pair6> q = new LinkedList<>();
        q.add(new Pair6(start, 0));

        // Create a dist array to store the no. of multiplications to reach
        // a particular number from the start number.
        int[] dist = new int[100000];
        for(int i = 0;i<100000;i++) dist[i] = (int)(1e9);
        dist[start] = 0;
        int mod = 100000;
        int n = arr.length;
        // O(100000 * N)

        // Multiply the start no. with each of numbers in the arr
        // until we get the end no.
        while(!q.isEmpty()) {
            int node = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            for(int i = 0;i < n; i++) {
                int num = (arr[i] * node) % mod;

                // If the no. of multiplications are less than before
                // in order to reach a number, we update the dist array.
                if(steps + 1 < dist[num]) {
                    dist[num] = steps + 1;

                    // Whenever we reach the end number
                    // return the calculated steps
                    if(num == end) return steps + 1;
                    q.add(new Pair6(num, steps + 1));
                }
            }
        }
        // If the end no. is unattainable.
        return -1;
    }
}
