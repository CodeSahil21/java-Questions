package Topics.Tries.Questions;
import java.util.*;
public class Quest1 {
    public static void main(String[] args) {
        // Create the root of the Trie
        TrieNode root = new TrieNode();

        // List of input words
        List<String> words = Arrays.asList("n", "ni", "nin", "ninj", "ninja", "night");

        // Find and print the longest complete string
        System.out.println(longestCompleteString(root, words));
    }
    public static void insert(TrieNode root, String word) {
        // Start from the root
        TrieNode node = root;

        // Traverse each character of the word
        for (char ch : word.toCharArray()) {
            // If child for character doesn't exist, create a new node
            node.children.putIfAbsent(ch, new TrieNode());

            // Move to the next node
            node = node.children.get(ch);
        }

        // Mark the end of the word
        node.isEnd = true;
    }
    // Check if all prefixes of a word are present in the Trie
    public static boolean allPrefixesExist(TrieNode root, String word) {
        // Start from the root
        TrieNode node = root;

        // Check each character one by one
        for (char ch : word.toCharArray()) {
            // Move to the next character node
            node = node.children.get(ch);

            // If node is missing or prefix not marked as word end, return false
            if (node == null || !node.isEnd)
                return false;
        }

        // All prefixes exist
        return true;
    }
    // Find the longest complete string
    public static String longestCompleteString(TrieNode root, List<String> words) {
        // Insert all words into the Trie
        for (String word : words)
            insert(root, word);

        String ans = "";

        // Check each word to see if it's a complete string
        for (String word : words) {
            if (allPrefixesExist(root, word)) {
                // Update if it's longer or lexicographically
                // smaller than current answer
                if (word.length() > ans.length() ||
                        (word.length() == ans.length() && word.compareTo(ans) < 0))
                    ans = word;
            }
        }

        // If no valid complete string found, return "None"
        return ans.isEmpty() ? "None" : ans;
    }
}
class TrieNode {
    // Indicates end of a valid word
    boolean isEnd;
    Map<Character, TrieNode> children;

    TrieNode() {
        isEnd = false;
        children = new HashMap<>();
    }
}