package Revise.Arrays.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Quest7 {

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

    public List<List<Integer>> mergeOverlappingIntervals(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < arr.length;i++){
            int start = arr[i][0];
            int end = arr[i][1];

            if(!ans.isEmpty() && end <= ans.get(ans.size()-1).get(1)){
                continue;
            }
            for(int  j = i+1 ; j < arr.length;j++ ){
                if(arr[j][0] <= end){
                    end = Math.max(end,arr[j][1]);
                }
            }
            ans.add(Arrays.asList(start,end));
        }
        return ans;
    }
}
