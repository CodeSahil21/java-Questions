package Topics.Recursion;
import java.util.*;
//https://youtu.be/OyZFFqQtu98?feature=shared
public class Quest7 {
    public static void main(String[] args) {
        int[]arr = {2,3,4,7};
        List<List<Integer>> results = combinationSum(arr,7);
        System.out.println(results);
    }
    public static void findCombinations(int ind,int[] arr,int target,List<List<Integer>> ans,List<Integer> ds){
        if(ind == arr.length){
            if(target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(arr[ind] <= target){
            ds.add(arr[ind]);
            findCombinations(ind,arr,target-arr[ind],ans,ds);
            ds.remove(ds.size()-1);
        }
        findCombinations(ind+1,arr,target,ans,ds);
    }

    public static List<List<Integer>> combinationSum(int[] candidate,int target){
        List<List<Integer>> ans = new ArrayList<>();
        findCombinations(0,candidate,target,ans,new ArrayList<>());
        return ans;
    }
}
