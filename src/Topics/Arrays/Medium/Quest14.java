package Topics.Arrays.Medium;
//https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
//
import java.util.*;
public class Quest14 {
    public static void main(String[] args) {
         
    }


    public static  int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];//array length will always be even
        int posIndex = 0;//positive element occupy even index like 0,2,4,...
        int negIndex = 1;//negative elements occupy odd index like 1,3,5,...
        for(int i = 0; i<nums.length;i++){
            if(nums[i]<0){
                ans[negIndex] = nums[i];
                negIndex +=2;
            }else{
                ans[posIndex] = nums[i];
                posIndex += 2;
            }
        }
        return ans;
    }
    public static ArrayList<Integer> RearrangebySign(ArrayList<Integer> A, int n) {
        // Define 2 ArrayLists, one for storing positive
        // and other for negative elements of the array.
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Segregate the array into positives and negatives.
        for (int i = 0; i < n; i++) {
            if (A.get(i) > 0)
                pos.add(A.get(i));
            else
                neg.add(A.get(i));
        }

        // If positives are lesser than the negatives.
        if (pos.size() < neg.size()) {

            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < pos.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining negatives at the end of the array.
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                A.set(index, neg.get(i));
                index++;
            }
        }

        // If negatives are lesser than the positives.
        else {
            // First, fill array alternatively till the point
            // where positives and negatives are equal in number.
            for (int i = 0; i < neg.size(); i++) {
                A.set(2 * i, pos.get(i));
                A.set(2 * i + 1, neg.get(i));
            }

            // Fill the remaining positives at the end of the array.
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                A.set(index, pos.get(i));
                index++;
            }
        }
        return A;
    }
}
