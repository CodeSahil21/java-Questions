package Topics.StacksandQueues.Quest;

import java.util.*;

//https://leetcode.com/problems/asteroid-collision/description/
public class Quest7 {
    public static int[] asteroidCollision(int[] arr) {
        List<Integer> st = new ArrayList<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                st.add(arr[i]);
            } else {
                while (!st.isEmpty() && st.get(st.size() - 1) > 0 && st.get(st.size() - 1) < Math.abs(arr[i])) {
                    st.remove(st.size() - 1);
                }

                if (!st.isEmpty() && st.get(st.size() - 1) == Math.abs(arr[i])) {
                    st.remove(st.size() - 1);
                } else if (st.isEmpty() || st.get(st.size() - 1) < 0) {
                    st.add(arr[i]);
                }
            }
        }

        int[] result = new int[st.size()];
        for (int i = 0; i < st.size(); i++) {
            result[i] = st.get(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        for (int asteroid : result) {
            System.out.print(asteroid + " ");
        }
    }
}
