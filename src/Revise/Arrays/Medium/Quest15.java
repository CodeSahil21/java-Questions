package Revise.Arrays.Medium;

import java.util.ArrayList;

public class Quest15 {
    public static void main(String args[]){

        int[] arr=  {10, 22, 12, 3, 0, 6};
        ArrayList<Integer> ans= printLeaders(arr);

        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i)+" ");
        }

    }
    static ArrayList<Integer> printLeaders(int[] arr){
        ArrayList<Integer> list = new ArrayList<>();
        int max = arr[arr.length-1];
        list.add(max);
        for(int i = arr.length-2 ; i>= 0;i--){
            if(arr[i] > max){
                list.add(arr[i]);
                max = arr[i];
            }
        }
        return list;
    }
}
