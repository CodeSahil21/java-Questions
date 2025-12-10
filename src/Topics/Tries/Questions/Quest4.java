package Topics.Tries.Questions;

import java.util.*;

public class Quest4 {
    public int[] maxXorQueries(int[] arr, int[][] queries) {

        // Result array initialized to size of queries
        int[] ans = new int[queries.length];

        // List to store queries in {m, x, original_index} format for offline processing
        List<int[]> offlineQueries = new ArrayList<>();

        // Sort the input array 'arr' in ascending order
        Arrays.sort(arr);

        // Store queries with index for mapping answers later
        for (int k = 0; k < queries.length; k++) {
            int x = queries[k][0];
            int m = queries[k][1];
            // Store as {m, x, original_index}
            offlineQueries.add(new int[]{m, x, k});
        }

        // Sort queries based on the limit 'm' (it[0])
        offlineQueries.sort(Comparator.comparingInt(a -> a[0]));

        // Initialize a new Trie for this set of queries
        Trie trie = new Trie();

        // Pointer for array 'arr' traversal
        int i = 0;
        int n = arr.length;

        // Process each query in sorted order of 'm'
        for (int[] it : offlineQueries) {
            int m = it[0]; // limit
            int x = it[1]; // xor value
            int originalIndex = it[2]; // original index

            // Insert all elements from 'arr' (arr[i]) that are <= current limit 'm'
            while (i < n && arr[i] <= m) {
                trie.insert(arr[i]);
                i++;
            }

            // If the trie has at least one element (i.e., i != 0)
            if (i != 0) {
                ans[originalIndex] = trie.findMax(x);
            }
            // If no elements in 'arr' are <= m, no valid XOR is possible
            else {
                ans[originalIndex] = -1;
            }
        }
        return ans;
    }
}
class Node2 {
    // Array to hold links to child nodes (0 and 1)
    Node2[] links = new Node2[2];

    // Function to check if a child node exists for a given bit
    boolean containsKey(int ind) {
        return links[ind] != null;
    }

    // Function to get the child node for a given bit
    Node2 get(int ind) {
        return links[ind];
    }

    // Function to create a link to a child node for a given bit
    void put(int ind, Node2 node) {
        links[ind] = node;
    }
}

// Class for Trie operations
class Trie {
    // Pointer to the root node
    private Node2 root;

    // Constructor to initialize the trie
    Trie() {
        root = new Node2();
    }

    // Function to insert a number into the trie
    void insert(int num) {
        // Start from root
        Node2 node = root;

        // Traverse bits from MSB (31) to LSB (0)
        for (int i = 31; i >= 0; i--) {
            // Extract the current bit
            int bit = (num >> i) & 1;

            // If path for this bit doesn't exist, create it
            if (!node.containsKey(bit)) {
                node.put(bit, new Node2());
            }

            // Move to the next node
            node = node.get(bit);
        }
    }

    // Function to find maximum XOR for a given number
    int findMax(int num) {
        // Start from root
        Node2 node = root;

        // Variable to store maximum XOR result
        int maxNum = 0;

        // Traverse bits from MSB to LSB
        for (int i = 31; i >= 0; i--) {
            // Extract the current bit
            int bit = (num >> i) & 1;

            // Try to take the opposite bit for maximizing XOR
            if (node.containsKey(1 - bit)) {
                // Set this bit in the result
                maxNum = maxNum | (1 << i);

                // Move to the opposite branch
                node = node.get(1 - bit);
            }
            // If opposite bit doesn't exist, move to same bit branch
            else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}