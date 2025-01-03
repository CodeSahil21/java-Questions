package Topics.Arrays.Hard;
import java.util.*;
//https://takeuforward.org/data-structure/length-of-the-longest-subarray-with-zero-sum/
public class Quest5 {



    int maxLen(int[] A)
    {
        int n= A.length;
        // Your code here
        HashMap<Integer, Integer> mpp = new HashMap<>();

        int maxi = 0;
        int sum = 0;

        for(int i = 0;i<n;i++) {

            sum += A[i];

            if(sum == 0) {
                maxi = i + 1;
            }
            else {
                if(mpp.get(sum) != null) {

                    maxi = Math.max(maxi, i - mpp.get(sum));
                }
                else {

                    mpp.put(sum, i);
                }
            }
        }
        return maxi;
    }
}
