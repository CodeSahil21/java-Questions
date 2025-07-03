package Revise.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Quest3 {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = threeSum( arr);
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (Integer i : it) {
                System.out.print(i + " ");
            }
            System.out.print("] ");
        }
        System.out.println();

    }

    static List<List<Integer>> threeSum(int[] arr){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0; i < arr.length;i++){
            if(i!= 0 && arr[i] == arr[i-1]){
                continue;
            }
            int j = i+1;
            int k = arr.length-1;
            while(j < k){
                int sum = arr[i] + arr[j] + arr[k];
                if(sum < 0){
                    j++;
                }else if(sum > 0){
                    k--;
                }else{
                    List<Integer> list = Arrays.asList(arr[i],arr[j],arr[k]);
                    ans.add(list);
                    j++;
                    k--;
                    while(j < k && arr[j] == arr[j-1]){
                        j++;
                    }
                    while(j < k && arr[k] == arr[k+1]){
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}
