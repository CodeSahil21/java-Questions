package Revise.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Quest4 {
    public static void main(String[] args) {
        int[] nums = {4, 3, 3, 4, 4, 2, 1, 2, 1, 1};
        int target = 9;
        List<List<Integer>> ans = fourSum(nums, target);
        System.out.println("The quadruplets are: ");
        for (List<Integer> it : ans) {
            System.out.print("[");
            for (int ele : it) {
                System.out.print(ele + " ");
            }
            System.out.print("] ");
        }
        System.out.println();
    }

    static List<List<Integer>> fourSum(int[] arr,int target){
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        for(int i = 0 ; i < arr.length;i++){
            if(i!= 0 && arr[i] == arr[i-1]){
                continue;
            }
            for(int j = i+1;j < arr.length;j++){
                if(j > i+1 &&  arr[j] == arr[j-1]){
                    continue;
                }

                int k = j+1;
                int l = arr.length-1;
                while(k < l){
                    long sum = 0;
                    sum += arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];
                    if( sum == target){
                        List<Integer> temp = Arrays.asList(arr[i],arr[j],arr[k],arr[l]);
                        ans.add(temp);
                        k++;
                        l--;
                        while(k < l && arr[k] == arr[k-1]){
                            k++;
                        }
                        while(k < l && arr[l] == arr[l+1]){
                            l--;
                        }
                    }else if( sum < target){
                        k++;
                    }else if(sum > target){
                        l--;
                    }
                }
            }

        }
        return ans;
    }
}
