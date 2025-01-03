package Topics.Recursion;
import java.util.*;
//https://youtu.be/AxNNVECce8c?feature=shared
public class Quest5 {
    public static void main(String[] args) {
        int[] arr = {1,2,1};
        List<Integer> ds = new ArrayList<>();
//        subSequences(0,ds,arr);
      int count = subSequencesWithSumk3(0,ds,0,2,arr);
        System.out.println(count);
    }
    static void subSequences(int ind,List<Integer> ds,int[] arr){
        if(ind == arr.length){
            System.out.println(ds);
            return;
        }
        //take or pick the particular index into the subsequence
        ds.add(arr[ind]);
        subSequences(ind+1,ds,arr);
        ds.remove(ds.size()-1);
        //not pick or not take condition this element is not added to your subsequence
        subSequences(ind+1,ds,arr);
    }
    static void subSequencesWithSumk(int ind,List<Integer> ds,int sum,int target,int[] arr){
        if(ind == arr.length){
                if(sum == target){
                    System.out.println(ds);
                }
            return;
            }

        ds.add(arr[ind]);
        sum += arr[ind];
        subSequencesWithSumk(ind+1,ds,sum,target,arr);
        sum -= arr[ind];
        ds.remove(ds.size()-1);
        subSequencesWithSumk(ind+1,ds,sum,target,arr);
        }

    static boolean subSequencesWithSumk2(int ind,List<Integer> ds,int sum,int target,int[] arr){
        if(ind == arr.length){
            //condition is satisfied
            if(sum == target){
                System.out.println(ds);
                return true;
            }
            return false;
        }

        ds.add(arr[ind]);
        sum += arr[ind];
        if(subSequencesWithSumk2(ind+1,ds,sum,target,arr) == true){
            return true;
        }
        sum -= arr[ind];
        ds.remove(ds.size()-1);
        if(subSequencesWithSumk2(ind+1,ds,sum,target,arr)== true){
            return true;
        }
        return false;
    }
    static int subSequencesWithSumk3(int ind,List<Integer> ds,int sum,int target,int[] arr){
        if(ind == arr.length){
            //condition is satisfied
            if(sum == target){
                return 1;
            }
            return 0;
        }

        ds.add(arr[ind]);
        sum += arr[ind];
        int left = subSequencesWithSumk3(ind+1,ds,sum,target,arr);

        sum -= arr[ind];
        ds.remove(ds.size()-1);
        int right = subSequencesWithSumk3(ind+1,ds,sum,target,arr);

        return left + right;
    }


}
