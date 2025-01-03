package Topics.Recursion;
import java.util.*;
//https://youtu.be/RIn3gOkbhQE?feature=shared
public class Quest10 {
    public static void main(String[] args) {

    }
   public void findSubSets(int ind, int[] nums,List<Integer> ds,List<List<Integer>> ans){
        ans.add(new ArrayList<>(ds));
       for (int i = ind; i < nums.length ; i++) {
           if(i!= ind && nums[i] == nums[i-1]){
               continue;
           }
           ds.add(nums[i]);
           findSubSets(i+1,nums,ds,ans);
           ds.remove(ds.size()-1);
       }
   }

   public List<List<Integer>> subsetwithDup(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        findSubSets(0,nums,new ArrayList<>(),ans);
        return ans;
   }
}
