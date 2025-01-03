package Topics.Recursion;

import java.util.*;

//https://youtu.be/rYkfBRtMJr8?feature=shared
public class Quest9 {
    public static void main(String[] args) {
      int[] arr ={3,1,2};
        ArrayList<Integer> list = subsetSums(arr);
        System.out.println(list);
    }
    static void subsetSum(int ind, int sum, int[] arr,List<Integer> sumSubset){
        if(ind == arr.length){
            sumSubset.add(sum);
            return;
        }
        subsetSum(ind+1,sum + arr[ind],arr,sumSubset);
        subsetSum(ind+1,sum,arr,sumSubset);
    }

    static ArrayList<Integer> subsetSums(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        subsetSum(0,0,arr,list);
        Collections.sort(list);
        return list;
    }
}
