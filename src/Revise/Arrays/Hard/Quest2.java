package Revise.Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class Quest2 {
    public static void main(String[] args) {
        int[] arr = {11, 33, 33, 11, 33, 11};
        List<Integer> ans = majorityElement(arr);
        System.out.print("The majority elements are: ");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();

    }
    static List<Integer> majorityElement(int[] arr){
        int count1 = 0;
        int count2 = 0;
        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MIN_VALUE;
        for(int i = 0 ; i < arr.length;i++){
            if(count1 == 0 && ele2 != arr[i]){
                count1 += 1;
                ele1 = arr[i];
            }else if(count2 == 0 && ele1 != arr[i]){
                count2 += 1;
                ele2 = arr[i];
            }else if(arr[i] == ele1){
                count1++;
            }else if(arr[i] == ele2){
                count2++;
            }else{
                count1--;
                count2--;
            }
        }
        int c1 = 0;
        int c2 = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i <arr.length;i++){
            if(arr[i] == ele1){
                c1++;
            }
            if(arr[i]== ele2){
                c2++;
            }
        }
        int mini = arr.length/3 +1;
        if(c1 >= mini ){
            list.add(ele1);
        }
        if(c2 >= mini){
            list.add(ele2);
        }
        return list;
    }
}
