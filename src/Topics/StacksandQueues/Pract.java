package Topics.StacksandQueues;
import java.util.ArrayList;
import java.util.*;
public class Pract {
    static int largestRectangleArea(int histo[]) {
        int n = histo.length;
        Stack<Integer> st = new Stack<>();
        int maxA = 0;
        for (int i = 0; i <= n ; i++) {
            while(!st.isEmpty() && histo[st.peek()] >= histo[i]){
                int height = histo[st.peek()];
                st.pop();
                int width;
                if(st.isEmpty()){
                   width = i ;
                }else{
                    width = i - st.peek()-1;
                }
                maxA = Math.max(maxA,width*height);

            }
            st.push(i);
        }
        return maxA;
    }

}


