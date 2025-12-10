package Topics.Tries.Questions;
import java.util.*;
public class Quest3 {

}
class Trie1 {
    class Node1 {
        Node1[] links = new Node1[2];

        // Check if bit path exists
        public boolean containsKey(int bit) {
            return links[bit] != null;
        }

        // Get child node for the bit
        public Node1 get(int bit) {
            return links[bit];
        }

        // Set child node for the bit
        public void put(int bit, Node1 node) {
            links[bit] = node;
        }
    }
    Node1 root = new Node1();

    // Insert number into the Trie
    public void insert(int num) {
        Node1 node = root;
        for (int i = 31; i >= 0; i--) {
            // Get the i-th bit
            int bit = (num >> i) & 1;

            // Create path if not present
            if (!node.containsKey(bit)) {
                node.put(bit, new Node1());
            }

            // Move to next node
            node = node.get(bit);
        }
    }
    public int getMaxXOR(int num) {
        Node1 node = root;
        int maxXor = 0;

        for (int i = 31; i >= 0; i--) {
            // Get the i-th bit
            int bit = (num >> i) & 1;

            // Try opposite bit for max XOR
            if (node.containsKey(1 - bit)) {
                maxXor |= (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }

        return maxXor;
    }
    public int findMaximumXOR(int[] nums) {
        for (int num : nums) {
            insert(num);
        }

        int maxResult = 0;
        for (int num : nums) {
            maxResult = Math.max(maxResult, getMaxXOR(num));
        }

        return maxResult;
    }
}