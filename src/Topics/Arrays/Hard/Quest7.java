package Topics.Arrays.Hard;
//https://leetcode.com/problems/merge-intervals/description/
import java.util.*;
public class Quest7 {
    public static void main(String[] args) {

    }
    public int[][] merge(int[][] nums) {
        Arrays.sort(nums,new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return a[0] - b[0];
            }
        });
        List<int[]> ans = new ArrayList<>();
        for(int i = 0; i< nums.length;i++){
            if(ans.isEmpty()||nums[i][0] > ans.get(ans.size()-1)[1]){
                ans.add(nums[i]);
            }else{
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1],nums[i][1]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }



    public static List<List<Integer>> mergeOverlappingIntervals(int[][] arr) {
        int n = arr.length; // size of the array
        //sort the given intervals:
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) { // select an interval:
            int start = arr[i][0];
            int end = arr[i][1];

            //Skip all the merged intervals:
            if (!ans.isEmpty() && end <= ans.get(ans.size() - 1).get(1)) {
                continue;
            }

            //check the rest of the intervals:
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                } else {
                    break;
                }
            }
            ans.add(Arrays.asList(start, end));
        }
        return ans;
    }
}
