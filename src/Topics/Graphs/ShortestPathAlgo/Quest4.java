package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://leetcode.com/problems/word-ladder-ii/description/
public class Quest4 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        // Push all values of wordList into a set
        // to make deletion easier and improve time complexity.
        Set<String> st = new HashSet<>(wordList);

        // Creating a queue which stores the words in a sequence required
        // to reach the targetWord after successive transformations.
        Queue<List<String>> q = new LinkedList<>();
        List<String> ls = new ArrayList<>();
        ls.add(beginWord);
        q.add(ls);

        List<String> usedOnLevel = new ArrayList<>();
        usedOnLevel.add(beginWord);
        int level = 0;

        // A list to store the resultant transformation sequences.
        List<List<String>> ans = new ArrayList<>();

        // BFS traversal with pushing the new formed sequence into the queue
        // when after a transformation, a word is found in the wordList.
        while (!q.isEmpty()) {
            List<String> vec = q.poll(); // Remove the front of the queue

            // Now, erase all words that have been
            // used in the previous levels to transform.
            if (vec.size() > level) {
                level++;
                for (String it : usedOnLevel) {
                    st.remove(it);
                }
            }

            String word = vec.get(vec.size() - 1);

            // Store the answers if the end word matches with targetWord.
            if (word.equals(endWord)) {
                // Add the sequence if the first sequence reached the end.
                if (ans.isEmpty() || ans.get(0).size() == vec.size()) {
                    ans.add(vec);
                }
            }

            // Replace each character of `word` with chars from 'a' to 'z'.
            for (int i = 0; i < word.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = c;
                    String replacedWord = new String(replacedCharArray);

                    // If replacedWord exists in the set, add it to the queue.
                    if (st.contains(replacedWord)) {
                        vec.add(replacedWord);
                        // Java works by reference, so enter the copy of `vec`
                        List<String> temp = new ArrayList<>(vec);
                        q.add(temp);
                        // Mark as visited on the level
                        usedOnLevel.add(replacedWord);
                        vec.remove(vec.size() - 1); // Backtrack
                    }
                }
            }
        }
        return ans;
    }
}
