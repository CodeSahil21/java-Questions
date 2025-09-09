package Topics.Graphs.ShortestPathAlgo;
import java.util.*;
//https://leetcode.com/problems/word-ladder/description/
class Pair2 {
    String first;
    int second;
    Pair2(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}
public class Quest3 {
    public static void main(String[] args) {
        String startWord = "der", targetWord = "dfs";
        String[] wordList = {
                "des",
                "der",
                "dfr",
                "dgt",
                "dfs"
        };
        List<String> wordListAsList = Arrays.asList(wordList);
        int ans = ladderLength(startWord, targetWord, wordListAsList);

        System.out.print(ans);
    }
    public static int ladderLength(String startWord, String targetWord, List<String> wordList) {
        // Creating a queue ds of type {word, transitions to reach ‘word’}.
        Queue<Pair2> q = new LinkedList<>();

        // BFS traversal with pushing values in queue
        // when after a transformation, a word is found in wordL  ist.
        q.add(new Pair2(startWord, 1));

        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set<String> st = new HashSet<>(wordList);
        st.remove(startWord);

        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();

            // Return the steps as soon as
            // the first occurrence of targetWord is found.
            if (word.equals(targetWord)) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] replacedCharArray = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // Check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord)) {
                        st.remove(replacedWord);
                        q.add(new Pair2(replacedWord, steps + 1));
                    }
                }
            }
        }

        // If there is no transformation sequence possible.
        return 0;
    }
}
