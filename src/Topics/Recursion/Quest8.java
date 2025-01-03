package Topics.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://youtu.be/G1fRTGRxXU8?feature=shared
public class Quest8 {
    public static void main(String[] args) {
        int[]arr = {1,1,1,2,2};
        List<List<Integer>> results = combinationSum(arr,4);
        System.out.println(results);
    }
    public static void findCombinations(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
                return;
            }
        for (int i = ind; i < arr.length ; i++) {
            if( i > ind && arr[i] == arr[i-1]){
                continue;
            }
            if(arr[i]>target){
                break;
            }
            ds.add(arr[i]);
            findCombinations(i+1,arr,target-arr[i],ans,ds);
            ds.remove(ds.size()-1);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidate,int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidate);
        findCombinations(0,candidate,target,ans,new ArrayList<>());
        return ans;
    }
}
