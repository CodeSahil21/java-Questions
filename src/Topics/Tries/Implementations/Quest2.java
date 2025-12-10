package Topics.Tries.Implementations;

public class Quest2 {
    public static void main(String[] args) {
        Trie1 trie = new Trie1();

        // 1. Insertion
        trie.insert("apple");
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apricot");
        System.out.println("--- Insertion Complete ---");

        // 2. countWordsEqualTo
        System.out.println("\n--- countWordsEqualTo ---");
        System.out.println("Count for 'apple': " + trie.countWordsEqualTo("apple")); // Expected: 2
        System.out.println("Count for 'app': " + trie.countWordsEqualTo("app"));     // Expected: 1
        System.out.println("Count for 'apr': " + trie.countWordsEqualTo("apr"));     // Expected: 0
        System.out.println("Count for 'banana': " + trie.countWordsEqualTo("banana")); // Expected: 0

        // 3. countWordsStartingWith
        System.out.println("\n--- countWordsStartingWith ---");
        System.out.println("Count for prefix 'ap': " + trie.countWordsStartingWith("ap")); // Expected: 4 ("apple", "apple", "app", "apricot")
        System.out.println("Count for prefix 'app': " + trie.countWordsStartingWith("app")); // Expected: 2 ("apple", "apple")
        System.out.println("Count for prefix 'apr': " + trie.countWordsStartingWith("apr")); // Expected: 1 ("apricot")
        System.out.println("Count for prefix 'a': " + trie.countWordsStartingWith("a"));   // Expected: 4

        // 4. erase
        trie.erase("apple");
        System.out.println("\n--- Erasing 'apple' ---");
        System.out.println("Count for 'apple' after erase: " + trie.countWordsEqualTo("apple")); // Expected: 1
        System.out.println("Count for prefix 'app' after erase: " + trie.countWordsStartingWith("app")); // Expected: 1 (only "apple" remains)

        trie.erase("app");
        System.out.println("\n--- Erasing 'app' ---");
        System.out.println("Count for 'app' after erase: " + trie.countWordsEqualTo("app")); // Expected: 0
        System.out.println("Count for prefix 'ap' after erase: " + trie.countWordsStartingWith("ap")); // Expected: 2 ("apple", "apricot")
    }
}
class Trie1 {
    static class Node {
        Node[] links;
        int cntEndWith;
        int cntPrefix;

        Node() {
            links = new Node[26];
            cntEndWith = 0;
            cntPrefix = 0;
        }

        boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        Node get(char ch) {
            return links[ch - 'a'];
        }

        void put(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        void increaseEnd() {
            cntEndWith++;
        }

        void increasePrefix() {
            cntPrefix++;
        }

        void deleteEnd() {
            cntEndWith--;
        }

        void reducePrefix() {
            cntPrefix--;
        }
    }

    private Node root;

    Trie1() {
        root = new Node();
    }

    void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.increaseEnd();
    }

    int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.cntEndWith;
    }

    int countWordsStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.cntPrefix;
    }

    void erase(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }
        }
        node.deleteEnd();
    }
}