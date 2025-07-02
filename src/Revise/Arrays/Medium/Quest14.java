package Revise.Arrays.Medium;
import java.util.ArrayList;
import java.util.Arrays;
public class Quest14 {
    public static void main(String[] args) {
        int[] input = {3, 1, -2, -5, 2, -4};
        int[] result = rearrangeArray(input);

        System.out.print("Rearranged array: ");
        for (int num : result) {
            System.out.print(num + " ");
        }

        ArrayList<Integer> newInput = new ArrayList<>(Arrays.asList(3, -1, -2, 4, -5, 6, -7));
        ArrayList<Integer> output = rearrangeArray2(newInput);

        System.out.println("Rearranged ArrayList: " + output);
    }
    //for array with equal no of positve and negative no's
    static int[] rearrangeArray(int[] arr){
        int[] ans = new int[arr.length];
        int posIndex = 0;
        int negIndex = 1;
        for(int i = 0; i< arr.length;i++){
            if(arr[i] < 0){
                ans[negIndex] = arr[i];
                negIndex += 2;
            }else{
                ans[posIndex] = arr[i];
                posIndex += 2;
            }
        }
        return ans;
    }

    static  ArrayList<Integer> rearrangeArray2(ArrayList<Integer> A){
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for(int i = 0 ; i < A.size();i++){
            if(A.get(i) > 0){
                pos.add(A.get(i));
            }else{
                neg.add(A.get(i));
            }
        }
        if(pos.size() < neg.size()){
            for(int i = 0 ; i < pos.size();i++){
                A.set(2*i,pos.get(i));
                A.set(2*i+1,neg.get(i));
            }
            int index = pos.size() *2;
            for(int i = pos.size(); i < neg.size();i++){
                A.set(index,neg.get(i));
                index++;
            }
        }else{
            for(int i = 0 ; i < neg.size();i++){
                A.set(2*i,pos.get(i));
                A.set(2*i+1,neg.get(i));
            }
            int index = neg.size() *2;
            for(int i = neg.size(); i< pos.size();i++){
                A.set(index,pos.get(i));
                index++;
            }
        }
        return A;
    }
}
